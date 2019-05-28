package com.slurpslurp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class pipeline {


    static void pipelineRun(WebDriver driver)
    {
        List<Section> sectionList = new LinkedList<>();

        for (Section.Sections s : Section.Sections.values()) { //for every section
            sectionList.add(new Section(s.sectionName()));
            returnHome(driver);        //go to moodle home page
            textFinder(driver, s.sectionName()); //clicks on the section

            for (Level l : Level.values()) {//for every level

                textFinder(driver, l.levelName());   //clicks on the level

                sectionList.get(sectionList.size() - 1).initialiseCourseList(driver);

                for (Course c :
                        sectionList.get(sectionList.size() - 1).COURSES) {
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
