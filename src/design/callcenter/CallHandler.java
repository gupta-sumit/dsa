package design.callcenter;

public interface CallHandler {

    public String name();

    public Level level();

    public Message handleCall(Message message);
}
