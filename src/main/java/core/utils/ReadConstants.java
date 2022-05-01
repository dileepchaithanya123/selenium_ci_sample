package core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConstants {

    static Properties prop = new Properties();
    
    public static void readProperties(){

        try {
            InputStream input = new FileInputStream("C:\\Users\\dilee\\IdeaProjects\\selenium_ci_sample\\src\\main\\resources\\Properties\\constants.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
