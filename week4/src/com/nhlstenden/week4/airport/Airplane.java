package com.nhlstenden.week4.airport;

public abstract class Airplane
{

    private String code;
    private double currentFuelLevel;

    public Airplane(String code, double currentFuelLevel)
    {
        if (code == null || code.isBlank())
        {
            throw new IllegalArgumentException("Airplane code cannot be empty.");
        }

        if (currentFuelLevel < 0)
        {
            throw new IllegalArgumentException("Fuel level cannot be negative.");
        }

        this.code = code;
        this.currentFuelLevel = currentFuelLevel;
    }

    public String getCode()
    {
        return code;
    }

    public double getCurrentFuelLevel()
    {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel)
    {
        if (currentFuelLevel < 0)
        {
            throw new IllegalArgumentException("Fuel level cannot be negative.");
        }

        this.currentFuelLevel = currentFuelLevel;
    }

    public abstract double calculateFuelUsage(
            int distance,
            double luggageWeight
    );

    public abstract boolean hasAvailableSeat();

    public abstract void reserveSeat();

    public abstract int getEmptySeats();

    public abstract String getFlight24Info();
}
