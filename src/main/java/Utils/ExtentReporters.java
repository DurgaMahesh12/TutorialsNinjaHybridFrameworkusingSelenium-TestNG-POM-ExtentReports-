package Utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporters {
     
	public static ExtentReports generateExtentReports() {
		ExtentReports extentreports = new ExtentReports();
		File extentreportfile = new File(System.getProperty("user.dir")+"//test-output//extentreports\\extentreport.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extentreportfile);
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Tutorials Ninja Test Automation Results Report");
		sparkreporter.config().setDocumentTitle("TN AutomationReports");
		sparkreporter.config().setTimeStampFormat("dd-mm-yyyy   hh-mm-ss");
		extentreports.attachReporter(sparkreporter);
		extentreports.setSystemInfo("Appilication URL", "https://tutorialsninja.com/demo/");
		extentreports.setSystemInfo("Browsename", "Chrome");
		extentreports.setSystemInfo("Email", "durgamaheshvanum123@gmail.com");
		extentreports.setSystemInfo("Password", "Mahesh@5451");
		extentreports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreports.setSystemInfo("Operating System", System.getProperty("user.name"));
		extentreports.setSystemInfo("JavaVersion", System.getProperty("java.version"));
		return extentreports;
	}
	

}
