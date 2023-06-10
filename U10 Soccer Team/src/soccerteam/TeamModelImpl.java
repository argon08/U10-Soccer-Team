package soccerteam;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * This represents a soccer team class.
 */
public class TeamModelImpl implements TeamModel {

  private int size;
  private int waitListSize;
  private final List<Player> waitlist;
  private final List<Player> team;
  private final List<Player> startingLineUp;
  private final HashMap<Position, Integer> teamPos;

  /**
   * Constructor of the team class.
   */
  public TeamModelImpl() {
    size = 0;
    waitListSize = 0;
    waitlist = new ArrayList<>();
    startingLineUp = new ArrayList<>();
    team = new ArrayList<>();
    teamPos = new HashMap<>();
    teamPos.put(Position.GOALIE, 1);
    teamPos.put(Position.DEFENDER, 2);
    teamPos.put(Position.MIDFIELDER, 3);
    teamPos.put(Position.FORWARD, 1);
  }

  @Override public void createTeam(boolean randomJersey) throws IllegalStateException {
    if (waitlist.size() < 10) {
      throw new IllegalStateException("The team cannot be created with less than 10 players.");
    }
    team.clear();
    Collections.sort(waitlist, new SortBySkill());
    int waitlistSize = waitlist.size();
    if (waitlist.size() > 20) {
      waitlistSize = 20;
    }
    for (int i = 0; i < waitlistSize; i++) {
      team.add(waitlist.get(i));
    }
    this.size = waitlistSize;
    assignJerseyNumber(randomJersey);
    selectStartingLineUp();
  }

  @Override public void addPlayer(String firstName, String lastName, String birthDate,
      Position position, int skill)
      throws IllegalArgumentException, DateTimeParseException, IllegalStateException {
    DateTimeFormatter birthFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate birth = LocalDate.parse(birthDate, birthFormat);
    Period age = Period.between(birth, LocalDate.now());
    if (age.getYears() >= 10) {
      throw new IllegalArgumentException("The player should be under 10 years old.");
    }
    Player newPlayer = new Player(firstName, lastName, birth, position, skill);
    for (Player player : waitlist) {
      if (player.equals(newPlayer)) {
        throw new IllegalStateException("The player has been already added.");
      }
    }
    waitlist.add(newPlayer);
    waitListSize += 1;
  }

  @Override public void removePlayer(String firstName, String lastName, String birthDate)
      throws IllegalArgumentException, DateTimeParseException {
    DateTimeFormatter birthFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate birthday = LocalDate.parse(birthDate, birthFormat);
    int inList = 0;
    for (Player player : waitlist) {
      if (player.getLastName().equals(lastName) && player.getFirstName().equals(firstName)
          && player.getBirthDate().equals(birthday)) {
        waitlist.remove(player);
        inList = 1;
        waitListSize -= 1;
        break;
      }
    }
    if (inList == 0) {
      throw new IllegalArgumentException("You haven't added this player");
    }
  }

  private void assignJerseyNumber(boolean random) {
    List<Integer> remainingJerseyNumber = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      remainingJerseyNumber.add(i);
    }
    Random rand = new Random();
    if (!random) {
      rand.setSeed(12345L);
    }
    for (int j = 0; j < this.size; j++) {
      int number = remainingJerseyNumber.get(rand.nextInt(remainingJerseyNumber.size()));
      team.get(j).assignJerseyNumber(number);
      for (int item = 0; item < remainingJerseyNumber.size(); item++) {
        if (remainingJerseyNumber.get(item) == number) {
          remainingJerseyNumber.remove(item);
          item--;
        }
      }
    }
  }

  private void selectStartingLineUp() {
    Collections.sort(team, new SortBySkill());
    startingLineUp.clear();
    for (int i = 0; i < 7; i++) {
      Position preferPos = team.get(i).getPreferredPosition();
      int posNum = teamPos.get(preferPos);
      if (posNum > 0) {
        team.get(i).assignDecidedPosition(preferPos);
        teamPos.put(preferPos, posNum - 1);
      } else {
        for (Position key : teamPos.keySet()) {
          int remainNum = teamPos.get(key);
          if (remainNum > 0) {
            team.get(i).assignDecidedPosition(key);
            teamPos.put(key, remainNum - 1);
            break;
          }
        }
      }
      startingLineUp.add(team.get(i));
    }
  }

  @Override public String getTeam() {
    StringBuilder teamList = new StringBuilder();
    teamList.append("Last Name, First Name, Jersey Number\n-----------------\n");
    Collections.sort(team, new SortByLastName());
    for (Player player : team) {
      teamList.append(player.getLastName()).append(", ").append(player.getFirstName()).append(", ")
          .append(Integer.toString(player.getJerseyNumber())).append("\n");
    }
    return teamList.toString();
  }

  @Override public String getStartingLineUp() {
    StringBuilder startingLineUpString = new StringBuilder();
    startingLineUpString.append(
        "Position: Last Name, First Name, Jersey Number\n-----------------\n");
    Collections.sort(startingLineUp, new SortByPosition());
    for (Player player : startingLineUp) {
      startingLineUpString.append(player.getDecidedPosition()).append(": ")
          .append(player.getLastName()).append(", ").append(player.getFirstName()).append(", ")
          .append(Integer.toString(player.getJerseyNumber())).append("\n");
    }
    return startingLineUpString.toString();
  }

  @Override public int getSize() {
    return this.size;
  }

  @Override public String getWaitList() {
    StringBuilder waitListMember = new StringBuilder();
    Collections.sort(waitlist, new SortByLastName());
    for (Player player : waitlist) {
      waitListMember.append(player.getLastName()).append(", ").append(player.getFirstName())
          .append(", ").append(player.getBirthDate()).append("\n");
    }
    return waitListMember.toString();
  }

  @Override public int getWaitListSize() {
    return waitListSize;
  }

}
