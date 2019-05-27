package com.slurpslurp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Mathis\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome

        String baseUrl = "http://moodle.epfl.ch";


        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        driver.findElement(By.linkText("Log in")).click();

        while(!driver.getTitle().equals("Dashboard")){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("found dash");


        driver.close();
    }

}