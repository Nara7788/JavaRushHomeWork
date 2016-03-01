package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) throws IOException {
        new Solution().fillInPropertiesMap();


    }
    public void fillInPropertiesMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        Properties prop = new Properties();
        prop.load(inputStream);

        Set<String> set = prop.stringPropertyNames();

        for (String s : set) {
            properties.put(s, prop.getProperty(s));
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            writer.println(entry.getKey());
            writer.println(entry.getValue());
        }
        writer.flush();
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            properties.put(line, reader.readLine());
        }

        reader.close();
    }
}
