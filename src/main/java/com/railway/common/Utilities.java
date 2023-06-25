package com.railway.common;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

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

    public static String getCurrentDateByUSFormat(){
        String pattern = "M/d/yyyy";
        return new SimpleDateFormat(pattern).format(new Date());
    }
    public static boolean compareStringDateByUSFormat(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        try {
            return sdf.parse(startDate).toInstant().isBefore(sdf.parse(endDate).toInstant());
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean isTwoDifferenceList(List<String> list1, List<String> list2){
        for (int i=0; i<list1.size(); i++) {
            if (list1.get(i) == list2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean compareStringByTimeFormat(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            return sdf.parse(startTime).toInstant().isBefore(sdf.parse(endTime).toInstant());
        }
        catch (Exception e) {
            return false;
        }
    }

    public static List<String> getMatchingValues(List<String> list1, List<String> list2) {
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }


}
