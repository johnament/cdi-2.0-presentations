package ws.ament.cdi.se.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import javax.enterprise.context.ContextException;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.context.control.RequestContextController;
import javax.inject.Inject;

@Dependent
public class ChannelReadHandler extends ChannelInboundHandlerAdapter {
    @Inject
    private TimeProvider timeProvider;
    @Inject
    private RequestContextController requestContextController;
    @Override
    @ActivateRequestContext
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            boolean wasActivated = false;
            try {
                wasActivated = requestContextController.activate();
            } catch (ContextException e) {

            }
            System.out.print("Time :"+timeProvider.getCurrentTime()+" data: ");
            requestContextController.deactivate();

            requestContextController.activate();
            System.out.print("Time :"+timeProvider.getCurrentTime()+" data: ");
            requestContextController.deactivate();

            while (in.isReadable()) {
                System.out.print((char) in.readByte());
            }
            System.out.flush();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}