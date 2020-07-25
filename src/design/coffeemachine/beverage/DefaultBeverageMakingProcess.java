package coffeemachine.beverage;

import coffeemachine.error.Error;
import coffeemachine.ingredients.Ingredient;
import coffeemachine.ingredients.IngredientAcquireStatus;
import coffeemachine.ingredients.IngredientProvider;
import coffeemachine.error.InsufficientIngredientError;
import coffeemachine.error.SystemUnderMaintenanceError;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultBeverageMakingProcess implements BeverageMakingProcess{

    private String name;
    private LinkedHashMap<Ingredient, Integer> requiredIngredients;
    private IngredientProvider ingredientProvider;

    public DefaultBeverageMakingProcess(String name, LinkedHashMap<Ingredient, Integer> requiredIngredients, IngredientProvider ingredientProvider) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
        this.ingredientProvider = ingredientProvider;
    }

    @Override
    public Beverage execute() {
        for(Map.Entry<Ingredient,Integer> requiredIngredient: requiredIngredients.entrySet()) {
            IngredientAcquireStatus ingredientStatus = ingredientProvider.getRequiredIngredient(requiredIngredient.getKey(), requiredIngredient.getValue());
            if(ingredientStatus.isAcquired()) {
                process(requiredIngredient.getKey(), requiredIngredient.getValue());
            } else {
                return failWithError(requiredIngredient.getKey(), ingredientStatus);
            }
        }
        return Beverage.success(name);
    }

    private Beverage failWithError(Ingredient ingredient, IngredientAcquireStatus ingredientStatus) {
        switch (ingredientStatus.getStatus()) {
            case INSUFFICIENT_QUANTITY_AVAILABLE:
                return Beverage.failed(new InsufficientIngredientError(ingredient, ingredientStatus.getRemainingQuantity()),name);
            case SYSTEM_UNDER_MAINTENANCE:
                return Beverage.failed(new SystemUnderMaintenanceError(),name);
        }
        return Beverage.failed(new Error("Unknown"),name);
    }

    private void process(Ingredient ingredient, Integer value) {
        System.out.println("Processing " + ingredient + " quantity " + value);
    }
}
