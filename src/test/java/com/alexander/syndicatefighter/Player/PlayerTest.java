package com.alexander.syndicatefighter.Player;

import com.alexander.syndicatefighter.Backpack;
import com.alexander.syndicatefighter.Item.Item;
import com.alexander.syndicatefighter.Worker.TeamType;
import com.alexander.syndicatefighter.Worker.Worker;

import junit.framework.TestCase;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

/**
 * Created by yuan8014 on 12/3/2015.
 */
public class PlayerTest extends TestCase {
    Player player1 = new Player();

    public void testGetId() throws Exception {

        assertEquals(123, player1.getId());
    }

    public void testSetId() throws Exception {
        player1.setId(345);
        assertEquals(345, player1.getId());
    }

    public void testGetEmail() throws Exception {
        assertEquals("player@test.com", player1.getEmail());
    }

    public void testSetEmail() throws Exception {
        player1.setEmail("SyndiFighterWin@esri.com");
        assertEquals("SyndiFighterWin@esri.com", player1.getEmail());
    }

    public void testGetName() throws Exception {
        assertEquals("Newplayer Changeyourname", player1.getName());
    }

    public void testSetName() throws Exception {
        player1.setName("Boom Shakalaka");
        assertEquals("Boom Shakalaka", player1.getName());
    }

    public void testGetGender() throws Exception {
        assertEquals(Gender.Neither, player1.getGender());
    }

    public void testSetGender() throws Exception {
        player1.setGender(Gender.GenderFluid);
        assertEquals(Gender.GenderFluid, player1.getGender());
    }

    public void testGetCash() throws Exception {
        assertEquals(0, player1.getCash());
    }

    public void testSetCash() throws Exception {
        player1.setCash(-100);
        assertEquals(0, player1.getCash());
    }

    public void testIncreaseCash() throws Exception {
        player1.increaseCash(555555555);
        assertEquals(555555555, player1.getCash());
    }

    public void testDecreaseCash() throws Exception {
        player1.decreaseCash(666666666);
        assertEquals(0, player1.getCash());
    }

    public void testGetStatus() throws Exception {
        assertEquals(Status.New, player1.getStatus());
    }

    public void testSetStatus() throws Exception {
        player1.setStatus(Status.Normal);
        assertEquals(Status.Normal, player1.getStatus());
    }

    public void testGetAvatar() throws Exception {
        assertEquals("DefaultAvatar", player1.getAvatar());
    }

    public void testSetAvatar() throws Exception {

    }

    public void testGetBackpack() throws Exception {

    }

    public void testSetBackpack() throws Exception {
        Backpack newBP = new Backpack();
        Item newItem = new Item() {
            @Override
            public void Action() {
                System.out.println("I want Hotpot!! Lamb slice, beef ball, and needle mushroom!!");
            }
        };
        newBP.getItems().put(newItem, 123);
        player1.setBackpack(newBP);
        assertEquals(newBP, player1.getBackpack());
        newItem.Action();
        player1.getBackpack().useItem(newItem);
    }

    public void testGetWorkerList() throws Exception {

    }

    public void testSetWorkerList() throws Exception {
        //please change this into true when really testing, otherwise....Let's have some fun!!
        boolean reallyTesting = false;

        if (reallyTesting) {
            ArrayList<Worker> workers = new ArrayList<Worker>();
            player1.setWorkerList(workers);
            assertEquals(workers, player1.getWorkerList());
        } else {
            Worker alex = new Worker("Alex", 50, TeamType.ANALYST);
            Worker mohini = new Worker("Monihi", 1000, TeamType.ANALYST);
            ArrayList<Worker> worklist = new ArrayList<Worker>();
            worklist.add(alex);
            worklist.add(mohini);
            player1.setWorkerList(worklist);
            assertEquals(50, player1.getWorkerList().get(player1.getWorkerList().indexOf(alex)).getCurrentXP());
            assertEquals(TeamType.ANALYST, player1.getWorkerList().get(player1.getWorkerList().indexOf(mohini)).getType());
            System.out.println("===============================");
            System.out.println("Monihi and Alex are in battle...");
            System.out.println("Monihi throw a Super Bomb at Alex");
            alex.adjustHP(-1000);
            System.out.println("Alex lost 1000 HP");
            assertEquals(false, alex.getAliveStatus());
            System.out.println(alex.getAliveStatus() ? "This is never happening" : "Mohini wins!!!! YAY!!!!!");
        }
    }

    public void testToJSON() throws Exception {
        System.out.println("Json string of defaul player is: \n" + player1.toJSON());

        /* method to check if it is valid JSON string, learned from stackoverflow, in case we will use toJSON()

        try {
            new JSONObject(player1.toJSON());
        } catch (JSONException ex) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                new JSONArray(player1.toJSON());
            } catch (JSONException ex1) {
            }
        }*/
    }

    public void testActivate() throws Exception {
        player1.activate();
        assertEquals(Status.Normal, player1.getStatus());
    }

    public void testDeactivate() throws Exception {
        player1.deactivate();
        assertEquals(Status.InActive, player1.getStatus());
    }

    public void testCanBattle() throws Exception {
        assertEquals(false, player1.canBattle());
        player1.deactivate();
        assertEquals(false, player1.canBattle());
        player1.setStatus(Status.DoNotDisturb);
        assertEquals(false, player1.canBattle());
        player1.setStatus(Status.InBattle);
        assertEquals(false, player1.canBattle());
        player1.activate();
        assertEquals(true, player1.canBattle());
    }
}