package coffeemachine.error;

import coffeemachine.ingredients.Ingredient;

public class InsufficientIngredientError extends Error {

    public InsufficientIngredientError(Ingredient ingredient, int quantity) {
        super("Ingredient " + ingredient.getName() + " is not sufficient to make beverage. Available Quantity " + quantity);
    }
}
