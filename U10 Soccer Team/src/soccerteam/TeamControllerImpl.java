package soccerteam;

import java.time.format.DateTimeParseException;

/**
 * Concrete implementation of the TeamController interface that handles user input and updates the
 * view with information about a soccer team.
 */
public class TeamControllerImpl implements TeamController {

  private final TeamModel model;
  private final TeamView view;

  /**
   * Constructs a new TeamControllerImpl object.
   *
   * @param m the model file
   * @param v the view file
   */
  public TeamControllerImpl(TeamModel m, TeamView v) {
    this.model = m;
    this.view = v;
    view.setController(this);
  }

  @Override public void addPlayer(String first, String last, String birth, Position pos,
      int skill) {
    try {
      model.addPlayer(first, last, birth, pos, skill);
      view.popSucMessage(1);
      view.setWaitListSize(Integer.toString(model.getWaitListSize()));
    } catch (IllegalArgumentException e) {
      view.popInvalidAge();
    } catch (IllegalStateException e) {
      view.popDuplicate();
    } catch (DateTimeParseException e) {
      view.popInvalidBirthdate();
    }
  }

  @Override public void removePlayer(String first, String last, String birth) {
    try {
      model.removePlayer(first, last, birth);
      view.popSucMessage(2);
      view.setWaitListSize(Integer.toString(model.getWaitListSize()));
    } catch (DateTimeParseException e) {
      view.popInvalidBirthdate();
    } catch (IllegalArgumentException e) {
      view.popRemoveError();
    }
  }

  @Override public void createTeam() {
    try {
      model.createTeam(true);
      view.popTeamMessage();
      view.setPlayerList(model.getTeam(), model.getStartingLineUp());
    } catch (IllegalStateException e) {
      view.popInvalidNumber();
    }
  }
}
