import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.Position;

/**
 * Unit tests for player class.
 */
public class PlayerTest {

  private Player player1;
  private Player player2;
  private LocalDate birthdate1;
  private LocalDate birthdate2;

  /**
   * Set up. Create two objects of type player.
   */
  @Before public void setUp() {
    DateTimeFormatter birthFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    birthdate1 = LocalDate.parse("2015/03/10", birthFormat);
    birthdate2 = LocalDate.parse("2015/07/04", birthFormat);
    player1 = new Player("James", "Barnes", birthdate1, Position.FORWARD, 5);
    player2 = new Player("Steve", "Rogers", birthdate2, Position.GOALIE, 4);
  }

  @Test public void testGetSkillLevel() {
    assertEquals(5, player1.getSkillLevel());
    assertEquals(4, player2.getSkillLevel());
  }

  @Test public void testAssignJerseyNumber() {
    player1.assignJerseyNumber(14);
    assertEquals(14, player1.getJerseyNumber());
    player2.assignJerseyNumber(10);
    assertEquals(10, player2.getJerseyNumber());
  }

  @Test public void testAssignDecidedPosition() {
    player1.assignDecidedPosition(Position.MIDFIELDER);
    assertEquals(Position.MIDFIELDER, player1.getDecidedPosition());
    player2.assignDecidedPosition(Position.GOALIE);
    assertEquals(Position.GOALIE, player2.getDecidedPosition());
  }

  @Test public void testGetFirstName() {
    assertEquals("James", player1.getFirstName());
    assertEquals("Steve", player2.getFirstName());
  }

  @Test public void testGetLastName() {
    assertEquals("Barnes", player1.getLastName());
    assertEquals("Rogers", player2.getLastName());
  }

  @Test public void testGetBirthDate() {
    assertEquals(birthdate1, player1.getBirthDate());
    assertEquals(birthdate2, player2.getBirthDate());
  }

  @Test public void testGetPreferredPosition() {
    assertEquals(Position.FORWARD, player1.getPreferredPosition());
    assertEquals(Position.GOALIE, player2.getPreferredPosition());
  }

  @Test public void testToString() {
    assertEquals("James Barnes", player1.toString());
    assertEquals("Steve Rogers", player2.toString());
  }

  @Test public void testEquals() {
    assertFalse(player1.equals(player2));
  }
}