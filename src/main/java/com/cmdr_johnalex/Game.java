package com.cmdr_johnalex;

import com.cmdr_johnalex.Items.Amethyst;
import com.cmdr_johnalex.Items.Item;
import com.cmdr_johnalex.Utils.Console;
import com.cmdr_johnalex.Utils.Input;
import com.cmdr_johnalex.Utils.Pair;

// The Game class is responsible for running the game. It will init the map class, display the user interface, allow the player to move, and handle combat.
public class Game
{
    private Player Player;
    private Map Map;
    private int TurnsTaken;
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

    public Player GetPlayer()
    {
        return Player;
    }

    public Map GetMap()
    {
        return Map;
    }

    public int GetTurns()
    {
        return TurnsTaken;
    }

    public void Run()
    {
        if (FirstRun)
        {
            Map.GenerateMap();
            FirstRun = false;
        }
        TurnsTaken += 1;

        Console.Clear();

        // Character stats/info.
        System.out.print("Name: " + Player.Data.Name);

        System.out.print("  STR: " + Player.GetStrength());
        System.out.print("  DEX: " + Player.GetDexterity());
        System.out.print("  CHA: " + Player.GetCharisma());

        System.out.print("  HP: " + Player.Data.Health + "/" + Player.Data.MaxHealth);

        System.out.println("  Gold: " + Player.Data.Gold);
        System.out.println();

        // Display the room description.
        System.out.println(Map.GetRoom(Player.Data.Location).Description);

        // Display the room contents.
        System.out.println(Map.GetRoom(Player.Data.Location).ContentDescription);

        // Display the current location.
        //System.out.println("\nYou are at: " + Player.Data.Location.ToString());
        System.out.println("\nYou are at: (" + Player.Data.Location.first + ", " + (char)(65 + Player.Data.Location.second) + ')');
        Map.GetRoom(Player.Data.Location).Visited = true;

        // Player choice.
        System.out.println("\nSo, what do you want to do? (Type 'help' for a list of commands.)");

        String input = Input.GetString();
        System.out.println();

        if (Input.Compare(input, "quit"))
        {
            State.CurrentState = State.Quit;
            return;
        }
        else if (Input.Compare(input, new String[]{"north", "n", "up"}))
        {
            System.out.println("Trying to move north...");
            if (!Player.Move(Direction.North))
            {
                System.out.println("You cannot move north. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"east", "e", "right"}))
        {
            System.out.println("Trying to move east...");
            if (!Player.Move(Direction.East))
            {
                System.out.println("You cannot move east. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"south", "s", "down"}))
        {
            System.out.println("Trying to move south...");
            if (!Player.Move(Direction.South))
            {
                System.out.println("You cannot move south. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"west", "w", "left"}))
        {
            System.out.println("Trying to move west...");
            if (!Player.Move(Direction.West))
            {
                System.out.println("You cannot move west. There is a wall.");
            }
        }
        else if (Input.Compare(input, new String[]{"compass", "directions"}))
        {
            // Ascii art compass. This took a LONG time to make.
            System.out.println("                  NORTH");
            System.out.println("              , - ~ ~ ~ - ,");
            System.out.println("          , '              .' ,");
            System.out.println("        ,              ..:XX.   ,");
            System.out.println("       ,             .:++Xx.     ,");
            System.out.println("      ,           .:+;:x$+.       ,");
            System.out.println(" WEST ,          .XX;x$$+.        , EAST");
            System.out.println("      ,        ..$$$;x$+.         ,");
            System.out.println("       ,      .:X$+:;+:          ,");
            System.out.println("        ,    .:Xx+;:.           ,");
            System.out.println("          ,  :X+:.           , '");
            System.out.println("            ' -', _ _ _ ,  '");
            System.out.println("                  SOUTH");
        }
        else if (Input.Compare(input, new String[]{"leave", "exit"}))
        {
            if (!Player.Data.Location.equals(new Pair<>(0, 0)))
            {
                System.out.println("The exit is at (0, A). You must go back to the entrance to leave.");
            }
            else
            {
                boolean hasAmethyst = false;
                for (Item item : Player.Data.Inventory)
                {
                    if (item instanceof Amethyst)
                    {
                        hasAmethyst = true;
                        break;
                    }
                }

                if (hasAmethyst)
                {
                    System.out.println("You leave the dungeon with the Amethyst.");
                    State.CurrentState = State.Win;
                }
                else
                {
                    System.out.println("You cannot leave the dungeon without the Amethyst.");
                }
            }
        }
        else if (Input.Compare(input, new String[]{"pickup", "pick up", "p"}))
        {
            switch (Map.GetRoom(Player.Data.Location).Type)
            {
            case Gold:
                Player.AddGold(Map.GetRoom(Player.Data.Location).GoldAmount);
                System.out.println("You picked up " + Map.GetRoom(Player.Data.Location).GoldAmount + " gold.");
                Map.GetRoom(Player.Data.Location).Update();
                break;
            case Item:
                Player.AddItem(Map.GetRoom(Player.Data.Location).Item);
                System.out.println("You picked up " + Map.GetRoom(Player.Data.Location).Item.Article + ' ' + Map.GetRoom(Player.Data.Location).Item.Name + ".");
                Map.GetRoom(Player.Data.Location).Update();
                break;
            case Trap:
                System.out.println("Agh! It was a trap! That hurt!");
                Player.TakeTrapDamage();

                if (Player.Data.Health <= 0)
                {
                    State.CurrentState = State.Lose;
                }

                Map.GetRoom(Player.Data.Location).Update();
                break;
            case Healing:
                System.out.println("You picked up a healing item and used it to heal yourself.");
                Player.Heal();
                Map.GetRoom(Player.Data.Location).Update();
                break;
            default:
                System.out.println("There is nothing to pick up here.");
                break;
            }
        }
        else if (Input.Compare(input, new String[]{"map" , "m"}))
        {
            Map.DisplayMap(Player.Data.Location);
        }
        else if (Input.Compare(input, new String[]{"inventory" , "i"}))
        {
            Player.DisplayInventory();
        }
        else if (Input.Compare(input, new String[]{"help" , "h"}))
        {
            System.out.println("Commands:");
            System.out.println("Compass - Display a compass.");
            System.out.println("North (n) - Move north.");
            System.out.println("East (e) - Move east.");
            System.out.println("South (s) - Move south.");
            System.out.println("West (w) - Move west.");
            System.out.println("Pickup (p) - Pick up an item, gold or healing item.");
            System.out.println("Map (m) - Display the map.");
            System.out.println("Inventory (i) - Display the player's inventory.");
            System.out.println("Help (h) - Display this help message.");
            System.out.println("Quit - Quit the game.");
        }
        else
        {
            System.out.println("Invalid input. Please try again.");
        }

        System.out.println("\nPress enter to continue...");
        Input.GetEnter();
    }
}
