package com.cmdr_johnalex;

public class Game
{
    Boolean isRunning;

    enum GameState
    {
        None,
        Menu,
        Playing,
        End
    }
    GameState state;

    public void Initialize()
    {
        System.out.println("Game is initializing...");
        isRunning = true;
        state = GameState.Menu;

        System.out.println("Settings.test is " + Settings.test);
        Settings.test = true;
        System.out.println("Settings.test is " + Settings.test);
    }

    public void Shutdown()
    {
        System.out.println("Game is shutting down...");
        isRunning = false;
    }

    public void Run()
    {
        while (isRunning)
        {
            System.out.println("Game is running...");

            switch (state)
            {
            case Menu:
                System.out.println("Game is in the menu state.");
                break;
            case Playing:
                System.out.println("Game is in the playing state.");
                break;
            case End:
                System.out.println("Game is in the end state.");
                break;
            default:
            System.out.println("We shouldn't be here.");
                isRunning = false;
                break;
            }
        }
    }
}
