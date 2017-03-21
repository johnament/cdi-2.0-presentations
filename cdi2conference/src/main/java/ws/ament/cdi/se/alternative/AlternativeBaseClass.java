package ws.ament.cdi.se.alternative;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
@Priority(500)
public class AlternativeBaseClass extends BaseClass {
}
