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
            switch (State.GameState)
            {
            case Menu:
                menu.Run();
                break;
            case Playing:
                game.Run();
                break;
            default:
            System.out.println("We shouldn't be here.");
                isRunning = false;
                break;
            }
        }
    }
}
