package defaultpackage;


import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

public class HandlerTest implements Handler {

    @Override
    public boolean handleMessage(MessageContext context) {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

}
