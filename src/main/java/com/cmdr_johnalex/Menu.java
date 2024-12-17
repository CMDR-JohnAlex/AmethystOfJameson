package com.cmdr_johnalex;

// The Menu class is responsible for displaying the main menu, character creation, settings, and credits.
public class Menu
{
    public void Initialize()
    {
        State.MenuState = State.Menu.MainMenu;
    }

    public void Shutdown()
    {
    }

    public void Run()
    {
        switch (State.MenuState)
        {
        case MainMenu:
            MainMenu();
            break;
        case CharacterCreation:
            System.out.println("Character Creation is not implemented yet.");
            State.MenuState = State.Menu.MainMenu;
            State.GameState = State.Game.Playing;
            break;
        case Settings:
            Settings.SettingsMenu();
            break;
        case Credits:
            System.out.println("Credits is not implemented yet.");
            break;
        default:
            System.out.println("We shouldn't be here.");
            break;
        }
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
}
