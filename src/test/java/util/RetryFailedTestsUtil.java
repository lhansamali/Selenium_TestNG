package util;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j
public class RetryFailedTestsUtil implements IRetryAnalyzer {

    private static final Logger log = LoggerFactory.getLogger(RetryFailedTestsUtil.class);
    private int reRetryCount = 0;
    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (reRetryCount < MAX_RETRY_COUNT) {
            log.info("Retrying Failed tests: {}", iTestResult.getTestName());
            reRetryCount++;
            return true;
        }
        return false;
    }
}
