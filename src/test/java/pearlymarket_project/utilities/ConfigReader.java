package src.test.java.pearlymarket_project.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    //This class will read configuration.properties file using JAVA

    //Create Properties object
    private static Properties properties;

    //static block it will read the file before everything
    static {
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Create method that accepts KEY and returns VALUE
    public static String getProperty(String key){

        String value = properties.getProperty(key);
        return value;
    }

    //TEST
    public static void main(String[] args) {
        System.out.println(ConfigReader.getProperty("amazon_prod_url"));
        System.out.println(ConfigReader.getProperty("amazon_qa_url"));
        System.out.println(ConfigReader.getProperty("browser"));
    }
}
