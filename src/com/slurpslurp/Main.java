package com.slurpslurp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.OutputStream;
import java.io.PrintStream;

public class Main {


    public static void main(String[] args) {

        //some parts are timing based and expect a non-1998 internet connection.

        //disable system.err since selenium displays a shit ton of errors
        System.setErr(new PrintStream(new OutputStream() {@Override public void write(int b) {}}));


        System.setProperty("webdriver.gecko.driver","C:\\Users\\Mathis\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // launch Firefox and direct it to moodle
        driver.get("https://moodle.epfl.ch");

        textFinder(driver, "Log in");

        while(!driver.getTitle().equals("Dashboard")){
            sleep(100);
        }
        sleep(500);

        textFinder(driver,"Site home");
        for(Section s : Section.values()){
            returnHome(driver);
            for(Level l : Level.values()) {
                textFinder(driver, s.sectionName());
                textFinder(driver, l.levelName());
                sleep(3000);
            }
        }

    }

    private static void returnHome(WebDriver driver) {
        driver.get("https://moodle.epfl.ch/?redirect=0");
    }

    private static void textFinder(WebDriver w, String s){
        w.findElement(By.linkText(s)).click();
    }

    private static void sleep(long l){
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}