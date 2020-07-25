package design.callcenter;

import java.util.Optional;

public interface CallHandlerPool {

    public Level level();

    public Optional<CallHandler> allocateIfAvailable(long waitTime);

    public void release(CallHandler callHandler);

}
