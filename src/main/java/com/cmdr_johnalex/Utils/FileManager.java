package com.cmdr_johnalex.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The FileManager class provides methods for reading from files.
 */
public class FileManager
{
    /**
     * Reads all the lines from a file.
     *
     * @param filepath The path to the file to read. Relative to the resources directory.
     * @return An ArrayList of strings containing the lines from the file.
     */
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

    /**
     * Reads a random line from a file.
     *
     * @param filepath The path to the file to read. Relative to the resources directory.
     * @return A random line from the file.
     */
    public static String ReadRandomLine(String filepath)
    {
        ArrayList<String> lines = ReadFile(filepath);
        return lines.get(Rand.Range(0, lines.size() - 1));
    }
}
