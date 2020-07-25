package coffeemachine.ingredients;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class IngredientAvailability {

    private final Ingredient ingredient;
    private volatile int availableQuantity = 0;
    private ReentrantLock lock = new ReentrantLock();

    public IngredientAvailability(Ingredient ingredient, int availableQuantity) {
        this.ingredient = ingredient;
        if(availableQuantity < 0) {
            throw new IllegalArgumentException("Invalid Quantity " + availableQuantity);
        }
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void fill(int quantity) {
        if(quantity < 1) {
            throw new IllegalArgumentException("Invalid Quantity");
        }
        try {
            lock.lock();
            availableQuantity = availableQuantity + quantity;
        } finally {
            lock.unlock();
        }
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public IngredientAcquireStatus get(int quantity, long timeToWaitInSec) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity " + quantity);
        }
        if(timeToWaitInSec < 0) {
            throw new IllegalArgumentException("Invalid timeToWaitInSec " + timeToWaitInSec);
        }
        boolean locked = false;
        try {
            if(lock.tryLock(timeToWaitInSec, TimeUnit.SECONDS)) {
                locked = true;
                if(quantity > availableQuantity) {
                    return IngredientAcquireStatus.insufficientQuantityAvailable(availableQuantity);
                } else {
                    availableQuantity = availableQuantity - quantity;
                    return IngredientAcquireStatus.acquired(availableQuantity);
                }
            }
        } catch (InterruptedException e) {
            // Use logger to print error
        } finally {
            if(locked) {
                lock.unlock();
            }
        }
        return IngredientAcquireStatus.systemUnderMaintenance();
    }
}

