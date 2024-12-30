package com.cmdr_johnalex;

import com.cmdr_johnalex.Utils.Console;
import com.cmdr_johnalex.Utils.Input;

enum Direction
{
    North,
    East,
    South,
    West
}

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

    // Moves the player in the given direction. Returns true if the player was able to move, false otherwise.
    public Boolean MovePlayer(Direction direction)
    {
        switch (direction)
        {
        case North:
            if (Player.Data.Location.second > 0)
            {
                Player.Data.Location.second--;
                return true;
            }
            break;
        case East:
            if (Player.Data.Location.first < Settings.GetMapWidth() - 1)
            {
                Player.Data.Location.first++;
                return true;
            }
            break;
        case South:
            if (Player.Data.Location.second < Settings.GetMapHeight() - 1)
            {
                Player.Data.Location.second++;
                return true;
            }
            break;
        case West:
            if (Player.Data.Location.first > 0)
            {
                Player.Data.Location.first--;
                return true;
            }
            break;
        }

        return false;
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
            if (!MovePlayer(Direction.North))
            {
                System.out.println("You cannot move north. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"east", "e"}))
        {
            System.out.println("Trying to move east...");
            if (!MovePlayer(Direction.East))
            {
                System.out.println("You cannot move east. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"south", "s"}))
        {
            System.out.println("Trying to move south...");
            if (!MovePlayer(Direction.South))
            {
                System.out.println("You cannot move south. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"west", "w"}))
        {
            System.out.println("Trying to move west...");
            if (!MovePlayer(Direction.West))
            {
                System.out.println("You cannot move west. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"pickup", "pick up"}))
        {
            if (Map.GetRoom(Player.Data.Location).Type == RoomType.Gold)
            {
                Player.Data.Gold += Map.GetRoom(Player.Data.Location).GoldAmount;
                System.out.println("You picked up " + Map.GetRoom(Player.Data.Location).GoldAmount + " gold.");
                Map.GetRoom(Player.Data.Location).Update();
            }
            else if (Map.GetRoom(Player.Data.Location).Type == RoomType.Item)
            {
                // TODO: Implement item pickup.
                System.out.println("Sorry, this has not been implemented yet.");
            }
            else if (Map.GetRoom(Player.Data.Location).Type == RoomType.Monster)
            {
                // TODO: Implement combat.
                System.out.println("Sorry, this has not been implemented yet.");
            }
            else
            {
                System.out.println("There is nothing to pick up here.");
            }
        }
        else if (Input.Compare(input, new String[]{"map" , "m"}))
        {
            // TODO: Display map.
        }
        else if (Input.Compare(input, new String[]{"help" , "h"}))
        {
            // TODO: Display help.
        }
        else
        {
            System.out.println("Invalid input. Please try again.");
        }

        System.out.println("Press enter to continue...");
        Input.GetEnter();
    }
}
