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
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //some parts are timing based and expect a non-1998 internet connection.


        FirefoxProfile firefoxProfile=new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList",2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        firefoxProfile.setPreference("browser.download.dir", "res");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");

        firefoxProfile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
        firefoxProfile.setPreference("pdfjs.disabled", true);
        firefoxProfile.setPreference("pdfjs.disabled", true);
        //disable system.err since selenium displays a shit ton of errors
        System.setProperty("webdriver.gecko.driver","res/geckodriver" + (System.getProperty("os.name").contains("Win") ? ".exe" : ""));
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(firefoxProfile);

        List<WebDriver> driver = new LinkedList<>();
        List<WebDriverWait> driverWaits = new LinkedList<>();
        for (int i = 0; i < Section.Sections.values().length; i++) {
            driver.add(new FirefoxDriver(options));


            //declares a wait time (30s) before crash if no feedback is received
        }

        driver.parallelStream().forEach(i -> {

            // launch Firefox and direct it to moodle
            i.get("https://moodle.epfl.ch");


            //clicks on login
            textFinder(i, "Log in");

            i.findElement(By.id("username")).sendKeys(args[0]);
            i.findElement(By.id("password")).sendKeys(args[1]);

            i.findElement(By.id("loginbutton")).click();

            i.get("http://moodle.epfl.ch/course/index.php");
        });

        driver.parallelStream().forEach(i -> {pipeline.pipelineRun(i, Section.Sections.values()[driver.indexOf(i)]);});
        //looks for firefox (position should be in the vm arguments)



    }



    private static void textFinder(WebDriver w, String s){
        w.findElement(By.linkText(s)).click();
    }

}