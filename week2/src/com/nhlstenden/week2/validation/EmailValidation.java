package com.nhlstenden.week2.validation;

import com.nhlstenden.week2.user.User;

public class EmailValidation implements ValidationRule
{

    @Override
    public boolean validate(User user)
    {
        String email = user.getEmail();

        if (email == null)
        {
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
