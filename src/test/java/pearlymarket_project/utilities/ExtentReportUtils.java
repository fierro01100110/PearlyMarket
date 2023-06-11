package src.test.java.pearlymarket_project.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    /*
    We use static block here. Whenever I call ExtentReportUtils class static block will run
    and do necessary configurations before using variables.
     */

    static {
//      WHAT WILL BE REPORT NAME AND WHERE THE REPORT IS CREATED
//      PATH
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+"extent_reports.html";

//      **** Create the HTML template using extent html reporter in the path ***
        extentHtmlReporter = new ExtentHtmlReporter(path);

//      *** Create extent report ***
        extentReports = new ExtentReports();

//      ***********ADDING CUSTOM SYSTEM INFORMATION ***********
        extentReports.setSystemInfo("Application Name","Apple M1 Unit");
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team Name","Eagles");
        extentReports.setSystemInfo("SQA","Seren");
        extentReports.setSystemInfo("Feature Number","FE1056");
        extentReports.setSystemInfo("Test Number","123");

//        ***********DOCUMENT INFORMATION************************
        extentHtmlReporter.config().setReportName("My Regression Report");
        extentHtmlReporter.config().setDocumentTitle("My Regression Extent Reports");
//        ***********DONE WITH CONFIGURATIONS********************
//        connecting extent reports and extent html reporter
        extentReports.attachReporter(extentHtmlReporter);
//        **********CREATE EXTENT TEST THAT IS ALSO KNOWN AS LOGGER**
        extentTest=extentReports.createTest("MY REGRESSION","MY FIRST EXTENT REPORT");

    }

    //LOGGER METHODS:

    //ExtentReportUtils.pass("Message") --> Logs the message as passed on report
    public static void pass(String message){

        extentTest.pass(message);
    }

    //ExtentReportUtils.info("Message") --> Logs the message as information on report
    public static void info(String message){

        extentTest.info(message);
    }

    //ExtentReportUtils.fail("Message") --> Logs the message as failure on report
    public static void fail(String message){
        extentTest.fail(message);
    }

    //This method will log the pass message on report and attached the screenshot of the step on report.
    public static void passAndCaptureScreenShot(String message) throws IOException {
        extentTest.pass(message).addScreenCaptureFromPath(MediaUtils.takeScreenshotOfTheEntirePageAsString());
    }

    //To generate to extent report we must use "extentReports.flush();"
    //ExtentReportUtils.flush();  --> Generates the report
    public static void flush(){

        extentReports.flush();
    }
}
