package soccerteam;

/**
 * View interface for adding players and creating a soccer team.
 */
public interface TeamView {

  /**
   * Sets the controller for the view.
   *
   * @param c the controller for the view
   */
  void setController(TeamController c);

  /**
   * Displays an error message indicating that the age of a player is over 10 years old.
   */
  void popInvalidAge();

  /**
   * Displays an error message indicating that the birthdate is invalid.
   */
  void popInvalidBirthdate();

  /**
   * Displays an error message indicating that the player has been already added.
   */
  void popDuplicate();

  /**
   * Displays an error message indicating that all the fields must be filled.
   */
  void popEmptyField();

  /**
   * Displays an error message indicating that the team must be created with at least 10 players.
   */
  void popInvalidNumber();

  /**
   * Displays an information message indicating that the team has been created successfully.
   */
  void popTeamMessage();

  /**
   * Displays an error message indicating that the player is not in the list.
   */
  void popRemoveError();

  /**
   * Displays a message indicating that the player has been added or removed successfully.
   * @param type the type of the message, 0 for adding, 1 for removing
   */
  void popSucMessage(int type);

  /**
   * Sets the player list for the specified team and starting lineup.
   * @param team the list of the team
   * @param start the list of the starting lineup
   */
  void setPlayerList(String team, String start);

  /**
   * Sets the wait list size.
   * @param size the number of players in the waiting list.
   */
  void setWaitListSize(String size);
}
