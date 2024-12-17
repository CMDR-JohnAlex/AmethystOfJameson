package com.cmdr_johnalex;

public class Application
{
    Boolean isRunning;
    Menu menu;
    Game game;

    public void Initialize()
    {
        isRunning = true;

        menu = new Menu();
        game = new Game();
        State.CurrentState = State.MainMenu;

        Settings.Initialize();
        menu.Initialize();
        game.Initialize();
    }

    public void Shutdown()
    {
        isRunning = false;

        menu.Shutdown();
        game.Shutdown();
        Settings.Shutdown();
    }

    public void Run()
    {
        while (isRunning)
        {
            switch (State.CurrentState)
            {
            case MainMenu:
                menu.MainMenu();
                break;
            case CharacterCreation:
                menu.CharacterCreation();
                break;
            case Playing:
                game.Run();
                break;
            case Settings:
                menu.Settings();
                break;
            case Credits:
                menu.Credits();
                break;
            default:
            System.out.println("We shouldn't be here.");
                isRunning = false;
                break;
            }
        }
    }
}
