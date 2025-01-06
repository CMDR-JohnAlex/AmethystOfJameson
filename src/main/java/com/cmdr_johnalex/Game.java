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

        // Player choice.
        System.out.println("So, what do you want to do?");

        String input = Input.GetString();

        if (Input.Compare(input, "quit"))
        {
            State.CurrentState = State.Quit;
            return;
        }
        else if (Input.Compare(input, new String[]{"north", "n"}))
        {
            System.out.println("Trying to move north...");
            if (!Player.Move(Direction.North))
            {
                System.out.println("You cannot move north. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"east", "e"}))
        {
            System.out.println("Trying to move east...");
            if (!Player.Move(Direction.East))
            {
                System.out.println("You cannot move east. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"south", "s"}))
        {
            System.out.println("Trying to move south...");
            if (!Player.Move(Direction.South))
            {
                System.out.println("You cannot move south. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"west", "w"}))
        {
            System.out.println("Trying to move west...");
            if (!Player.Move(Direction.West))
            {
                System.out.println("You cannot move west. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"pickup", "pick up"}))
        {
            switch (Map.GetRoom(Player.Data.Location).Type)
            {
            case Gold:
                Player.Data.Gold += Map.GetRoom(Player.Data.Location).GoldAmount;
                System.out.println("You picked up " + Map.GetRoom(Player.Data.Location).GoldAmount + " gold.");
                Map.GetRoom(Player.Data.Location).Update();
                break;
            case Item:
                // TODO: Implement item pickup.
                System.out.println("Sorry, this has not been implemented yet.");
                break;
            case Monster:
                // TODO: Implement combat.
                System.out.println("Sorry, this has not been implemented yet.");
                break;
            default:
                System.out.println("There is nothing to pick up here.");
                break;
            }
        }
        else if (Input.Compare(input, new String[]{"map" , "m"}))
        {
            // TODO: Display map.
        }
        else if (Input.Compare(input, new String[]{"help" , "h"}))
        {
            System.out.println("Commands:");
            System.out.println("North (n) - Move north.");
            System.out.println("East (e) - Move east.");
            System.out.println("South (s) - Move south.");
            System.out.println("West (w) - Move west.");
            System.out.println("Pickup - Pick up an item or gold.");
            System.out.println("Map (m) - Display the map.");
            System.out.println("Help (h) - Display this help message.");
            System.out.println("Quit - Quit the game.");
        }
        else
        {
            System.out.println("Invalid input. Please try again.");
        }

        System.out.println("Press enter to continue...");
        Input.GetEnter();
    }
}
