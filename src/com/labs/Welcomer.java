package com.labs;

public interface Welcomer {
    public String greet(String personsName);
}

class PoshGreeter implements Welcomer
{
    @Override
    public String greet(String personsName) {
        return "Good day to you, dear " + personsName + ", and welcome!";
    }
}

class InformalGreeter implements Welcomer
{
    @Override
    public String greet(String personsName) {
        return "Hi, " + personsName + "!";
    }
}