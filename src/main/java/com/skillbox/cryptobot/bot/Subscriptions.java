package com.skillbox.cryptobot.bot;

import java.util.ArrayList;
import java.util.List;

public class Subscriptions {
    private List<String> subs = new ArrayList<>();

    public Subscriptions(){
    }

    public List<String> getSubs(){
        return subs;
    }

    public void addSub(String price){
        subs.add(price);
    }


}
