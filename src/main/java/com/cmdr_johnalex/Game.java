package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Input;

// The Game class is responsible for running the game. It will init the map class, display the user interface, allow the player to move, and handle combat.
public class Game
{
    private Player Player;

    public void Initialize()
    {
        Player = new Player();
        Player.Initialize();
    }

    public void Shutdown()
    {
        Player.Shutdown();
    }

    public void Run()
    {
        System.out.println("Game is running...");
        System.out.print("The player is: ");
        System.out.println(Player.Data.Name);
        System.out.println("Press enter to return to the main menu...");
        Input.GetEnter();
        State.CurrentState = State.MainMenu;
    }
}
