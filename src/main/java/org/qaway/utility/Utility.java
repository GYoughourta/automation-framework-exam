package org.qaway.utility;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

public class Utility {

    public static String currentDir = System.getProperty("user.dir");
    public static boolean isSorted(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static double[] listToArrayOfDoubles(List<String> list){
        double[] doubleList = new double[list.size()];
        double sum = 0;
        for (int i = 0; i < list.size(); ++i) {
            doubleList[i] = Double.parseDouble(list.get(i));
        }
        return doubleList;
    }

    public static Properties loadProperties(){
        Properties prop = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(currentDir+ File.separator+"config.properties"));
            prop.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static boolean verifierName(List<String> list) {
        for (int i = 0; i < list.size();i++) {
            if (list.get(i).equalsIgnoreCase("Apple"))
                return true;

        }
        return false;
    }

    public static boolean isSortedTotalAndSumPrices(List<Double> list , double total) {
        double sum = 0.;
        for (int i = 0; i < list.size();i++) {
                sum = list.get(i)+sum;
        }
        if (sum == total)
            return true;
        return false;
    }








    public static String decode(String key){
        byte[] decodedBytes = Base64.getDecoder().decode(key);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String username = "admin";
        String securedUsername;
        String password = "";

        securedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        System.out.println(securedUsername);
    }
}
