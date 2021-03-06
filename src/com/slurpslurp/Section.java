package com.slurpslurp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")

public class Section {

    public enum Sections {

        AR("Architecture (AR)"),
        CGC("Chimie, Génie Chimique (CGC)"),
        GC("Génie civil (GC)"),
        EL("Génie électrique et électronique (EL)"),
        GM("Génie mécanique (GM)"),
        IN("Informatique (IN)"),
        MX("Matériaux (MX)"),
        MA("Mathématiques (MA)"),
        MT("Microtechnique (MT)"),
        PH("Physique (PH)"),
        SIE("Sciences et ingénierie de l'environnement (SIE)"),
        SV("Sciences et technologies du vivant (SV)"),
        SC("Systèmes de communication (SC)");

        private String name;

        Sections(String s) {
            name = s;
        }

        String sectionName() {
            return name;
        }
        public  static List<Sections> ALL = Arrays.asList(values());
    }


        Section(String s){
            SectionType = s;
        }

        private String SectionType;

        public  List<Course> COURSES = new LinkedList<>();

        public void initialiseCourseList(WebDriver driver) {

            if(true) return;
            List<WebElement> availableCourses = driver.findElements(By.className("coursename"));
            String s = driver.getCurrentUrl();
            for (WebElement w :
                    availableCourses) {

                COURSES.add(new Course(w.findElement(By.cssSelector("a")).getAttribute("href")));
            }

            if (availableCourses.size() != 0) {

                for (Course courses : COURSES) {

                    courses.testUsability(driver);
                    driver.get(s);
                }
            }
        }

}

