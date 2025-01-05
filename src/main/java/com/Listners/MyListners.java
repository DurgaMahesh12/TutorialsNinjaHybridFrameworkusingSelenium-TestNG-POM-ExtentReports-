package com.Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReporters;

public class MyListners implements ITestListener {
	ExtentReports extentReport ;
	ExtentTest extenttest;
	String Testname;

	@Override
	public void onStart(ITestContext context) {
		 extentReport = ExtentReporters.generateExtentReports();

	}

	@Override
	public void onTestStart(ITestResult result) {
		 Testname = result.getName();
	    extenttest=extentReport.createTest(Testname);
		extenttest.log(Status.INFO, Testname + "started Execeuting");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.log(Status.PASS, Testname + "Successfully Execeuting");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Taken Screenshot");
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL,  Testname + "Got Failed");
		

	}

	@Override

	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP,  Testname + "Test Skiped");

		

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

	}

}
