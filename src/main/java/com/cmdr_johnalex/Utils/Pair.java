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
}
