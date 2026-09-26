package com.nhlstenden.week4.exceptions;

public class FlightAlreadyDepartedException extends RuntimeException
{
    public FlightAlreadyDepartedException(String message)
    {
        super(message);
    }
}
