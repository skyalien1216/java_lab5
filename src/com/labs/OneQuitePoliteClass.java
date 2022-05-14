package com.labs;

public class OneQuitePoliteClass {

    @AutoInjectable
    private Welcomer welcomer;
    @AutoInjectable
    private Fareweller fareweller;

    /**
     * Greet and say goodbye to a user
     * @param personsName user to be greeted
     */
    public void bePoliteTo(String personsName)
    {
        System.out.println(welcomer.greet(personsName));
        System.out.println(fareweller.sayGoodbyeTo(personsName));
    }
}
