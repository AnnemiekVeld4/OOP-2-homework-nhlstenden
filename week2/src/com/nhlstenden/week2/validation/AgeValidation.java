package com.nhlstenden.week2.validation;

import com.nhlstenden.week2.user.User;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidation implements ValidationRule
{
    private int minimumAge;

    public AgeValidation(int minimumAge)
    {
        this.minimumAge = minimumAge;
    }

    @Override
    public boolean validate(User user)
    {
        LocalDate currentDate = LocalDate.now();

        int age = Period.between(
                user.getDateOfBirth(),
                currentDate
        ).getYears();

        return age >= minimumAge;
    }

    public int getMinimumAge()
    {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge)
    {
        this.minimumAge = minimumAge;
    }
}
