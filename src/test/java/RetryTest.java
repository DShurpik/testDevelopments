import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utils.TestNGRetry;

/** Solution for flacky tests */

public class RetryTest {

    @BeforeSuite
    public void setUp(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(TestNGRetry.class);
        }
    }

    @Test(retryAnalyzer = TestNGRetry.class)
    public void test1() {
        Assert.assertTrue(false);
    }

    @Test
    public void test2() {
        Assert.assertTrue(false);
    }
}
