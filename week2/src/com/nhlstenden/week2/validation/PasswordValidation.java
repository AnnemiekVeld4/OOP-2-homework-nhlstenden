package com.nhlstenden.week2.validation;

import com.nhlstenden.week2.user.User;

public class PasswordValidation implements ValidationRule
{
    private boolean allowSpaces;
    private boolean requireSpecialCharacters;
    private boolean requireNumbers;
    private boolean requireLowercase;
    private boolean requireUppercase;

    public PasswordValidation(
            boolean allowSpaces,
            boolean requireSpecialCharacters,
            boolean requireNumbers,
            boolean requireLowercase,
            boolean requireUppercase
    )
    {
        this.allowSpaces = allowSpaces;
        this.requireSpecialCharacters = requireSpecialCharacters;
        this.requireNumbers = requireNumbers;
        this.requireLowercase = requireLowercase;
        this.requireUppercase = requireUppercase;
    }

    @Override
    public boolean validate(User user)
    {
        String password = user.getPassword();

        if (password == null)
        {
            return false;
        }

        if (!allowSpaces && password.contains(" "))
        {
            return false;
        }

        if (requireSpecialCharacters
                && !password.matches(".*[^A-Za-z0-9 ].*"))
        {
            return false;
        }

        if (requireNumbers
                && !password.matches(".*[0-9].*"))
        {
            return false;
        }

        if (requireLowercase
                && !password.matches(".*[a-z].*"))
        {
            return false;
        }

        if (requireUppercase
                && !password.matches(".*[A-Z].*"))
        {
            return false;
        }

        return true;
    }

    public boolean isAllowSpaces()
    {
        return allowSpaces;
    }

    public boolean isRequireSpecialCharacters()
    {
        return requireSpecialCharacters;
    }

    public boolean isRequireNumbers()
    {
        return requireNumbers;
    }

    public boolean isRequireLowercase()
    {
        return requireLowercase;
    }

    public boolean isRequireUppercase()
    {
        return requireUppercase;
    }
}
