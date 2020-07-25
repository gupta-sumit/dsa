package coffeemachine;

public class CoffeeMachineTestRunner {

    public static void main(String[] args) {

        CoffeeMachineTest coffeeMachineTest = new CoffeeMachineTest();
        coffeeMachineTest.setup();
        coffeeMachineTest.testMakingBeverageWithAvailableQuantity();
        coffeeMachineTest.tearDown();

        coffeeMachineTest = new CoffeeMachineTest();
        coffeeMachineTest.setup();
        coffeeMachineTest.testMakingBeverageWithLowQuantity();
        coffeeMachineTest.tearDown();

        coffeeMachineTest = new CoffeeMachineTest();
        coffeeMachineTest.setup();
        coffeeMachineTest.testMakingBeverageWithFillQuantity();
        coffeeMachineTest.tearDown();

        coffeeMachineTest = new CoffeeMachineTest();
        coffeeMachineTest.setup();
        coffeeMachineTest.testOutletInvalidAssignment();
        coffeeMachineTest.tearDown();

        coffeeMachineTest = new CoffeeMachineTest();
        coffeeMachineTest.setup();
        coffeeMachineTest.testOutletAssignment();
        coffeeMachineTest.tearDown();

        coffeeMachineTest = new CoffeeMachineTest();
        coffeeMachineTest.setup();
        coffeeMachineTest.testMakingMultipleBeverageWithAvailableQuantity();
        coffeeMachineTest.tearDown();
    }
}
