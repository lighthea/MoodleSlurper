package com.slurpslurp;

@SuppressWarnings("unused")
public enum Section {

    AR("Architecture (AR)"),
    CGC("Chimie, Génie Chimique (CGC)"),
    CMS("Cours Préparatoire (CMS)"),
    ED("Ecole doctorale (ED)"),
    GC("Génie civil (GC)"),
    EL("Génie électrique et électronique (EL)"),
    GM("Génie mécanique (GM) "),
    IN("Informatique (IN)"),
    MX("Matériaux (MX)"),
    MA("Mathématiques (MA)"),
    MT("Microtechnique (MT)"),
    PH("Physique (PH)"),
    SIE("Sciences et ingénierie de l'environnement (SIE)"),
    SV("Sciences et technologies du vivant (SV)"),
    SC("Systèmes de communication (SC)");

    Section(String s){
        name = s;
    }

    String sectionName(){
        return name;
    }

    private String name;

}
