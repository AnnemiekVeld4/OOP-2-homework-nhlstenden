package com.nhlstenden.week2.user;

import com.nhlstenden.week2.validation.ValidationRule;

import java.util.ArrayList;
import java.util.List;

public class UserValidation
{
    private List<ValidationRule> validationRules;
    private UserStorage storage;

    public UserValidation(UserStorage storage)
    {
        this.storage = storage;
        this.validationRules = new ArrayList<>();
    }

    public void addValidationRule(ValidationRule validationRule)
    {
        validationRules.add(validationRule);
    }

    public boolean validate(User user)
    {
        for (ValidationRule validationRule : validationRules)
        {
            if (!validationRule.validate(user))
            {
                return false;
            }
        }

        storage.addUser(user);

        return true;
    }
}
