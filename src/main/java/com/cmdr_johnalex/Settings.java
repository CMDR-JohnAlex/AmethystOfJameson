package com.cmdr_johnalex;

// Static Settings class.
// This class is responsible for loading and saving settings, as well as providing access to settings.
// The class is static so that it can be accessed from anywhere in the program.
public class Settings
{
    public static Boolean test = false;

    public static void Initialize()
    {
        // TODO: Load settings from file.
    }

    public static void Shutdown()
    {
        // TODO: Save settings to file.
    }

    public static void SettingsMenu()
    {
        System.out.println("Settings:");
        System.out.println("1. Test: " + test);

        System.out.println("Input a number to change a setting, or 0 to return to the main menu.");
        System.out.print("> ");

        State.MenuState = State.Menu.MainMenu;
    }
}
