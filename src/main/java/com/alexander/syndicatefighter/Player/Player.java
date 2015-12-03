package com.alexander.syndicatefighter.Player;

import com.alexander.syndicatefighter.Backpack;
import com.alexander.syndicatefighter.Worker.Worker;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Player {
    private long id;
    private String email;
    private String name;
    private Gender gender;
    private long cash;
    private Status status;
    private Backpack backpack;
    private List<Worker> workerList;
    private String avatar;   //TODO: Currently defined as string. Is it ok? Any better option?


    //region Constructors
    public Player()
    {
        this(123, "player@test.com", "Newplayer Changeyourname", "DefaultAvatar");      //TODO: 1)auto increment for ID in database, 2)default avatar and email
    }

    public Player(long id,String email, String name, String avatar)
    {
        this(id, email, name, Gender.Neither, 0L, Status.New, new Backpack(), new ArrayList<Worker>(), avatar);
    }

    public Player(long id, String email, String name, Gender gender, long cash, Status status, Backpack backpack, List<Worker> workerList, String avatar)
    {
        this.id = id;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.cash = cash;
        this.status = status;
        this.backpack = backpack;
        this.workerList = workerList;
        this.avatar = avatar;
    }
    //endregion

    //region Public Methods for Properties
    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Gender getGender()
    {
        return this.gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public long getCash()
    {
        return this.cash;
    }

    public void setCash(long cash)
    {
        this.cash = cash;
    }

    public void increaseCash(long add)
    {
        this.cash += add;
    }

    public void decreaseCash(long minus)
    {
        this.cash -= minus;
        //If now cash is below 0, then set it to 0
        this.cash = this.cash < 0 ? 0 : this.cash;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public String getAvatar()
    {
        return this.avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public Backpack getBackpack()
    {
        return this.backpack;
    }

    public void setBackpack(Backpack backpack)
    {
        this.backpack = backpack;
    }

    public List<Worker> getWorkerList()
    {
        return this.workerList;
    }

    public void setWorkerList(List<Worker> workerList)
    {
        this.workerList = workerList;
    }

    public void addWorker(Worker worker)
    {
        this.workerList.add(worker);
    }

    public Worker getWorkerAtIndex(int i)
    {
        return workerList.get(i);
    }

    //todo: expose more methods for workerlist

    //endregion



    public String toJSON()
    {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(this);
        return jsonStr;
    }

}
