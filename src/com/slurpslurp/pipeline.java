package com.slurpslurp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pipeline {
    static void pipelineRun(WebDriver driver)
    {
        for (Section s : Section.values()) { //for every section
            returnHome(driver);        //go to moodle home page
            textFinder(driver, s.sectionName()); //clicks on the section

            for (Level l : Level.values()) {//for every level

                textFinder(driver, l.levelName());   //clicks on the level
                s.initialiseCourseList(driver);

                for (Course c :
                        s.COURSES) {
                    c.downloadContents(driver);
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
