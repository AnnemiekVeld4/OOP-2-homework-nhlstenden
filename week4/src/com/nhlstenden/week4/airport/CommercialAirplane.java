package com.nhlstenden.week4.airport;

import com.nhlstenden.week4.exceptions.*;

public class CommercialAirplane extends Airplane
{

    private int economySeats;
    private int businessSeats;

    private int economySeatsTaken;
    private int businessSeatsTaken;

    public CommercialAirplane(
            String code,
            double currentFuelLevel,
            int economySeats,
            int businessSeats
    )
    {
        super(code, currentFuelLevel);

        if (economySeats < 0 || businessSeats < 0)
        {
            throw new IllegalArgumentException(
                    "Number of seats cannot be negative."
            );
        }

        if (economySeats + businessSeats == 0)
        {
            throw new IllegalArgumentException(
                    "Airplane must have at least one seat."
            );
        }

        this.economySeats = economySeats;
        this.businessSeats = businessSeats;
        this.economySeatsTaken = 0;
        this.businessSeatsTaken = 0;
    }

    public int getEconomySeats()
    {
        return economySeats;
    }

    public int getBusinessSeats()
    {
        return businessSeats;
    }

    public int getEconomySeatsTaken()
    {
        return economySeatsTaken;
    }

    public int getBusinessSeatsTaken()
    {
        return businessSeatsTaken;
    }

    @Override
    public boolean hasAvailableSeat()
    {
        return economySeatsTaken < economySeats
                || businessSeatsTaken < businessSeats;
    }

    @Override
    public void reserveSeat()
    {
        if (economySeatsTaken < economySeats)
        {
            economySeatsTaken++;
            return;
        }

        if (businessSeatsTaken < businessSeats)
        {
            businessSeatsTaken++;
            return;
        }

        throw new NoAvailableSeatsException(
                "No seats available on airplane " + getCode()
        );
    }

    @Override
    public int getEmptySeats()
    {
        int totalSeats = economySeats + businessSeats;
        int totalSeatsTaken = economySeatsTaken + businessSeatsTaken;

        return totalSeats - totalSeatsTaken;
    }

    @Override
    public double calculateFuelUsage(
            int distance,
            double luggageWeight
    )
    {
        return ((economySeats * 1.75)
                + (businessSeats * 1.98))
                * distance
                + (economySeatsTaken * 2.02)
                + (businessSeatsTaken * 2.87)
                + (luggageWeight * 0.3);
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
