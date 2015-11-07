import static org.junit.Assert.*;

/**
 * Created by alex7370 on 11/5/2015.
 */
public class EmployeesTest {
    public Employees employee;

    @org.junit.Before
    public void setUp() throws Exception {
        employee = new Employees();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGetLevel() throws Exception {
        assertEquals(1, employee.getLevel());
    }

    @org.junit.Test
    public void testGetCurrentXP() throws Exception {
        assertEquals(25, employee.getCurrentXP());
    }

    @org.junit.Test
    public void testAdjustXP() throws Exception {
        employee.adjustXP(500);
        assertEquals(525, employee.getCurrentXP());
        assertEquals(2, employee.getLevel());
        assertEquals(29, employee.getMaxHP());
        assertEquals(29, employee.getCurrentHP());
    }

    @org.junit.Test
    public void testGetType() throws Exception {
        assertEquals(Employees.TeamType.SDK, employee.getType());
    }

    @org.junit.Test
    public void testGetName() throws Exception {
        assertEquals("David", employee.getName());
    }

    @org.junit.Test
    public void testGetCurrentHP() throws Exception {
        assertEquals(25, employee.getCurrentHP());
    }

    @org.junit.Test
    public void testGetMaxHP() throws Exception {
        assertEquals(25, employee.getMaxHP());
    }

    @org.junit.Test
    public void testConstructors() throws Exception {
        Employees emp1 = new Employees("Kwasi");
        assertEquals("Kwasi", emp1.getName());
        assertEquals(Employees.TeamType.SDK,emp1.getType());
        assertEquals(1, emp1.getLevel());
        assertEquals(25, emp1.getCurrentXP());
        assertEquals(25, emp1.getMaxHP());
        assertEquals(25, emp1.getCurrentHP());

        Employees emp2 = new Employees("Kwasi",1098903);
        assertEquals("Kwasi", emp2.getName());
        assertEquals(1098903, emp2.getCurrentXP()); //Checked that this should give us level 100 but enforced a level cap.
        assertEquals(99, emp2.getLevel());
        assertEquals(Employees.TeamType.SDK,emp2.getType());
        assertEquals(9923, emp2.getMaxHP());  //Checked this manually
        assertEquals(9923, emp2.getCurrentHP()); //Checked this manually

    }

    @org.junit.Test
    public void testGetAliveStatus() throws Exception
    {
        assertEquals(true, employee.getAliveStatus());
    }

    @org.junit.Test
    public void testAdjustHPNegative() throws Exception
    {
        employee.adjustHP(-55);
        assertEquals(false, employee.getAliveStatus());
        assertEquals(0, employee.getCurrentHP());
    }

    @org.junit.Test
    public void testAdjustHPPositive() throws Exception
    {
        employee.adjustHP(-10);
        employee.adjustHP(55);
        assertEquals(true, employee.getAliveStatus());
        assertEquals(25, employee.getCurrentHP());
    }
}
