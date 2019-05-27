package com.slurpslurp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Main {


    public static void main(String[] args) {

        //some parts are timing based and expect a non-1998 internet connection.

        //disable system.err since selenium displays a shit ton of errors
        System.setErr(new PrintStream(new OutputStream() {@Override public void write(int b) {}}));


        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Mathis\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "http://moodle.epfl.ch";


        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
        textFinder(driver, "Log in");

        while(!driver.getTitle().equals("Dashboard")){
            sleep(100);
        }
        sleep(100);

        textFinder(driver,"Site home");
        textFinder(driver,"Mathématiques (MA)");

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