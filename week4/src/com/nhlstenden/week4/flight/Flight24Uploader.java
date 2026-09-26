package com.nhlstenden.week4.flight;

import com.nhlstenden.week4.airport.Airplane;

import java.util.ArrayList;
import java.util.List;

public class Flight24Uploader
{

    private List<String> data;

    public Flight24Uploader()
    {
        this.data = new ArrayList<>();
    }

    public void upload(Flight flight)
    {
        data.add(flight.getFlight24Info());
    }

    public void upload(Airplane airplane)
    {
        data.add(airplane.getFlight24Info());
    }

    public List<String> getData()
    {
        return data;
    }
}