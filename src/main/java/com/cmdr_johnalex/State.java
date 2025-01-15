package com.cmdr_johnalex;

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
