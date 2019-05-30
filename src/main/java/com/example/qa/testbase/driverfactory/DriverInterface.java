package com.example.qa.testbase.driverfactory;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

public interface DriverInterface {
  WebDriver getDriver() throws MalformedURLException;
}