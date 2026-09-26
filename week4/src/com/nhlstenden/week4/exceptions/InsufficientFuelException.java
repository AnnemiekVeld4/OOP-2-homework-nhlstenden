package com.nhlstenden.week4.exceptions;

public class InsufficientFuelException extends RuntimeException
{
    public InsufficientFuelException(String message)
    {
        super(message);
    }
}
