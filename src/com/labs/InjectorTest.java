package com.labs;

import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

class InjectorTest {

    @org.junit.jupiter.api.Test
    void injectWrongConfigPath() {
        try {
            OneQuitePoliteClass obj = new Injector("").inject(new OneQuitePoliteClass());
            fail( "injectWrongConfig didn't throw an exception" );
        } catch (FileNotFoundException ignored) {}
        catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            fail("injectWrongConfig threw wrong exception");
        }
    }

    @org.junit.jupiter.api.Test
    void injectWrongClassConfig() {
        String brokenConfigPath = "D:\\vsu\\2\\java\\lab_5\\src\\resources\\brokenConfig.txt";
        try {
            OneQuitePoliteClass obj = new Injector(brokenConfigPath).inject(new OneQuitePoliteClass());
            fail( "injectWrongConfig didn't throw an exception" );
        } catch (ClassNotFoundException ignored) {}
        catch (IOException | IllegalAccessException | InstantiationException e) {
            fail("injectWrongConfig threw wrong exception");
        }
    }

    @org.junit.jupiter.api.Test
    void inject() {
        class TestClass{
            @AutoInjectable
            private Welcomer testField;
        }
        TestClass tc = null;
        try {
            tc = new Injector().inject(new TestClass());
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            fail("Exception was thrown!");
        }
        Assertions.assertEquals("com.labs.PoshGreeter", tc.testField.getClass().getTypeName());
    }

}