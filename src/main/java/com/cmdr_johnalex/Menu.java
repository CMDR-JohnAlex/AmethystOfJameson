package com.cmdr_johnalex;

// The Menu class is responsible for displaying the main menu, character creation, settings, and credits.
public class Menu
{
    enum MenuState
    {
        MainMenu,
        CharacterCreation,
        Settings,
        Credits
    }

    public void Initialize()
    {
        System.out.println("Menu is initializing...");
    }

    public void Shutdown()
    {
        System.out.println("Menu is shutting down...");
    }

    public void Run()
    {
        System.out.println("Menu is running...");
    }
}
