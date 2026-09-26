package com.nhlstenden.week4.exceptions;

public class NoAvailableSeatsException extends RuntimeException
{
    public NoAvailableSeatsException(String message)
    {
        super(message);
    }
}
