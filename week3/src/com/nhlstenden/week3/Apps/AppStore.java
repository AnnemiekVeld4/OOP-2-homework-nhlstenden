package com.nhlstenden.week3.Apps;

import com.nhlstenden.week3.DownloadNotAllowedException;
import com.nhlstenden.week3.Users.User;

import java.util.ArrayList;
import java.util.List;

public abstract class AppStore
{
    private Currency currency;
    private List<App> apps;
    private List<Purchase> purchases;

    public AppStore(Currency currency)
    {
        this.currency = currency;
        this.apps = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public void uploadApp(App app)
    {
        apps.add(app);
    }

    public void purchaseApp(User user, App app)
    {
        if (user.getAge() < app.getMinimumAge())
        {
            throw new DownloadNotAllowedException(
                    "User is too young to download this app."
            );
        }

        Purchase purchase = new Purchase(user, app);
        purchases.add(purchase);
    }

    public double getTotalRevenue()
    {
        double revenue = 0;

        for (Purchase purchase : purchases)
        {
            revenue += purchase.getApp().getPrice();
        }

        return revenue * 0.30;
    }

    public double getRevenue(App app)
    {
        double revenue = 0;

        for (Purchase purchase : purchases)
        {
            if (purchase.getApp() == app)
            {
                revenue += purchase.getApp().getPrice();
            }
        }

        return revenue * 0.30;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public List<App> getApps()
    {
        return apps;
    }

    public List<Purchase> getPurchases()
    {
        return purchases;
    }
}