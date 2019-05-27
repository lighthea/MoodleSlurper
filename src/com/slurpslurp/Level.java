package com.slurpslurp;
@SuppressWarnings("unused")

public enum Level {
    BA("Bachelor"), MA("Master");

    Level(String s){
        name = s;
    }

    private String name;

    public String levelName(){
        return name;
    }
}
