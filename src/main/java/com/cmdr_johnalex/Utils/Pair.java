package com.cmdr_johnalex.Utils;

/**
 * The Pair class represents a pair of objects.
 *
 * @param <A> The type of the first object.
 * @param <B> The type of the second object.
 */
public class Pair<A, B>
{
    public A first;
    public B second;

    /**
     * Initializes the pair with the given values.
     *
     * @param first The first object.
     * @param second The second object.
     */
    public Pair(A first, B second)
    {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns a string representation of the pair.
     *
     * @return A string representation of the pair.
     */
    public String ToString()
    {
        return "(" + first + ", " + second + ")";
    }

    /**
     * Returns if the pair is equal to another pair object.
     *
     * @param obj The Pair object to compare to.
     * @return True if the pair is equal to the other pair object, false otherwise.
     */
    // The regular equals method doesn't work for some reason, so we override it to work and hope it matches the implementation documentation stating that it must return true if blah blah?
    @Override
    public boolean equals(Object obj)
    {
       if (!(obj instanceof Pair<?, ?>))
            return false;
        if (obj == this)
            return true;

        Pair<?, ?> secondPair = (Pair<?, ?>)obj;

        return first.equals(secondPair.first) && second.equals(secondPair.second);
    }

    /**
     * Returns a hash code value for the pair.
     *
     * @return A hash code value for the pair.
     */
    /*
    The equals() API states:
    > It is generally necessary to override the hashCode method whenever [the equals] method is overridden, so as to maintain
    > the general contract for the hashCode method, which states that equal objects must have equal hash codes.

    Although this function is not currently used, let's remove the warning by implementing it.
     */
    @Override
    public int hashCode()
    {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
