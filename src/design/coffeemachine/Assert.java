package coffeemachine;

public class Assert {

    public static void checkEquals(int expected, int actual) {
        if(expected != actual) {
            throw new AssertionError(prepareMessgae(expected,actual));
        }
    }

    public static void checkEquals(boolean expected, boolean actual) {
        if(expected != actual) {
            throw new AssertionError(prepareMessgae(expected,actual));
        }
    }

    private static String prepareMessgae(Object expected, Object actual) {
        return "Assertion Failed [expected = " + expected + ", actual = " + actual + "]";
    }

    public static void withExpectedException(Runnable runnable) {
        try {
            runnable.run();
            throw new AssertionError(prepareMessgae("exception", "but not exception thrown"));
        } catch (Throwable e) {
            if(e instanceof AssertionError) {
                throw e;
            } else{
                System.out.println(e.getMessage());
            }

        }
    }
}
