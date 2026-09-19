package com.nhlstenden.week3.Apps;

public class App
{
    private String name;
    private double price;
    private boolean containsViolence;
    private boolean containsNudity;

    public App(String name, double price, boolean containsViolence, boolean containsNudity)
    {
        this.name = name;
        this.price = price;
        this.containsViolence = containsViolence;
        this.containsNudity = containsNudity;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean containsViolence()
    {
        return containsViolence;
    }

    public boolean containsNudity()
    {
        return containsNudity;
    }

    public int getMinimumAge()
    {
        if (containsNudity)
        {
            return 18;
        }

        if (containsViolence)
        {
            return 16;
        }

        return 0;
    }
}
