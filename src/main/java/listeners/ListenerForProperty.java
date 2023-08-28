package listeners;

import Utils.PropertyReader;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerForProperty implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println(result.getName() + " is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //Reporter.log("Yes, this test was completed => " + result.getName());
        System.out.println("Yes, this test was completed => " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Reporter.log("Ohh, this test was failed => " + result.getName());
        System.out.println("Ohh, this test was failed => " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        String propertyName = context
                .getSuite()
                .getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config");
        new PropertyReader(propertyName);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
