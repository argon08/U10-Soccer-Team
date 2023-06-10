package soccerteam;

/**
 * This main class shows that the user add players and create a team.
 */
public class Driver {
  /**
   * Driver class. Creates team objects.
   *
   * @param args not used
   */
  public static void main(String[] args) {

    TeamModel m = new TeamModelImpl();
    TeamView v = new TeamViewImpl("U10 Soccer Team");
    TeamController c = new TeamControllerImpl(m, v);
  }
}
