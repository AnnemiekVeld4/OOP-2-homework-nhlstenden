package com.nhlstenden.week4.passenger;

public class Luggage
{

    private double weight;
    private LuggageType type;

    public Luggage(double weight, LuggageType type)
    {
        if (weight <= 0)
        {
            throw new IllegalArgumentException("Luggage must weigh something!");
        }

        this.weight = weight;
        this.type = type;
    }

    public double getWeight()
    {
        return weight;
    }

    public LuggageType getType()
    {
        return type;
    }
}
