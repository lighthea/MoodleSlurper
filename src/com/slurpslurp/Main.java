package com.slurpslurp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.OutputStream;
import java.io.PrintStream;

public class Main {


    public static void main(String[] args) {

        //some parts are timing based and expect a non-1998 internet connection.


        FirefoxProfile firefoxProfile=new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList",2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        firefoxProfile.setPreference("browser.download.dir", "res");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
        //disable system.err since selenium displays a shit ton of errors
        System.setProperty("webdriver.gecko.driver","res/geckodriver" + (System.getProperty("os.name").contains("Win") ? ".exe" : ""));
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(firefoxProfile);
        WebDriver driver = new FirefoxDriver(options);

        //looks for firefox (position should be in the vm arguments)
        WebDriverWait w = new WebDriverWait(driver, 30);
        //declares a wait time (30s) before crash if no feedback is received

        // launch Firefox and direct it to moodle
        driver.get("https://moodle.epfl.ch");

        //clicks on login
        textFinder(driver, "Log in");

        //waits until tab is named dashboard and "Moodle" is written somewhere on the screen
        w.until(ExpectedConditions.titleIs("Dashboard"));
        w.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Moodle")));

        //clicks on "site home"
        textFinder(driver,"Site home");
        pipeline.pipelineRun(driver);


    }



    private static void textFinder(WebDriver w, String s){
        w.findElement(By.linkText(s)).click();
    }

}