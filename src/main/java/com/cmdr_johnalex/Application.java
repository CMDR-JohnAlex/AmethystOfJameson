package com.cmdr_johnalex;

/**
 * The Application class manages the overall lifecycle of the game.
 */
public class Application
{
    Boolean IsRunning;
    Menu Menu;
    Game Game;

    /**
     * Initializes the application and its objects.
     */
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

    /**
     * Shuts down the application and its objects.
     */
    public void Shutdown()
    {
        IsRunning = false;

        Menu.Shutdown();
        Game.Shutdown();
        Settings.Shutdown();
    }

    /**
     * Runs the application's main loop.
     */
    public void Run()
    {
        while (IsRunning)
        {
            switch (State.CurrentState)
            {
            case MainMenu:
                Menu.MainMenu(Game.GetPlayer());
                break;
            case Playing:
                Game.Run();
                break;
            case Win:
                Menu.Win(Game);
                break;
            case Lose:
                Menu.Lose(Game);
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
