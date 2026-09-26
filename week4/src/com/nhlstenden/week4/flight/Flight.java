package com.nhlstenden.week4.flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.nhlstenden.week4.passenger.Passenger;
import com.nhlstenden.week4.airport.Airplane;
import com.nhlstenden.week4.airport.Airport;
import com.nhlstenden.week4.airport.PrivateAirplane;
import com.nhlstenden.week4.exceptions.*;

public class Flight
{

    private LocalDateTime departureTime;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private FlightStatus status;
    private Airplane airplane;
    private List<Passenger> passengers;

    public Flight(
            LocalDateTime departureTime,
            Airport departureAirport,
            Airport arrivalAirport,
            Airplane airplane
    )
    {
        this.departureTime = departureTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.airplane = airplane;

        this.status = FlightStatus.AWAITING_DEPARTURE;
        this.passengers = new ArrayList<>();
    }

    public LocalDateTime getDepartureTime()
    {
        return departureTime;
    }

    public Airport getDepartureAirport()
    {
        return departureAirport;
    }

    public Airport getArrivalAirport()
    {
        return arrivalAirport;
    }

    public FlightStatus getStatus()
    {
        return status;
    }

    public void setStatus(FlightStatus status)
    {
        this.status = status;
    }

    public Airplane getAirplane()
    {
        return airplane;
    }

    public List<Passenger> getPassengers()
    {
        return passengers;
    }

    public int getDistance()
    {
        return departureAirport.getDistanceTo(arrivalAirport);
    }

    public boolean hasDeparted()
    {
        return status == FlightStatus.DEPARTED
                || status == FlightStatus.LANDED;
    }

    public boolean hasAvailableSeat()
    {
        return airplane.hasAvailableSeat();
    }

    public void addPassenger(Passenger passenger)
    {
        if (hasDeparted())
        {
            throw new FlightAlreadyDepartedException(
                    "Cannot book a passenger on a departed flight."
            );
        }

        if (!airplane.hasAvailableSeat())
        {
            throw new NoAvailableSeatsException(
                    "There are no available seats."
            );
        }

        if (airplane instanceof PrivateAirplane
                && passenger.hasHoldLuggage())
        {

            throw new InvalidLuggageException(
                    "Private airplanes cannot carry hold luggage."
            );
        }

        airplane.reserveSeat();
        passengers.add(passenger);
    }

    public double getTotalLuggageWeight()
    {
        double totalWeight = 0;

        for (Passenger passenger : passengers)
        {
            totalWeight += passenger.getTotalLuggageWeight();
        }

        return totalWeight;
    }

    public double getRequiredFuel()
    {
        return airplane.calculateFuelUsage(
                getDistance(),
                getTotalLuggageWeight()
        );
    }

    public void depart()
    {
        if (hasDeparted())
        {
            throw new FlightAlreadyDepartedException(
                    "The flight has already departed."
            );
        }

        double requiredFuel = getRequiredFuel();

        if (airplane.getCurrentFuelLevel() < requiredFuel)
        {
            throw new InsufficientFuelException(
                    "The airplane does not have enough fuel."
            );
        }

        airplane.setCurrentFuelLevel(
                airplane.getCurrentFuelLevel() - requiredFuel
        );

        status = FlightStatus.DEPARTED;
    }

    public String getFlight24Info()
    {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "F: "
                + departureAirport.getCode()
                + " -> "
                + arrivalAirport.getCode()
                + ". Departure "
                + departureTime.format(formatter)
                + ".";
    }
}
