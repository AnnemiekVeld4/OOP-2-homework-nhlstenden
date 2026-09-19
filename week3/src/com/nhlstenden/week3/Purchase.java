package com.nhlstenden.week3;

public class Purchase
{
    private User user;
    private App app;

    public Purchase(User user, App app)
    {
        this.user = user;
        this.app = app;
    }

    public User getUser()
    {
        return user;
    }

    public App getApp()
    {
        return app;
    }
}
