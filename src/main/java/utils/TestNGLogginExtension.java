package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGLogginExtension implements ITestListener {

    /** Realise pattern Observer */

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("Метод вызывается при начале выполнения всего тестового сьюита");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Метод вызывается при завершении выполнения всего тестового сьюита");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Начало выполнения тестового метода: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Тестовый метод успешно выполнен: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Тестовый метод неудачно выполнен: " + result.getMethod().getMethodName());
    }
}
