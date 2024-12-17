package com.cmdr_johnalex;

// The Menu class is responsible for displaying the different menus.
public class Menu
{
    public void Initialize()
    {
    }

    public void Shutdown()
    {
    }

    public void MainMenu()
    {
        System.out.println("===================");
        System.out.println("Amethyst of Jameson");
        System.out.println("===================");
        System.out.println("1. New Game");
        System.out.println("2. Settings");
        System.out.println("3. Credits");
        System.out.println("4. Quit");
        System.out.println("===================");
        System.out.print("> ");
    }

    public void CharacterCreation()
    {
        System.out.println("Character Creation:");
        System.out.println("Sorry, this is not yet implemented.");
    }

    public void Settings()
    {
        Settings.SettingsMenu();
    }

    public void Credits()
    {
        System.out.println("Credits:");
        System.out.println("Sorry, this is not yet implemented.");
    }
}
