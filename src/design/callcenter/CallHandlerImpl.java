package design.callcenter;

import algo.utils.ConsolePrinter;

import java.util.Objects;

public class CallHandlerImpl implements CallHandler{

    private final Level level;
    private String id;
    private final String name;

    public CallHandlerImpl(Level level, String name) {
        this.id = name;
        this.level = level;
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Level level() {
        return level;
    }

    @Override
    public Message handleCall(Message message) {
        ConsolePrinter.out("Received Message  : " + message.value);
        return new Message("Hi! How are you");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallHandlerImpl that = (CallHandlerImpl) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
