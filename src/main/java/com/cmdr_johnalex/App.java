package com.cmdr_johnalex;

/**
 * The entry point for Amethyst of Jameson.
 */
public final class App
{
    /**
     * The main entry point for the application.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args)
    {
        Application game = new Application();
        game.Initialize();
        game.Run();
        game.Shutdown();
    }
}
