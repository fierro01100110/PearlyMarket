package src.test.java.pearlymarket_project.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Listeners;
import src.test.java.pearlymarket_project.utilities.MediaUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtil implements ITestListener , IRetryAnalyzer , IAnnotationTransformer {
    /*
    Listeners are used to LISTEN the test cases when they pass, fail, skip, start, end ...
    Listener will customize the TestNG framework.
    We will use listener for adding special functionalities under special cases like onStart, onFinish, onTestStart, onTestSuccess, onTestFailure...
    Under these cases we can take screenshot, rerun fail test cases automatically.
     */

    public void onStart(ITestContext context){
        System.out.println("onStart : Runs once before ALL @Test cases "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish : Runs once after ALL @Test cases "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart : Runs once after EACH @Test cases "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess : Runs once after EACH PASSING @Test cases "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //System.out.println("onTestFailure : Runs once after EACH FAILED @Test cases "+result.getName());
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped : Runs once after EACH SKIPPED @Test cases "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage : Runs once after total success percentage @Test cases "+result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout : Runs once after failed test cases due to a timeout issue @Test cases "+result.getName());
    }


    //Implement IRetryAnalyzer
    //This method will be called to RETRY FAILED TEST CASES

    private int retryCount = 0;//Counter
    private static final int maxRetryCount = 3;//Rerun count
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    //Implement IAnnotationTransformer interface
    //This method will rerun failed test cases by using xml file.

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(ListenersUtil.class);
    }
}

