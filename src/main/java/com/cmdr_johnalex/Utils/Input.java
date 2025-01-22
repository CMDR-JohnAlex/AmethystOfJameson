package com.cmdr_johnalex.Utils;

import java.util.Scanner;

/**
 * The Input class provides methods for getting input from the user.
 */
public class Input
{
    static Scanner InputScanner = new Scanner(System.in);

    /**
     * Gets a string input from the user.
     * The input is deemed invalid if it is empty.
     * The function will repeat until a valid input is given.
     *
     * @param incorrectMessage The message to display when the input is incorrect.
     * @return The string input from the user.
     */
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
            else
                System.out.println(incorrectMessage);
        }

        return input;
    }

    /**
     * Gets a string input from the user.
     * The input is deemed invalid if it is empty.
     * The function will repeat until a valid input is given.
     *
     * @return The string input from the user.
     */
    public static String GetString()
    {
        return GetString("Invalid input. Please try again. (String)");
    }

    /**
     * Gets an integer input from the user.
     * The input is deemed invalid if it is not an integer.
     * The function will repeat until a valid input is given.
     *
     * @param incorrectMessage The message to display when the input is incorrect.
     * @return The integer input from the user.
     */
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
            // Clear the buffer. When using nextInt, any other input including a newline character '\n' will be left in the buffer.
            InputScanner.nextLine();
        }

        return input;
    }

    /**
     * Gets an integer input from the user.
     * The input is deemed invalid if it is not an integer.
     * The function will repeat until a valid input is given.
     *
     * @return The integer input from the user.
     */
    public static int GetInt()
    {
        return GetInt("Invalid input. Please try again. (Int)");
    }

    /**
     * Gets a double input from the user.
     * The input is deemed invalid if it is not a double.
     * The function will repeat until a valid input is given.
     *
     * @param incorrectMessage The message to display when the input is incorrect.
     * @return The double input from the user.
     */
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

    /**
     * Gets a double input from the user.
     * The input is deemed invalid if it is not a double.
     * The function will repeat until a valid input is given.
     *
     * @return The double input from the user.
     */
    public static double GetDouble()
    {
        return GetDouble("Invalid input. Please try again. (Double)");
    }

    /**
     * Gets a boolean input from the user.
     * The input is deemed invalid if it is not a boolean.
     * The function will repeat until a valid input is given.
     *
     * @param incorrectMessage The message to display when the input is incorrect.
     * @return The boolean input from the user.
     */
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

    /**
     * Gets a boolean input from the user.
     * The input is deemed invalid if it is not a boolean.
     * The function will repeat until a valid input is given.
     *
     * @return The boolean input from the user.
     */
    public static Boolean GetBoolean()
    {
        return GetBoolean("Invalid input. Please try again. (Boolean)");
    }

    /**
     * Gets the enter key from the user.
     */
    public static void GetEnter()
    {
        InputScanner.nextLine();
    }

    /**
     * Compares two strings, ignoring case.
     *
     * @param input The input string.
     * @param compareTo The string to compare to.
     * @return True if the strings are equal, false otherwise.
     */
    public static Boolean Compare(String input, String compareTo)
    {
        return input.equalsIgnoreCase(compareTo);
    }

    /**
     * Compares a string to an array of strings, ignoring case.
     * Will return true if the input string is equal to any of the strings in the array.
     *
     * @param input The input string.
     * @param compareTo The array of strings to compare to.
     * @return True if the input string is equal to any of the strings in the array, false otherwise.
     */
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
