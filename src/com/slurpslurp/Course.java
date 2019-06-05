package com.slurpslurp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Course {

    private final String url;
    public boolean isEnrolled;

    Course(String url){
        this.url = url;
    }

    public void testUsability(WebDriver driver){
        String past = driver.getCurrentUrl();
        driver.get(url);
        try {
            if (driver.findElements(By.name("submitbutton")).size() != 0)
                driver.findElement(By.name("submitbutton")).click();

            isEnrolled = driver.findElements(By.name("search")).size() != 0;
            driver.get(past);

        }
        catch (Exception e)
        {
            isEnrolled =  false;
            driver.get(past);

        }
    }

    public void downloadContents (WebDriver driver){

        String past = driver.getCurrentUrl();
        driver.get(url);


        try {
            int numbercourse = driver.findElements(By.className("instancename")).size();

            for (int i = 0; i < numbercourse; i++) {
                driver.findElements(By.className("instancename")).get(i).click();
                driver.get(url);
            }

        } catch (Exception e){
            e.printStackTrace();
            driver.get(past);
        }

        driver.get(past);
    }
}
