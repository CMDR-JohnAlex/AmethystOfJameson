package com.cmdr_johnalex;

// Static State class.
// This class is responsible for containing the states of the game.
// When part of the program needs to know the current state, or wants or modify the state, it modifies the variables in this class.
public class State
{
    enum Game
    {
        Menu,
        Playing
    }
    public static Game GameState;

    // Menu is a sub-state of the game state "Menu".
    // No matter the menu state, if the game state is "Menu", the menu will be displayed. Else, the game will be played.
    enum Menu
    {
        MainMenu,
        CharacterCreation,
        Settings,
        Credits
    }
    public static Menu MenuState;
}
