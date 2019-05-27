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

        if (System.getProperty("os.name").contains("Win"))
            System.setProperty("webdriver.gecko.driver","res\\geckodriver.exe");
        else
            System.setProperty("webdriver.gecko.driver","res/geckodriver");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait w = new WebDriverWait(driver, 30);

        // launch Firefox and direct it to moodle
        driver.get("https://moodle.epfl.ch");

        textFinder(driver, "Log in");

        w.until(ExpectedConditions.titleIs("Dashboard"));
        w.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Moodle")));

        textFinder(driver,"Site home");


        for(Section s : Section.values()){
            for(Level l : Level.values()) {
                returnHome(driver);
                textFinder(driver, s.sectionName());
                textFinder(driver, l.levelName());
                try {
                    Thread.sleep(3000);
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