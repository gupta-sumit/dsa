package coffeemachine.ingredients;

public interface IngredientProvider {

    public IngredientAcquireStatus getRequiredIngredient(Ingredient ingredient, int quantity);


    // Just for debugging purpose.
    void printIngredientAvailability();
}
