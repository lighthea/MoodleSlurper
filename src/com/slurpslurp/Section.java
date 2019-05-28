package com.slurpslurp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

            List<WebElement> availableCourses = driver.findElements(By.className("coursename"));

            if (availableCourses.size() != 0) {
                for (WebElement courses : availableCourses) {

                    Course c = new Course(courses.findElement(By.cssSelector("a")).getAttribute("href"));
                    COURSES.add(c);
                    COURSES.get(COURSES.size() - 1).testUsability(driver);

                }
            }
        }

}

