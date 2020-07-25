package coffeemachine.error;

public class SystemUnderMaintenanceError extends Error{
    public SystemUnderMaintenanceError() {
        super("System Under Maintenance");
    }
}
