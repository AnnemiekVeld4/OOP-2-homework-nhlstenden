package com.nhlstenden.week2.validation;

import com.nhlstenden.week2.user.User;
import com.nhlstenden.week2.user.UserStorage;

public class UsernameValidation implements ValidationRule
{
    private UserStorage storage;

    public UsernameValidation(UserStorage storage)
    {
        this.storage = storage;
    }

    @Override
    public boolean validate(User user)
    {
        return !storage.usernameExists(user.getName());
    }
}
