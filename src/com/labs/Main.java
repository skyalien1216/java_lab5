package com.labs;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //String configPath = "D:\\vsu\\2\\java\\lab_5\\src\\resources\\poshconfig.txt";
        OneQuitePoliteClass obj = new Injector().inject(new OneQuitePoliteClass());
        obj.bePoliteTo("User");
    }
}
