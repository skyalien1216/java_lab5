package com.labs;

public interface Fareweller {
    public String sayGoodbyeTo(String personsName);
}

class PoshFareweller implements Fareweller
{
    @Override
    public String sayGoodbyeTo(String personsName) {
        return "Farewell, dear "+ personsName + ", have a nice day!";
    }
}

class InformalFareweller implements Fareweller
{
    @Override
    public String sayGoodbyeTo(String personsName) {
        return "Bye, "+ personsName + "!";
    }
}