package com.nhlstenden.week4.exceptions;

public class NoAvailableFlightException extends RuntimeException
{
    public NoAvailableFlightException(String message)
    {
        super(message);
    }
}
