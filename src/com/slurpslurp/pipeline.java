package com.slurpslurp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pipeline {


    static void pipelineRun(WebDriver driver, Section.Sections section)
    {

        textFinder(driver, section.sectionName());

        for (Level l : Level.values()) {//for every level

            textFinder(driver, l.levelName());   //clicks on the level
            Section s = new Section(section.sectionName());
            s.initialiseCourseList(driver);

            int i = 0;
            for (Course c : s.COURSES)
            {
                    c.downloadContents(driver);
                    FileSystem.moveToFolder(section.sectionName() + "/" + i++);
            }
        }
    }
    private static void textFinder(WebDriver w, String s){
        w.findElement(By.linkText(s)).click();
    }
}
