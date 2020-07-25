package coffeemachine;

import coffeemachine.beverage.Beverage;
import coffeemachine.beverage.BeverageMaker;

public class CoffeeMachine {

    private Outlet[] outlets;

    public CoffeeMachine(int outletCount) {
        outlets = new Outlet[outletCount];
    }

    public void assign(int outletNumber, String beverageName, BeverageMaker beverageMaker) {
        validate(outletNumber);
        int index = getIndex(beverageName);
        if(index != -1) {
            outlets[index] = null;
        }
        // If there is anything on current outlet, we will discard
        outlets[outletNumber-1] = new Outlet(beverageName, beverageMaker);
    }

    private void validate(int outletNumber) {
        if(outletNumber <= 0) {
            throw new IllegalArgumentException("Invalid outlet number");
        }
        if(outletNumber > outlets.length) {
            throw new IllegalArgumentException("Outlet number more than outlets configured in coffee machine");
        }
    }

    public Beverage makeBeverage(int outletNumber) {
        validate(outletNumber);
        if(outlets[outletNumber-1] != null) {
            return outlets[outletNumber-1].make();
        }
        throw new IllegalArgumentException("No beverage maker assigned on this outlet " + outletNumber);
    }

    private int getIndex(String beverageName) {
        for(int i=0; i < outlets.length; i++) {
            if(outlets[i] != null && outlets[i].beverageName.equals(beverageName)) {
                return i;
            }
        }
        return -1;
    }


    private static class Outlet {

        private String beverageName;
        private BeverageMaker beverageMaker;

        public Outlet(String beverageName, BeverageMaker beverageMaker) {
            this.beverageName = beverageName;
            this.beverageMaker = beverageMaker;
        }

        public Beverage make() {
            return beverageMaker.makeBeverage();
        }
    }
}
