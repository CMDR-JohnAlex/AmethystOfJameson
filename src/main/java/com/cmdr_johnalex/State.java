package com.cmdr_johnalex;

public enum State
{
    MainMenu,
    CharacterCreation,
    Playing,
    Win,
    Settings,
    Credits,
    Quit;

    public static State CurrentState;
}
