package ws.ament.cdi.se.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;

@ApplicationScoped
public class ChannelReadHandler extends ChannelInboundHandlerAdapter {
    @Inject
    private TimeProvider timeProvider;

    @Override
    @ActivateRequestContext
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            System.out.print("Time :"+timeProvider.getCurrentTime()+" data: ");
            while (in.isReadable()) {
                System.out.print((char) in.readByte());
            }
            System.out.flush();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}