import static org.junit.Assert.*;

/**
 * Created by alex7370 on 11/5/2015.
 */
public class WorkerTest {
    public Worker worker;
    public Skills litigation;

    @org.junit.Before
    public void setUp() throws Exception {
        worker = new Worker();
        litigation = new LitigateSkill("Litigation", 25, 0, 1);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetLevel() throws Exception {
        assertEquals(1, worker.getLevel());
    }

    @org.junit.Test
    public void testGetCurrentXP() throws Exception {
        assertEquals(25, worker.getCurrentXP());
    }

    @org.junit.Test
    public void testAdjustXP() throws Exception {
        worker.adjustXP(500);
        assertEquals(525, worker.getCurrentXP());
        assertEquals(2, worker.getLevel());
        assertEquals(29, worker.getMaxHP());
        assertEquals(29, worker.getCurrentHP());
    }

    @org.junit.Test
    public void testGetType() throws Exception {
        assertEquals(Worker.TeamType.DEV, worker.getType());
    }

    @org.junit.Test
    public void testGetName() throws Exception {
        assertEquals("David", worker.getName());
    }

    @org.junit.Test
    public void testGetCurrentHP() throws Exception {
        assertEquals(25, worker.getCurrentHP());
    }

    @org.junit.Test
    public void testGetMaxHP() throws Exception {
        assertEquals(25, worker.getMaxHP());
    }

    @org.junit.Test
    public void testConstructors() throws Exception {
        Worker worker1 = new Worker("Kwasi");
        assertEquals("Kwasi", worker1.getName());
        assertEquals(Worker.TeamType.DEV,worker1.getType());
        assertEquals(1, worker1.getLevel());
        assertEquals(25, worker1.getCurrentXP());
        assertEquals(25, worker1.getMaxHP());
        assertEquals(25, worker1.getCurrentHP());

        Worker worker2 = new Worker("Kwasi",1098903);
        assertEquals("Kwasi", worker2.getName());
        assertEquals(1098903, worker2.getCurrentXP()); //Checked that this should give us level 100 but enforced a level cap.
        assertEquals(99, worker2.getLevel());
        assertEquals(Worker.TeamType.DEV,worker2.getType());
        assertEquals(9923, worker2.getMaxHP());  //Checked this manually
        assertEquals(9923, worker2.getCurrentHP()); //Checked this manually
    }

    @org.junit.Test
    public void testGetAliveStatus() throws Exception
    {
        assertEquals(true, worker.getAliveStatus());
    }

    @org.junit.Test
    public void testAdjustHPNegative() throws Exception
    {
        worker.adjustHP(-55);
        assertEquals(false, worker.getAliveStatus());
        assertEquals(0, worker.getCurrentHP());
    }

    @org.junit.Test
    public void testAdjustHPPositive() throws Exception
    {
        worker.adjustHP(-10);
        worker.adjustHP(55);
        assertEquals(true, worker.getAliveStatus());
        assertEquals(25, worker.getCurrentHP());
    }

    @org.junit.Test
    public void testAddSkill() throws Exception
    {
        worker.addSkill(litigation);
        assertEquals(litigation.getName(), (worker.getSkill(0)).getName());
    }

    @org.junit.Test
    public void testremoveSkill() throws Exception
    {
        worker.addSkill(litigation);
        worker.removeSkill(0);
        assertEquals(0, worker.getSkillCount());
    }

    @org.junit.Test
    public void testGetSkill() throws Exception
    {
        worker.addSkill(litigation);
        assertEquals(litigation.getName(), (worker.getSkill(0)).getName());
    }

    @org.junit.Test
    public void testGetSkillCount() throws Exception
    {
        worker.addSkill(litigation);
        assertEquals(1, worker.getSkillCount());
        worker.backupToFirebase();
    }

    @org.junit.Test
    public void testBackupToFirebase() throws Exception
    {
        worker.backupToFirebase();
    }
}
