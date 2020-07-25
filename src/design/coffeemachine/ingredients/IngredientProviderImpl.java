package coffeemachine.ingredients;

import java.util.Map;
import java.util.Set;

public class IngredientProviderImpl implements IngredientProvider, IngredientManager{

    private Map<Ingredient,IngredientAvailability> ingredientAvailabilityMap;

    public IngredientProviderImpl(Map<Ingredient,IngredientAvailability> ingredientAvailabilityMap) {
        if(null == ingredientAvailabilityMap || ingredientAvailabilityMap.isEmpty()) {
            throw new IllegalArgumentException("Invalid ingredientAvailabalityMap ");
        }
        this.ingredientAvailabilityMap = ingredientAvailabilityMap;
    }

    @Override
    public void fill(Ingredient ingredient, int quantity) {
        validate(ingredient);
        ingredientAvailabilityMap.get(ingredient).fill(quantity);
    }

    @Override
    public IngredientAcquireStatus getRequiredIngredient(Ingredient ingredient, int quantity) {
        validate(ingredient);
        return ingredientAvailabilityMap.get(ingredient).get(quantity, 1);
    }



    @Override
    public void printIngredientAvailability() {
        System.out.println("========== Ingriedient Availability Status ==========");
        Set<Map.Entry<Ingredient, IngredientAvailability>> entries = ingredientAvailabilityMap.entrySet();
        entries.stream().forEach((e) -> System.out.println(e.getKey().getName() + " " + e.getValue().getAvailableQuantity() + "ml"));
        System.out.println("========== End ==========");
    }

    private void validate(Ingredient ingredient) {
        if(!ingredientAvailabilityMap.containsKey(ingredient)) {
            throw new IllegalArgumentException("Ingrient does not exists in system " + ingredient);
        }
    }

}
