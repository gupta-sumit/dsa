package design.callcenter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CallHandlerPoolImpl implements CallHandlerPool{

    public LinkedList<CallHandler> freeCallHandlerList;
    public LinkedList<CallHandler> busyCallHandlerList;
    private final Level level;

    public CallHandlerPoolImpl(List<CallHandler> callHandlerList, Level level) {
        this.level = level;
        checkIfLevelSame(callHandlerList,level);
        this.freeCallHandlerList = new LinkedList<>(callHandlerList);
        this.busyCallHandlerList = new LinkedList<>();

    }

    private void checkIfLevelSame(List<CallHandler> callHandlerList, Level level) {
        Optional<CallHandler> first = callHandlerList.stream().filter(callHandler -> !level.equals(callHandler.level()))
                .findFirst();
        if(first.isPresent()) {
            throw new IllegalArgumentException("All employee level must be same");
        }
    }

    @Override
    public Level level() {
        return level;
    }

    @Override
    public Optional<CallHandler> allocateIfAvailable(long waitTime) {
        if(!freeCallHandlerList.isEmpty()) {
            CallHandler callHandler = freeCallHandlerList.removeFirst();
            busyCallHandlerList.add(callHandler);
            return Optional.of(callHandler);
        }
        return Optional.empty();
    }

    @Override
    public void release(CallHandler callHandler) {
        boolean remove = busyCallHandlerList.remove(callHandler);
        if(!remove) {
            throw new IllegalArgumentException("Call Handler not found");
        }
        freeCallHandlerList.add(callHandler);
    }
}
