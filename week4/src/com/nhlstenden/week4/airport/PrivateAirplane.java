package com.nhlstenden.week4.airport;

import com.nhlstenden.week4.exceptions.*;

public class PrivateAirplane extends Airplane
{

    private int numberOfSeats;
    private int seatsTaken;

    public PrivateAirplane(
            String code,
            double currentFuelLevel,
            int numberOfSeats
    )
    {
        super(code, currentFuelLevel);

        if (numberOfSeats <= 0)
        {
            throw new IllegalArgumentException(
                    "Number of seats must be greater than 0."
            );
        }

        this.numberOfSeats = numberOfSeats;
        this.seatsTaken = 0;
    }

    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }

    public int getSeatsTaken()
    {
        return seatsTaken;
    }

    @Override
    public boolean hasAvailableSeat()
    {
        return seatsTaken < numberOfSeats;
    }

    @Override
    public void reserveSeat()
    {
        if (!hasAvailableSeat())
        {
            throw new NoAvailableSeatsException(
                    "No seats available on airplane " + getCode()
            );
        }

        seatsTaken++;
    }

    @Override
    public int getEmptySeats()
    {
        return numberOfSeats - seatsTaken;
    }

    @Override
    public double calculateFuelUsage(
            int distance,
            double luggageWeight
    )
    {
        return (numberOfSeats * 1.31 * distance)
                + (seatsTaken * 1.87)
                + (luggageWeight * 0.4);
    }

    @Override
    public String getFlight24Info()
    {
        return "P: "
                + getCode()
                + ". "
                + getCurrentFuelLevel()
                + " liter fuel. "
                + getEmptySeats()
                + " empty seats.";
    }
}
