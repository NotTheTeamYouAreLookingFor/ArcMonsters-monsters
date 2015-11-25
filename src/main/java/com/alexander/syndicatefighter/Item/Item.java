package com.alexander.syndicatefighter.Item;

/**
 * Created by mohi7253 on 11/18/2015.
 */
public abstract class Item {
    public String itemName;

    abstract public void Action();

    public String getName() throws Exception {
        return this.itemName;
    }
}
