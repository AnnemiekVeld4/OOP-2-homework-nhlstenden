package com.nhlstenden.week4;

import com.nhlstenden.week4.airport.Airport;
import com.nhlstenden.week4.airport.CommercialAirplane;
import com.nhlstenden.week4.flight.Flight;
import com.nhlstenden.week4.flight.Flight24Uploader;
import com.nhlstenden.week4.flight.FlightBookingApp;
import com.nhlstenden.week4.passenger.Luggage;
import com.nhlstenden.week4.passenger.LuggageType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        Airport jfk = new Airport("JFK");
        Airport ams = new Airport("AMS");
        Airport mex = new Airport("MEX");
        Airport lax = new Airport("LAX");

        addDistanceBothWays(jfk, ams, 5848);
        addDistanceBothWays(jfk, mex, 3366);
        addDistanceBothWays(jfk, lax, 3975);
        addDistanceBothWays(ams, mex, 9206);
        addDistanceBothWays(ams, lax, 8956);
        addDistanceBothWays(mex, lax, 2500);

        CommercialAirplane airplane =
                new CommercialAirplane(
                        "KLM124",
                        500000,
                        100,
                        20
                );

        Flight flight = new Flight(
                LocalDateTime.of(2026, 9, 26, 12, 54),
                ams,
                lax,
                airplane
        );

        FlightBookingApp bookingApp =
                new FlightBookingApp();

        bookingApp.addFlight(flight);

        List<Luggage> luggage = new ArrayList<>();

        luggage.add(
                new Luggage(
                        8.5,
                        LuggageType.CARRY_ON
                )
        );

        luggage.add(
                new Luggage(
                        20,
                        LuggageType.HOLD
                )
        );

        bookingApp.bookTicket(
                "Annemiek",
                ams,
                lax,
                luggage
        );

        System.out.println(
                "Passengers: "
                        + flight.getPassengers().size()
        );

        System.out.println(
                "Required fuel: "
                        + flight.getRequiredFuel()
        );

        Flight24Uploader uploader =
                new Flight24Uploader();

        uploader.upload(flight);
        uploader.upload(airplane);

        for (String information : uploader.getData())
        {
            System.out.println(information);
        }

        flight.depart();

        System.out.println(
                "Status: " + flight.getStatus()
        );
    }

    private static void addDistanceBothWays(
            Airport firstAirport,
            Airport secondAirport,
            int distance
    )
    {
        firstAirport.addDistance(
                secondAirport,
                distance
        );

        secondAirport.addDistance(
                firstAirport,
                distance
        );
    }
}
