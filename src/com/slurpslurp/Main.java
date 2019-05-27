package com.slurpslurp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.OutputStream;
import java.io.PrintStream;

public class Main {


    public static void main(String[] args) {

        //some parts are timing based and expect a non-1998 internet connection.

        //disable system.err since selenium displays a shit ton of errors
        System.setErr(new PrintStream(new OutputStream() {@Override public void write(int b) {}}));
        System.setProperty("webdriver.gecko.driver","res/geckodriver" + (System.getProperty("os.name").contains("Win") ? ".exe" : ""));

        WebDriver driver = new FirefoxDriver();
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


        for (Section s : Section.values()) { //for every section
            for (Level l : Level.values()) {//for every level
                returnHome(driver);        //go to moodle home page
                textFinder(driver, s.sectionName()); //clicks on the section
                textFinder(driver, l.levelName());   //clicks on the level
                try {
                    Thread.sleep(3000); //waits a bit
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void returnHome(WebDriver driver) {
        driver.get("https://moodle.epfl.ch/?redirect=0");
    }

    private static void textFinder(WebDriver w, String s){
        w.findElement(By.linkText(s)).click();
    }

}