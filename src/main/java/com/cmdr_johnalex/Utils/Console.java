package com.cmdr_johnalex.Utils;

/**
 * The Console class provides methods for interacting with the console.
 */
public class Console
{
    /**
     * Initializes the Console class.
     */
    public void Initialize()
    {
    }

    /**
     * Shuts down the Console class.
     */
    public void Shutdown()
    {
    }

    /**
     * Clears the console screen.
     */
    // TODO: Optimize by doing all OS checking in the Initialize function and save to a variable, then check against the variable here.
    public static void Clear()
    {
        // There does not seem to be a nice cross platform way to clear the console.
        // Here's an attempt at clearing the screen.
        // I'm hopeful this will work 99% of the time.

        // Terminals that support ANSI
       // System.out.print("\033[H\033[2J");

        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                // This should work on Windows 10 and 11, both powershell and console.
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                // ANSI escape code clear should work sometimes, but easier to clear the Windows way.
                //System.out.print("\033[H\033[2J");
            }
            else
            {
                // TERM is defined on Unix systems, should mean supports ANSI?
                if (System.getenv().get("TERM") != null)
                {
                    // Clear using ANSI escape codes.
                    System.out.print("\033[H\033[2J");
                }
                else
                {
                    // If not, hope the clear command will work.
                    Runtime.getRuntime().exec("clear");
                }
            }
        }
        catch (final Exception e)
        {
            //  TODO: Handle exceptions
        }
    }
}
