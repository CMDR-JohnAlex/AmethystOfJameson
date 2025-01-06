package com.cmdr_johnalex.Utils;

import java.util.Random;

import com.cmdr_johnalex.Settings;

public class Rand
{
    static Random Generator = new Random(Settings.GetSeed());

    public static void SetSeed(long seed)
    {
        Generator.setSeed(seed);
    }

    // Returns a random number between min and max, inclusive. [min, max].
    public static int Range(int min, int max)
    {
        // Random.nextFloat() returns a number between 0 and 1, exclusive. [0, 1).
        return (int)(Generator.nextFloat() * ((max - min) + 1)) + min;
    }
}
