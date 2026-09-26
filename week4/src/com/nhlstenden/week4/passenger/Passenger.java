package com.nhlstenden.week4.passenger;

import java.util.ArrayList;
import java.util.List;

import com.nhlstenden.week4.exceptions.*;

public class Passenger
{

    private String name;
    private List<Luggage> luggage;

    public Passenger(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Passenger name cannot be empty.");
        }

        this.name = name;
        this.luggage = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public List<Luggage> getLuggage()
    {
        return luggage;
    }

    public void addLuggage(Luggage newLuggage)
    {
        if (newLuggage.getType() == LuggageType.CARRY_ON && getCarryOnLuggage() != null)
        {
            throw new InvalidLuggageException(
                    "A passenger can only have one piece of carry-on luggage."
            );
        }

        luggage.add(newLuggage);
    }

    public Luggage getCarryOnLuggage()
    {
        for (Luggage item : luggage)
        {
            if (item.getType() == LuggageType.CARRY_ON)
            {
                return item;
            }
        }

        return null;
    }

    public List<Luggage> getHoldLuggage()
    {
        List<Luggage> holdLuggage = new ArrayList<>();

        for (Luggage item : luggage)
        {
            if (item.getType() == LuggageType.HOLD)
            {
                holdLuggage.add(item);
            }
        }

        return holdLuggage;
    }

    public double getTotalLuggageWeight()
    {
        double totalWeight = 0;

        for (Luggage item : luggage)
        {
            totalWeight += item.getWeight();
        }

        return totalWeight;
    }

    public boolean hasHoldLuggage()
    {
        return !getHoldLuggage().isEmpty();
    }
}
