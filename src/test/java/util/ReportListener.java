package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalTime;

public class ReportListener implements ITestListener {
    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String localTime = LocalTime.now().toString().replace(":", "-").replace(".", "");
        String reportPath = System.getProperty("user.dir") + "/target/report_" + localTime + ".html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);


        extentSparkReporter.config().setReportName("Automation Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "Your Name");

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTestThreadLocal.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTestThreadLocal.get().log(Status.FAIL, result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTestThreadLocal.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
