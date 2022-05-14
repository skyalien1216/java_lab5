package com.labs;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    private final Properties properties;

    /**
     * Constructor with default path to properties file
     * @throws IOException if there's an error whilst reading the file
     */
    public Injector() throws IOException {
        String configPath  = "D:\\vsu\\2\\java\\lab_5\\src\\resources\\config.txt";
        properties = new Properties();
        properties.load(new FileReader(configPath));
    }

    /**
     * Constructor with specified path to properties file
     * @param configPath path to properties file
     * @throws IOException if there's an error whilst reading the file
     */
    public Injector(String configPath) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(configPath));
    }

    /**
     * Injects objects into fields marked as AutoInjectable
     * @param obj object with fields to inject to
     * @return object with injected fields
     * @throws ClassNotFoundException if properties file has nonexistent class
     */
    public <T> T inject(T obj) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for(Field f : fields)
            if(f.isAnnotationPresent(AutoInjectable.class))
            {
                f.setAccessible(true);
                Class fieldClass = f.getType();
                String fieldClassName = fieldClass.getTypeName();
                if(properties.containsKey(fieldClassName))
                {
                    String injectableClassName = (String) properties.get(fieldClassName);
                    Class<?> cl = Class.forName(injectableClassName);
                    f.set(obj, cl.newInstance());
                }
            }
        return obj;
    }
}
