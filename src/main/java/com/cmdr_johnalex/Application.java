package com.cmdr_johnalex;

public class Application
{
    Boolean IsRunning;
    Menu Menu;
    Game Game;

    public void Initialize()
    {
        IsRunning = true;

        Menu = new Menu();
        Game = new Game();
        State.CurrentState = State.MainMenu;

        Settings.Initialize();
        Menu.Initialize();
        Game.Initialize();
    }

    public void Shutdown()
    {
        IsRunning = false;

        Menu.Shutdown();
        Game.Shutdown();
        Settings.Shutdown();
    }

    public void Run()
    {
        while (IsRunning)
        {
            switch (State.CurrentState)
            {
            case MainMenu:
                Menu.MainMenu();
                break;
            case CharacterCreation:
                Menu.CharacterCreation(Game.GetPlayer());
                break;
            case Playing:
                Game.Run();
                break;
            case Settings:
                Menu.Settings();
                break;
            case Credits:
                Menu.Credits();
                break;
            case Quit:
                IsRunning = false;
                break;
            default:
            System.out.println("We shouldn't be here.");
                IsRunning = false;
                break;
            }
        }
    }
}
