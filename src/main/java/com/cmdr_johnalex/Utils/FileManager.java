package com.cmdr_johnalex.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager
{
    public static ArrayList<String> ReadFile(String filepath)
    {
        ArrayList<String> lines = new ArrayList<>();
        try
        {
            // TODO: Make this more robust. What if the file doesn't exist?
            ClassLoader classLoader = FileManager.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filepath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.length() > 0)
                    lines.add(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }

    public static String ReadRandomLine(String filepath)
    {
        ArrayList<String> lines = ReadFile(filepath);
        return lines.get(Rand.Range(0, lines.size() - 1));
    }
}
