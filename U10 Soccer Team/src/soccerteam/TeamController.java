package soccerteam;

/**
 * Interface for a soccer team controller. This interface defines methods for handling user input
 * and updating the view with adding players.
 */
public interface TeamController {

  /**
   * Adds a player to the waiting list.
   * @param first the first name of the player
   * @param last the last name of the player
   * @param birth the birthdate of the player
   * @param pos the position of the player
   * @param skill the skill level of the player
   */
  void addPlayer(String first, String last, String birth, Position pos, int skill);

  /**
   * Removes a player from the waiting list.
   * @param first the first name of the player
   * @param last the last name of the player
   * @param birth the birthdate of the player
   */
  void removePlayer(String first, String last, String birth);

  /**
   * Create the team with 20 players.
   */
  void createTeam();
}
