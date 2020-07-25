package design.callcenter;

public class Connection {

    private final CallCenterController controller;
    private final CallHandler callHandler;

    public Connection(CallCenterController controller, CallHandler callHandler) {
        this.controller = controller;
        this.callHandler = callHandler;
    }

    public Message talk(Message request) {
        return callHandler.handleCall(request);
    }

    public void disconnect() {
        controller.release(this);
    }

    public CallHandler getCallHandler() {
        return callHandler;
    }
}
