package coffeemachine.beverage;

import coffeemachine.error.Error;

public class Beverage {

    private String name;
    private boolean success;
    private Error error;

    private Beverage(boolean success, Error error, String name) {
        this.success = success;
        this.name = name;
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public boolean isSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public static Beverage success(String name) {
        return new Beverage(true, null, name);
    }

    public static Beverage failed(Error error, String name) {
        return new Beverage(false, error,name);
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", success=" + success +
                ", error=" + error +
                '}';
    }
}
