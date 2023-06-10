import static org.junit.Assert.assertEquals;

import java.time.format.DateTimeParseException;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Position;
import soccerteam.TeamModel;
import soccerteam.TeamModelImpl;

/**
 * Unit tests for soccer team class.
 */
public class TeamModelImplTest {

  private TeamModel model1;
  private TeamModel model2;

  @Before public void setUp() {
    model1 = new TeamModelImpl();
    model2 = new TeamModelImpl();
  }

  @Test public void createTeam() {
    addPlayerHelper();
    model1.createTeam(false);
    assertEquals(10, model1.getSize());
    addPlayerHelper2();
    model1.createTeam(false);
    assertEquals(20, model1.getSize());
  }

  @Test
      (expected = IllegalStateException.class) public void testInvalidCreateTeam() {
    model2.addPlayer("James", "Barnes", "2014/03/10", Position.FORWARD, 5);
    model2.createTeam(false);
  }

  @Test
      (expected = IllegalStateException.class) public void testInvalidAddDuplicatePlayer() {
    model1.addPlayer("James", "Barnes", "2014/03/10", Position.FORWARD, 5);
    model1.addPlayer("James", "Barnes", "2014/03/10", Position.MIDFIELDER, 4);
  }

  @Test
      (expected = DateTimeParseException.class) public void testInvalidBirthDateFormat() {
    model1.addPlayer("James", "Barnes", "2014/3/10", Position.FORWARD, 5);
  }

  @Test
      (expected = IllegalArgumentException.class) public void testAddInvalidBirthDate() {
    model1.addPlayer("James", "Barnes", "1917/03/10", Position.FORWARD, 5);
  }

  private void addPlayerHelper() {
    model1.addPlayer("James", "Barnes", "2014/03/10", Position.FORWARD, 5);
    model1.addPlayer("Steve", "Rogers", "2014/07/04", Position.MIDFIELDER, 5);
    model1.addPlayer("Emma", "Johnson", "2015/10/02", Position.MIDFIELDER, 3);
    model1.addPlayer("David", "Garcia", "2013/05/21", Position.GOALIE, 2);
    model1.addPlayer("Hannah", "Lee", "2017/11/02", Position.DEFENDER, 1);
    model1.addPlayer("Tyler", "Johnson", "2015/03/23", Position.DEFENDER, 2);
    model1.addPlayer("Samantha", "Green", "2016/09/29", Position.DEFENDER, 3);
    model1.addPlayer("Kevin", "Chen", "2015/08/03", Position.MIDFIELDER, 2);
    model1.addPlayer("Olivia", "Davis", "2013/10/03", Position.MIDFIELDER, 5);
    model1.addPlayer("Jason", "Todd", "2013/10/06", Position.GOALIE, 4);
  }

  private void addPlayerHelper2() {
    model1.addPlayer("Luna", "Lovegood", "2014/03/29", Position.FORWARD, 3);
    model1.addPlayer("Remus", "Lupin", "2014/08/04", Position.MIDFIELDER, 5);
    model1.addPlayer("Cho", "Chang", "2013/10/02", Position.MIDFIELDER, 3);
    model1.addPlayer("Gilderoy", "Garcia", "2013/06/21", Position.GOALIE, 2);
    model1.addPlayer("Peter", "Lee", "2017/03/02", Position.DEFENDER, 1);
    model1.addPlayer("Tom", "Riddle", "2015/07/23", Position.DEFENDER, 2);
    model1.addPlayer("Fleur", "Green", "2016/04/29", Position.DEFENDER, 3);
    model1.addPlayer("Alex", "Chen", "2015/05/03", Position.MIDFIELDER, 2);
    model1.addPlayer("Dick", "Grayson", "2013/07/10", Position.MIDFIELDER, 5);
    model1.addPlayer("Damian", "Wayne", "2014/04/06", Position.FORWARD, 4);
    model1.addPlayer("Barry", "Allen", "2013/08/08", Position.FORWARD, 5);
  }

  @Test public void testAddRemovePlayer() {
    addPlayerHelper();
    model1.addPlayer("Luna", "Lovegood", "2014/03/29", Position.FORWARD, 3);
    model1.removePlayer("David", "Garcia", "2013/05/21");
    model1.createTeam(false);
    assertEquals(10, model1.getSize());
  }

  @Test
      (expected = DateTimeParseException.class) public void testRemoveInvalidBirthDate() {
    model1.removePlayer("James", "Barnes", "1917/3/10");
  }

  @Test
      (expected = IllegalArgumentException.class) public void testRemoveInvalidPlayer() {
    model1.removePlayer("Barry", "Allen", "2013/08/08");
  }

  @Test public void testGetTeam() {
    addPlayerHelper();
    model1.createTeam(false);
    assertEquals("Last Name, First Name, Jersey Number\n" + "-----------------\n"
        + "Barnes, James, 12\n" + "Chen, Kevin, 4\n" + "Davis, Olivia, 18\n" + "Garcia, David, 14\n"
            + "Green, Samantha, 7\n" + "Johnson, Emma, 17\n" + "Johnson, Tyler, 15\n"
            + "Lee, Hannah, 20\n" + "Rogers, Steve, 2\n" + "Todd, Jason, 1\n", model1.getTeam());
  }

  @Test public void testGetStartingLineUp() {
    addPlayerHelper();
    model1.createTeam(false);
    assertEquals("Position: Last Name, First Name, Jersey Number\n" + "-----------------\n"
            + "GOALIE: Todd, Jason, 1\n" + "DEFENDER: Garcia, David, 14\n"
            + "DEFENDER: Green, Samantha, 7\n" + "MIDFIELDER: Davis, Olivia, 18\n"
            + "MIDFIELDER: Johnson, Emma, 17\n" + "MIDFIELDER: Rogers, Steve, 2\n"
            + "FORWARD: Barnes, James, 12\n",
        model1.getStartingLineUp());
  }
}