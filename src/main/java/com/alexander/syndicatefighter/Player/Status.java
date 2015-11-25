package com.alexander.syndicatefighter.Player;

/**
 * Created by yuan8014 on 11/20/2015.
 */

public enum Status
{
    New,        //just registered, not activated or having my identity confirmed (do we want to limit 1)to Esri employees only? 2)one account per person?)
    Normal,     //can start a battle with me
    InBattle,       //in battle right now
    DoNotDisturb,        //cannot start a battle with me
    Dead        //well, do not need explanation for this one, right?
}
