package com.nhlstenden.week2;

import com.nhlstenden.week2.user.User;
import com.nhlstenden.week2.user.UserStorage;
import com.nhlstenden.week2.user.UserValidation;
import com.nhlstenden.week2.validation.AgeValidation;
import com.nhlstenden.week2.validation.EmailValidation;
import com.nhlstenden.week2.validation.PasswordValidation;
import com.nhlstenden.week2.validation.UsernameValidation;

import java.time.LocalDate;

public class Main
{

    public static void main(String[] args)
    {
        UserStorage storage = new UserStorage();

        UserValidation validation = new UserValidation(storage);

        validation.addValidationRule
                (
                        new EmailValidation()
                );

        validation.addValidationRule
                (
                        new AgeValidation(18)
                );

        validation.addValidationRule
                (
                        new PasswordValidation
                                (
                                        false,
                                        true,
                                        true,
                                        true,
                                        true
                                )
                );

        validation.addValidationRule
                (
                        new UsernameValidation(storage)
                );

        User user = new User
                (
                        "Annemiek",
                        "Password123!",
                        "annemiek@example.com",
                        LocalDate.of(2005, 5, 10)
                );

        boolean valid = validation.validate(user);

        System.out.println("User valid: " + valid);
    }
}
