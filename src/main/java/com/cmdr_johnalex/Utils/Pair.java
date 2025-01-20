package com.cmdr_johnalex.Utils;

public class Pair<A, B>
{
    public A first;
    public B second;

    public Pair(A first, B second)
    {
        this.first = first;
        this.second = second;
    }

    public String ToString()
    {
        return "(" + first + ", " + second + ")";
    }

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
