package com.nhlstenden.week3;

import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public User(String name, String email, LocalDate dateOfBirth)
    {
        this.name = name;
        this.dateOfBirth = dateOfBirth;

        if (EmailValidator.validate(email))
        {
            this.email = email;
        } else
        {
            this.email = null;
        }
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public int getAge()
    {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
