package com.nhlstenden.week4.airport;

import java.util.HashMap;
import java.util.Map;

public class Airport
{

    private String code;
    private Map<Airport, Integer> distances;

    public Airport(String code)
    {
        if (code == null || code.isBlank())
        {
            throw new IllegalArgumentException("Airport code cannot be empty.");
        }

        this.code = code;
        this.distances = new HashMap<>();
    }

    public String getCode()
    {
        return code;
    }

    public void addDistance(Airport airport, int distance)
    {
        if (distance <= 0)
        {
            throw new IllegalArgumentException("Distance must be greater than 0.");
        }

        distances.put(airport, distance);
    }

    public int getDistanceTo(Airport airport)
    {
        Integer distance = distances.get(airport);

        if (distance == null)
        {
            throw new IllegalArgumentException(
                    "No distance known between " + code + " and " + airport.getCode()
            );
        }

        return distance;
    }

    @Override
    public String toString()
    {
        return code;
    }
}
