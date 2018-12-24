import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DeckTest.class);

        //Print all failures
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        // final result
        System.out.println("All test cases passed :: " +result.wasSuccessful());
    }
}