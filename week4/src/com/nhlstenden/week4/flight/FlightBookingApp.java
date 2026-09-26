package com.nhlstenden.week4.flight;

import java.util.ArrayList;
import java.util.List;

import com.nhlstenden.week4.passenger.Luggage;
import com.nhlstenden.week4.passenger.Passenger;
import com.nhlstenden.week4.airport.Airport;
import com.nhlstenden.week4.exceptions.*;

public class FlightBookingApp
{

    private List<Flight> flights;

    public FlightBookingApp()
    {
        this.flights = new ArrayList<>();
    }

    public List<Flight> getFlights()
    {
        return flights;
    }

    public void addFlight(Flight flight)
    {
        flights.add(flight);
    }

    public Flight bookTicket(
            String name,
            Airport departure,
            Airport arrival,
            List<Luggage> luggage
    )
    {
        Flight flight = findAvailableFlight(departure, arrival);

        Passenger passenger = new Passenger(name);

        for (Luggage item : luggage)
        {
            passenger.addLuggage(item);
        }

        flight.addPassenger(passenger);

        return flight;
    }

    public Flight findAvailableFlight(
            Airport departure,
            Airport arrival
    )
    {
        for (Flight flight : flights)
        {

            boolean correctDeparture =
                    flight.getDepartureAirport().equals(departure);

            boolean correctArrival =
                    flight.getArrivalAirport().equals(arrival);

            if (correctDeparture
                    && correctArrival
                    && !flight.hasDeparted()
                    && flight.hasAvailableSeat())
            {

                return flight;
            }
        }

        throw new NoAvailableFlightException(
                "No available flight found."
        );
    }
}
