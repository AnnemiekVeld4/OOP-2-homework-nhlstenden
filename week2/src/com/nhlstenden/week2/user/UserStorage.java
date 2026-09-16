package com.nhlstenden.week2.user;

import java.util.ArrayList;
import java.util.List;

public class UserStorage
{
    private List<User> users;

    public UserStorage()
    {
        users = new ArrayList<>();
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public boolean usernameExists(String name)
    {
        for (User user : users)
        {
            if (user.getName().equalsIgnoreCase(name))
            {
                return true;
            }
        }

        return false;
    }

    public List<User> getUsers()
    {
        return users;
    }
}
