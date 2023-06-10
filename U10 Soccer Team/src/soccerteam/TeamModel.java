package soccerteam;

import java.time.format.DateTimeParseException;

/**
 * This interface represents the operations offered by the soccer team model. One object of the
 * model represents one soccer team.
 */
public interface TeamModel {

  /**
   * Create a team soccer team from the wait list that must have a minimum of 10 players and a
   * maximum of 20.
   *
   * @param randomJersey whether generate random jersey number repeatedly
   * @throws IllegalStateException if there are less than 10 players
   */
  void createTeam(boolean randomJersey) throws IllegalStateException;

  /**
   * Add a player to the wait list.
   *
   * @param firstName the first name of the player
   * @param lastName  the last name of the player
   * @param birthDate the birthday of the player
   * @param position  the preferred position of the player
   * @param skill     the skill level of the player
   * @throws IllegalArgumentException if the player is under 10 years old
   * @throws DateTimeParseException   if the birthdate is not in the yyyy/MM/dd form
   * @throws IllegalStateException    if the player has already been added
   */
  void addPlayer(String firstName, String lastName, String birthDate, Position position, int skill)
      throws IllegalArgumentException, DateTimeParseException, IllegalStateException;

  /**
   * Remove a player from the wait list.
   *
   * @param firstName the first name of the player
   * @param lastName  the last name of the player
   * @param birthDate the birthday of the player
   * @throws IllegalArgumentException if the player hasn't been added
   */
  void removePlayer(String firstName, String lastName, String birthDate)
      throws IllegalArgumentException;

  /**
   * Return the String with a list of all the players in the team in alphabetical order (last name).
   *
   * @return the String with a list of all the players
   */
  String getTeam();

  /**
   * Return the String with a list of the starting lineup. The list is sorted by position (goalie,
   * defender, midfielder, forward). Players with the same position is ordered alphabetically (last
   * name).
   *
   * @return the String with a list of the starting lineup
   */
  String getStartingLineUp();

  /**
   * Return the size of the soccer team.
   *
   * @return the size of the soccer team.
   */
  int getSize();

  String getWaitList();

  int getWaitListSize();
}
