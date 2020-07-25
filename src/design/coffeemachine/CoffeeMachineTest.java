package coffeemachine;

import coffeemachine.beverage.Beverage;
import coffeemachine.beverage.BeverageMakingProcess;
import coffeemachine.beverage.DefaultBeverageMakerImpl;
import coffeemachine.beverage.DefaultBeverageMakingProcess;
import coffeemachine.ingredients.Ingredient;
import coffeemachine.ingredients.IngredientProviderImpl;
import coffeemachine.ingredients.IngredientAvailability;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoffeeMachineTest {

    CoffeeMachine coffeeMachine;
    Map<Ingredient,IngredientAvailability> ingredientAvailabilityMap = new HashMap<>();
    private IngredientProviderImpl ingredientProvider;

    public void setup() {
        Ingredient hotWater = new Ingredient("hot_water", "Hot Water");
        Ingredient hotMilk = new Ingredient("hot_milk", "Hot Milk");
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", "Ginger Syrup");
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", "Sugar Syrup");
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", "Tea Leaves Syrup");
        Ingredient elaichiSyrup = new Ingredient("elaichi syrup", "Elaichi Syrup");

        IngredientAvailability hotwaterAvailability = new IngredientAvailability(hotWater, 60);
        IngredientAvailability hotmilkAvailability = new IngredientAvailability(hotMilk, 1000);
        IngredientAvailability gingerAvailability = new IngredientAvailability(gingerSyrup, 1000);
        IngredientAvailability sugarAvailability = new IngredientAvailability(sugarSyrup, 1000);
        IngredientAvailability tealeavesAvailability = new IngredientAvailability(teaLeavesSyrup, 1000);
        IngredientAvailability elaichiAvailability = new IngredientAvailability(elaichiSyrup, 1000);

        ingredientAvailabilityMap = new HashMap<>();
        ingredientAvailabilityMap.put(hotwaterAvailability.getIngredient(), hotwaterAvailability);
        ingredientAvailabilityMap.put(hotmilkAvailability.getIngredient(), hotmilkAvailability);
        ingredientAvailabilityMap.put(gingerAvailability.getIngredient(), gingerAvailability);
        ingredientAvailabilityMap.put(sugarAvailability.getIngredient(), sugarAvailability);
        ingredientAvailabilityMap.put(tealeavesAvailability.getIngredient(), tealeavesAvailability);
        ingredientAvailabilityMap.put(elaichiAvailability.getIngredient(), elaichiAvailability);

        ingredientProvider = new IngredientProviderImpl(ingredientAvailabilityMap);
    }



    public void testMakingBeverageWithAvailableQuantity() {
        Ingredient hotWater = new Ingredient("hot_water", "Hot Water");
        Ingredient hotMilk = new Ingredient("hot_milk", "Hot Milk");
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", "Ginger Syrup");
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", "Sugar Syrup");
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", "Tea Leaves Syrup");

        LinkedHashMap<Ingredient, Integer> gingerTeaRequiredIngredients = new LinkedHashMap<>();
        gingerTeaRequiredIngredients.put(hotWater,50);
        gingerTeaRequiredIngredients.put(hotMilk,10);
        gingerTeaRequiredIngredients.put(teaLeavesSyrup,10);
        gingerTeaRequiredIngredients.put(gingerSyrup,5);
        gingerTeaRequiredIngredients.put(sugarSyrup,10);

        BeverageMakingProcess gingerTea = new DefaultBeverageMakingProcess("Ginger Tea", gingerTeaRequiredIngredients, ingredientProvider);
        coffeeMachine = new CoffeeMachine(4);
        coffeeMachine.assign(1,"Ginger Tea", new DefaultBeverageMakerImpl(gingerTea));

        Beverage beverage = coffeeMachine.makeBeverage(1);
        Assert.checkEquals(Boolean.TRUE, beverage.isSuccess());
        ingredientProvider.printIngredientAvailability();
        beverage = coffeeMachine.makeBeverage(1);

        System.out.println(beverage);
    }

    public void testMakingMultipleBeverageWithAvailableQuantity() {
        Ingredient hotWater = new Ingredient("hot_water", "Hot Water");
        Ingredient hotMilk = new Ingredient("hot_milk", "Hot Milk");
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", "Ginger Syrup");
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", "Sugar Syrup");
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", "Tea Leaves Syrup");
        Ingredient elaichiSyrup = new Ingredient("elaichi syrup", "Elaichi Syrup");

        LinkedHashMap<Ingredient, Integer> gingerTeaRequiredIngredients = new LinkedHashMap<>();
        gingerTeaRequiredIngredients.put(hotWater,50);
        gingerTeaRequiredIngredients.put(hotMilk,10);
        gingerTeaRequiredIngredients.put(teaLeavesSyrup,10);
        gingerTeaRequiredIngredients.put(gingerSyrup,5);
        gingerTeaRequiredIngredients.put(sugarSyrup,10);


        LinkedHashMap<Ingredient, Integer> elaichiTea = new LinkedHashMap<>();
        gingerTeaRequiredIngredients.put(hotWater,50);
        gingerTeaRequiredIngredients.put(hotMilk,10);
        gingerTeaRequiredIngredients.put(teaLeavesSyrup,10);
        gingerTeaRequiredIngredients.put(elaichiSyrup,5);
        gingerTeaRequiredIngredients.put(sugarSyrup,10);


        BeverageMakingProcess gingerTea = new DefaultBeverageMakingProcess("Ginger Tea", gingerTeaRequiredIngredients, ingredientProvider);
        BeverageMakingProcess elaichi_tea = new DefaultBeverageMakingProcess("Elaichi Tea", elaichiTea, ingredientProvider);
        coffeeMachine = new CoffeeMachine(4);
        coffeeMachine.assign(1,"Ginger Tea", new DefaultBeverageMakerImpl(gingerTea));
        coffeeMachine.assign(2,"Elaichi Tea", new DefaultBeverageMakerImpl(elaichi_tea));

        Beverage beverage = coffeeMachine.makeBeverage(1);
        Assert.checkEquals(Boolean.TRUE, beverage.isSuccess());
        ingredientProvider.printIngredientAvailability();
        beverage = coffeeMachine.makeBeverage(1);

        System.out.println(beverage);

        ingredientProvider.fill(hotWater,100);

        beverage = coffeeMachine.makeBeverage(2);

        System.out.println(beverage);
    }


    public void testMakingBeverageWithLowQuantity() {
        Ingredient hotWater = new Ingredient("hot_water", "Hot Water");
        Ingredient hotMilk = new Ingredient("hot_milk", "Hot Milk");
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", "Ginger Syrup");
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", "Sugar Syrup");
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", "Tea Leaves Syrup");

        LinkedHashMap<Ingredient, Integer> gingerTeaRequiredIngredients = new LinkedHashMap<>();
        gingerTeaRequiredIngredients.put(hotWater,50);
        gingerTeaRequiredIngredients.put(hotMilk,10);
        gingerTeaRequiredIngredients.put(teaLeavesSyrup,10);
        gingerTeaRequiredIngredients.put(gingerSyrup,5);
        gingerTeaRequiredIngredients.put(sugarSyrup,10);

        BeverageMakingProcess gingerTea = new DefaultBeverageMakingProcess("Ginger Tea", gingerTeaRequiredIngredients, ingredientProvider);
        coffeeMachine = new CoffeeMachine(4);
        coffeeMachine.assign(1,"Ginger Tea", new DefaultBeverageMakerImpl(gingerTea));

        Beverage beverage = coffeeMachine.makeBeverage(1);
        Assert.checkEquals(Boolean.TRUE, beverage.isSuccess());
        ingredientProvider.printIngredientAvailability();
        beverage = coffeeMachine.makeBeverage(1);
        Assert.checkEquals(Boolean.FALSE, beverage.isSuccess());
        System.out.println(beverage);
    }

    public void testMakingBeverageWithFillQuantity() {
        Ingredient hotWater = new Ingredient("hot_water", "Hot Water");
        Ingredient hotMilk = new Ingredient("hot_milk", "Hot Milk");
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", "Ginger Syrup");
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", "Sugar Syrup");
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", "Tea Leaves Syrup");

        LinkedHashMap<Ingredient, Integer> gingerTeaRequiredIngredients = new LinkedHashMap<>();
        gingerTeaRequiredIngredients.put(hotWater,50);
        gingerTeaRequiredIngredients.put(hotMilk,10);
        gingerTeaRequiredIngredients.put(teaLeavesSyrup,10);
        gingerTeaRequiredIngredients.put(gingerSyrup,5);
        gingerTeaRequiredIngredients.put(sugarSyrup,10);

        BeverageMakingProcess gingerTea = new DefaultBeverageMakingProcess("Ginger Tea", gingerTeaRequiredIngredients, ingredientProvider);
        coffeeMachine = new CoffeeMachine(4);
        coffeeMachine.assign(1,"Ginger Tea", new DefaultBeverageMakerImpl(gingerTea));

        Beverage beverage = coffeeMachine.makeBeverage(1);
        Assert.checkEquals(Boolean.TRUE, beverage.isSuccess());
        ingredientProvider.printIngredientAvailability();
        beverage = coffeeMachine.makeBeverage(1);
        Assert.checkEquals(Boolean.FALSE, beverage.isSuccess());
        System.out.println(beverage);

        ingredientProvider.fill(hotWater, 100);

        ingredientProvider.printIngredientAvailability();

        beverage = coffeeMachine.makeBeverage(1);
        Assert.checkEquals(Boolean.TRUE, beverage.isSuccess());

        System.out.println(beverage);

    }

    public void testOutletInvalidAssignment() {
        Ingredient hotWater = new Ingredient("hot_water", "Hot Water");
        Ingredient hotMilk = new Ingredient("hot_milk", "Hot Milk");
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", "Ginger Syrup");
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", "Sugar Syrup");
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", "Tea Leaves Syrup");

        LinkedHashMap<Ingredient, Integer> gingerTeaRequiredIngredients = new LinkedHashMap<>();
        gingerTeaRequiredIngredients.put(hotWater,50);
        gingerTeaRequiredIngredients.put(hotMilk,10);
        gingerTeaRequiredIngredients.put(teaLeavesSyrup,10);
        gingerTeaRequiredIngredients.put(gingerSyrup,5);
        gingerTeaRequiredIngredients.put(sugarSyrup,10);

        BeverageMakingProcess gingerTea = new DefaultBeverageMakingProcess("Ginger Tea", gingerTeaRequiredIngredients, ingredientProvider);
        coffeeMachine = new CoffeeMachine(4);
        Assert.withExpectedException(() -> coffeeMachine.assign(0,"Ginger Tea", new DefaultBeverageMakerImpl(gingerTea)));
        Assert.withExpectedException(() -> coffeeMachine.assign(5,"Ginger Tea", new DefaultBeverageMakerImpl(gingerTea)));
    }

    public void testOutletAssignment() {
        Ingredient hotWater = new Ingredient("hot_water", "Hot Water");
        Ingredient hotMilk = new Ingredient("hot_milk", "Hot Milk");
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", "Ginger Syrup");
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", "Sugar Syrup");
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", "Tea Leaves Syrup");

        LinkedHashMap<Ingredient, Integer> gingerTeaRequiredIngredients = new LinkedHashMap<>();
        gingerTeaRequiredIngredients.put(hotWater,50);
        gingerTeaRequiredIngredients.put(hotMilk,10);
        gingerTeaRequiredIngredients.put(teaLeavesSyrup,10);
        gingerTeaRequiredIngredients.put(gingerSyrup,5);
        gingerTeaRequiredIngredients.put(sugarSyrup,10);

        BeverageMakingProcess gingerTea = new DefaultBeverageMakingProcess("Ginger Tea", gingerTeaRequiredIngredients, ingredientProvider);
        coffeeMachine = new CoffeeMachine(4);
        coffeeMachine.assign(4,"Ginger Tea", new DefaultBeverageMakerImpl(gingerTea));
        Beverage beverage = coffeeMachine.makeBeverage(4);
        System.out.println(beverage);
    }

    public void tearDown() {

    }

}
