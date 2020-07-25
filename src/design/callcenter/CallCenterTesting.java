package design.callcenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CallCenterTesting {

    public static void main(String[] args) {
        Level callRespondentLevel = new Level(1, Role.CALL_RESPONODENT);
        Level managerLevel = new Level(2, Role.MANAGER);
        Level directorLevel = new Level(3, Role.DIRECTOR);

        List<CallHandlerPool> callHandlerPoolList = new ArrayList<>();
        List<CallHandler> level1CallHandlerList = new ArrayList<>();
        for(int i=0; i < 3; i++) {
            level1CallHandlerList.add(new CallHandlerImpl(callRespondentLevel, "call" + i));
        }
        callHandlerPoolList.add(new CallHandlerPoolImpl(level1CallHandlerList, callRespondentLevel));
        List<CallHandler> level2CallHandlerList = new ArrayList<>();
        for(int i=0; i < 2; i++) {
            level2CallHandlerList.add(new CallHandlerImpl(managerLevel, "manager" + i));
        }
        callHandlerPoolList.add(new CallHandlerPoolImpl(level2CallHandlerList, managerLevel));
        List<CallHandler> level3CallHandler = Arrays.asList(new CallHandlerImpl(directorLevel, "director"));
        callHandlerPoolList.add(new CallHandlerPoolImpl(level3CallHandler, directorLevel));
        CallCenterController callCenterController = new CallCenterController(callHandlerPoolList);

        Optional<Connection> connection = callCenterController.dispatchCall();
        if(connection.isPresent()) {
            System.out.println("Talking to " + connection.get().getCallHandler().name() + " " + connection.get().talk(new Message("Hi")).value);
        }
        List<Connection> connections = new ArrayList<>();
        for(int i=0; i < 5; i++) {
            callCenterController.dispatchCall().ifPresent(c -> {
                connections.add(c);
                System.out.println("Talking to " + c.getCallHandler().name() + " " + c.talk(new Message("Hi")).value);
            });
        }
        connections.remove(0).disconnect();
        callCenterController.dispatchCall().ifPresent(c -> {
            connections.add(c);
            System.out.println("Talking to " + c.getCallHandler().name() + " " + c.talk(new Message("Hi")).value);
        });
        connections.forEach(Connection::disconnect);

    }
}
