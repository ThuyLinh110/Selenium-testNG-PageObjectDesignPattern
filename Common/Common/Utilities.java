package Common;

import java.io.*;
import java.util.Properties;

public class Utilities {
    public static String getPathProject()
    {
        return System.getProperty("user.dir");
    }

    public static String getDataFromConfig(String pathConfig, String header  ){
        try (InputStream input = new FileInputStream(pathConfig)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(header);

        } catch (IOException ex) {
            return "";
        }
    }

    public static void setDataToConfig(String pathConfig, String header, String value){
        try {
            FileInputStream in = new FileInputStream(pathConfig);
            Properties props = new Properties();
            props.load(in);
            in.close();
            OutputStream output = new FileOutputStream(pathConfig);
            props.setProperty(header, value);
            props.store(output,null);
            output.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }


    public static String getGenerateString(int string_size) {
        String alpha_numeric = "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder string_builder = new StringBuilder(string_size);
        for (int i = 0; i < string_size; i++) {
            int index = (int)(alpha_numeric.length() * Math.random());
            string_builder.append(alpha_numeric.charAt(index));
        }
        return string_builder.toString();
    }

}
