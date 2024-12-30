package com.cmdr_johnalex.Utils;

import java.util.Scanner;

public class Input
{
    static Scanner InputScanner = new Scanner(System.in);

    public static String GetString(String incorrectMessage)
    {
        System.out.print("> ");

        String input = "";
        Boolean isValidInput = false;

        while (!isValidInput)
        {
            input = InputScanner.nextLine();

            if (input.length() > 0)
                isValidInput = true;
        }

        return input;
    }

    public static String GetString()
    {
        return GetString("Invalid input. Please try again. (String)");
    }

    public static int GetInt(String incorrectMessage)
    {
        System.out.print("> ");

        int input = 0;
        Boolean isValidInput = false;

        while (!isValidInput)
        {
            try
            {
                input = InputScanner.nextInt();
                isValidInput = true;
            }
            catch (Exception e)
            {
                System.out.println(incorrectMessage);
            }
        }
        // Clear the buffer. When using nextInt, any other input including a newline character '\n' will be left in the buffer.
        InputScanner.nextLine();

        return input;
    }

    public static int GetInt()
    {
        return GetInt("Invalid input. Please try again. (Int)");
    }

    public static double GetDouble(String incorrectMessage)
    {
        System.out.print("> ");

        double input = 0;
        Boolean isValidInput = false;

        while (!isValidInput)
        {
            try
            {
                input = InputScanner.nextDouble();
                isValidInput = true;
            }
            catch (Exception e)
            {
                System.out.println(incorrectMessage);
            }
            // Clear the buffer. When using nextDouble, any other input including a newline character '\n' will be left in the buffer.
            InputScanner.nextLine();
        }

        return input;
    }

    public static double GetDouble()
    {
        return GetDouble("Invalid input. Please try again. (Double)");
    }

    public static Boolean GetBoolean(String incorrectMessage)
    {
        System.out.print("> ");

        Boolean input = false;
        Boolean isValidInput = false;

        while (!isValidInput)
        {
            try
            {
                input = InputScanner.nextBoolean();
                isValidInput = true;
            }
            catch (Exception e)
            {
                System.out.println(incorrectMessage);
            }
            // Clear the buffer. When using nextBoolean, any other input including a newline character '\n' will be left in the buffer.
            InputScanner.nextLine();
        }

        return input;
    }

    public static Boolean GetBoolean()
    {
        return GetBoolean("Invalid input. Please try again. (Boolean)");
    }

    public static void GetEnter()
    {
        InputScanner.nextLine();
    }

    // Compare, ignoring case. Returns true if equal, false otherwise.
    public static Boolean Compare(String input, String compareTo)
    {
        return input.equalsIgnoreCase(compareTo);
    }

    // Compare an array of strings, ignoring case. Returns true if any string is equal, false otherwise.
    public static Boolean Compare(String input, String[] compareTo)
    {
        for (String s : compareTo)
        {
            if (input.equalsIgnoreCase(s))
                return true;
        }

        return false;
    }
}
