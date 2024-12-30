package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Console;
import com.cmdr_johnalex.Utils.Input;

// The Game class is responsible for running the game. It will init the map class, display the user interface, allow the player to move, and handle combat.
public class Game
{
    private Player Player;
    private Map Map;
    private Boolean FirstRun;

    public void Initialize()
    {
        Player = new Player();
        Player.Initialize();
        Map = new Map();
        Map.Initialize();
        FirstRun = true;
    }

    public void Shutdown()
    {
        Map.Shutdown();
        Player.Shutdown();
    }

    public void Run()
    {
        if (FirstRun)
        {
            Map.GenerateMap();
            FirstRun = false;
        }

        Console.Clear();

        // Character stats/info.
        System.out.println("Name: " + Player.Data.Name);

        System.out.println("STR: " + Player.Data.Strength);
        System.out.println("DEX: " + Player.Data.Dexterity);
        System.out.println("CHA: " + Player.Data.Charisma);

        System.out.println("HP: " + Player.Data.Health + "/" + Player.Data.MaxHealth);

        System.out.println("Gold: " + Player.Data.Gold);

        // Display the room description.
        System.out.println(Map.GetRoom(Player.Data.Location).Description);

        // Display the room contents.
        System.out.println(Map.GetRoom(Player.Data.Location).ContentDescription);

        // Display the current location.
        System.out.println("You are at: " + Player.Data.Location.ToString());

        // Temp.
        Player.Data.Gold += Map.GetRoom(Player.Data.Location).GoldAmount;
        System.out.println("You picked up " + Map.GetRoom(Player.Data.Location).GoldAmount + " gold.");
        Map.GetRoom(Player.Data.Location).Update();

        // Display input options.
        System.out.println("Press enter to continue...");
        Input.GetEnter();
        //State.CurrentState = State.MainMenu;
    }
}
