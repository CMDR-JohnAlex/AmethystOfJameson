package com.cmdr_johnalex;

// The Game class is responsible for running the game. It will init the map class, display the user interface, allow the player to move, and handle combat.
public class Game
{
    public void Initialize()
    {
        State.GameState = State.Game.Menu;
    }

    public void Shutdown()
    {
    }

    public void Run()
    {
        System.out.println("Game is running...");
    }
}
