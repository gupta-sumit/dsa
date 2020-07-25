package coffeemachine.beverage;

public class DefaultBeverageMakerImpl implements BeverageMaker {

    private BeverageMakingProcess beverageMakingProcess;

    public DefaultBeverageMakerImpl(BeverageMakingProcess beverageMakingProcess) {
        this.beverageMakingProcess = beverageMakingProcess;
    }

    @Override
    public Beverage makeBeverage() {
        return beverageMakingProcess.execute();
    }
}
