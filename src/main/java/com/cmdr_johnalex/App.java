package com.cmdr_johnalex;

public final class App
{
    public static void main(String[] args)
    {
        Game game = new Game();
        game.Initialize();
        game.Run();
        game.Shutdown();
    }
}
