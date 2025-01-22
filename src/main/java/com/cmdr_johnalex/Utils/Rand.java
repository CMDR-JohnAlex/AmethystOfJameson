package com.cmdr_johnalex.Utils;

import java.util.Random;

import com.cmdr_johnalex.Settings;

/**
 * The Rand class provides methods for generating random numbers.
 */
public class Rand
{
    static Random Generator = new Random(Settings.GetSeed());

    /**
     * Sets the seed of the random number generator.
     *
     * @param seed The seed to set the random number generator to.
     */
    public static void SetSeed(long seed)
    {
        Generator.setSeed(seed);
    }

    /**
     * Returns a random number between min and max, inclusive. [min, max].
     *
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random number between min and max, inclusive.
     */
    public static int Range(int min, int max)
    {
        // Random.nextFloat() returns a number between 0 and 1, exclusive. [0, 1).
        return (int)(Generator.nextFloat() * ((max - min) + 1)) + min;
    }
}
