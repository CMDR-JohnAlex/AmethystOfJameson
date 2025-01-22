package com.cmdr_johnalex;

/**
 * The State enum represents the different states the game can be in.
 */
public enum State
{
    MainMenu,
    Playing,
    Win,
    Lose,
    Settings,
    Credits,
    Quit;

    public static State CurrentState;
}
