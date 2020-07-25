package design.callcenter;

import java.util.*;

public class CallCenterController {

    private Map<Level, CallHandlerPool> callHandlerPoolMap;

    public CallCenterController(List<CallHandlerPool> callHandlerPoolList) {
        callHandlerPoolMap = new TreeMap<>();
        for(CallHandlerPool callHandlerPool : callHandlerPoolList) {
            callHandlerPoolMap.put(callHandlerPool.level(), callHandlerPool);
        }
    }

    public Optional<Connection> dispatchCall() {
        Set<Map.Entry<Level, CallHandlerPool>> entries = callHandlerPoolMap.entrySet();
        for(Map.Entry<Level, CallHandlerPool> entry : entries) {
            Optional<CallHandler> callHandler = entry.getValue().allocateIfAvailable(0);
            if(callHandler.isPresent()) {
                Connection connection = new Connection(this, callHandler.get());
                return Optional.of(connection);
            }
        }
        return Optional.empty();
    }

    public void release(Connection connection) {
        CallHandler callHandler = connection.getCallHandler();
        CallHandlerPool callHandlerPool = callHandlerPoolMap.get(callHandler.level());
        callHandlerPool.release(callHandler);
    }
}
