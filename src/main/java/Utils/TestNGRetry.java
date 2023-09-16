package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer {

    private int count = 0;
    private int maxAttempt = 10;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxAttempt) {
                count++;
                return true;
            }
        }
        return false;
    }
}
