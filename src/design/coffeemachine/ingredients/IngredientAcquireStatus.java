package coffeemachine.ingredients;

public class IngredientAcquireStatus {

    private Status status;
    private int remainingQuantity = -1;

    private IngredientAcquireStatus(Status status, int remainingQuantity) {
        this.status = status;
        this.remainingQuantity = remainingQuantity;
    }

    public boolean isAcquired() {
        return status != null && status == Status.ACQUIRED;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public enum Status {
        ACQUIRED, INSUFFICIENT_QUANTITY_AVAILABLE,SYSTEM_UNDER_MAINTENANCE;
    }

    public Status getStatus() {
        return status;
    }

    public static IngredientAcquireStatus acquired(int remainingQuantity) {
        return new IngredientAcquireStatus(Status.ACQUIRED, remainingQuantity);
    }


    public static IngredientAcquireStatus systemUnderMaintenance() {
        return new IngredientAcquireStatus(Status.SYSTEM_UNDER_MAINTENANCE, -1);
    }


    public static IngredientAcquireStatus insufficientQuantityAvailable(int remainingQuantity) {
        return new IngredientAcquireStatus(Status.INSUFFICIENT_QUANTITY_AVAILABLE, remainingQuantity);
    }
}
