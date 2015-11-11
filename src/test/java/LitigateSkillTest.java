import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexandernohe on 11/10/15.
 */
public class LitigateSkillTest {
    LitigateSkill litigation = new LitigateSkill("Litigation", 25, 0, 1);
    Worker myEmployee;
    Worker enemyEmployee;

    @Before
    public void setUp() throws Exception {
        myEmployee = new Worker("Monster", 256, Worker.TeamType.LEGAL);
        enemyEmployee = new Worker("GIANT", 25, Worker.TeamType.FINANCIAL);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAction() throws Exception {
        litigation.Action(myEmployee, enemyEmployee);
        assertEquals(23, enemyEmployee.getCurrentHP());
        assertEquals(24, litigation.getCurrentNRG());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Litigation", litigation.getName());
    }

    @Test
    public void testGetCurrentNRG() throws Exception {
        assertEquals(25, litigation.getCurrentNRG());
    }

    @Test
    public void testGetMaxNRG() throws Exception {
        litigation.Action(myEmployee, enemyEmployee);
        assertEquals(25, litigation.getMaxNRG());
    }

    @Test
    public void testGetCooldown() throws Exception {
        assertEquals(0, litigation.getCooldown());
    }

    @Test
    public void testAdjustNRG() throws Exception {
        litigation.adjustNRG();
        assertEquals(24, litigation.getCurrentNRG());
        litigation.adjustNRG(-22);
        assertEquals(2, litigation.getCurrentNRG());
        litigation.adjustNRG(60);
        assertEquals(25, litigation.getCurrentNRG());
    }
}