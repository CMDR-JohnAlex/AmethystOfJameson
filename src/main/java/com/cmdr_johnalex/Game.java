package com.cmdr_johnalex;

// The Game class is responsible for running the game. It will init the map class, display the user interface, allow the player to move, and handle combat.
public class Game
{
    public void Initialize()
    {
    }

    public void Shutdown()
    {
    }

    public void Run()
    {
        System.out.println("Game is running...");
        System.out.println("Press enter to return to the main menu...");
        Input.GetEnter();
        State.CurrentState = State.MainMenu;
    }
}
