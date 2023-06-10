package soccerteam;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This represents a player class. It's used to record information of a player.
 */
public class Player {

  private final String firstName;
  private final String lastName;
  private final LocalDate birthDate;
  private final Position preferredPosition;
  private Position decidedPosition;
  private final int skillLevel;
  private int jerseyNumber;

  /**
   * Constructor of the player class.
   *
   * @param firstName         the first name of the player
   * @param lastName          the last name of the player
   * @param birthDate         the birthday of the player
   * @param preferredPosition the player's preferred position
   * @param skillLevel        the player's skill level
   */
  public Player(String firstName, String lastName, LocalDate birthDate, Position preferredPosition,
      int skillLevel) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.preferredPosition = preferredPosition;
    this.skillLevel = skillLevel;
    this.jerseyNumber = -1;
  }

  /**
   * Return the skill level of the player.
   *
   * @return the skill level of the player
   */
  public int getSkillLevel() {
    return this.skillLevel;
  }

  /**
   * Assign jersey number to the player.
   *
   * @param number the jersey number assigned to the player
   */
  public void assignJerseyNumber(int number) {
    this.jerseyNumber = number;
  }

  /**
   * Assign the decided position to the player.
   *
   * @param pos the decided position assigned to the player
   */
  public void assignDecidedPosition(Position pos) {
    this.decidedPosition = pos;
  }

  /**
   * Return the first name of the player.
   *
   * @return the first name of the player
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Return the last name of the player.
   *
   * @return the last name of the player
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Return the birthdate of the player.
   *
   * @return the birthdate of the player
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  /**
   * Return the preferred position of the player.
   *
   * @return the preferred position of the player
   */
  public Position getPreferredPosition() {
    return preferredPosition;
  }

  /**
   * Return the jersey number of the player.
   *
   * @return the jersey number of the player
   */
  public int getJerseyNumber() {
    return jerseyNumber;
  }

  /**
   * Return the decided position of the player.
   *
   * @return the decided position of the player
   */
  public Position getDecidedPosition() {
    return decidedPosition;
  }

  public String toString() {
    return firstName + " " + lastName;
  }

  @Override public int hashCode() {
    return Objects.hash(firstName, lastName, birthDate);
  }

  @Override public boolean equals(Object player) {
    if (this == player) {
      return true;
    }
    if (!(player instanceof Player)) {
      return false;
    }
    Player other = (Player) player;
    return (this.firstName.equals(other.getFirstName())) && (this.lastName.equals(
        other.getLastName())) && (this.birthDate.equals(other.getBirthDate()));
  }

}
