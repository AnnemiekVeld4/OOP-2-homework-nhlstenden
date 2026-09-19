package com.nhlstenden.week3;

public class AppleAppStore extends AppStore
{

    public AppleAppStore(Currency currency)
    {
        super(currency);
    }

    @Override
    public void uploadApp(App app)
    {
        if (!app.containsNudity())
        {
            super.uploadApp(app);
        }
    }
}
