package soccerteam;

import java.util.Comparator;

/**
 * This class is used to sort list by the last name of players.
 */
public class SortByLastName implements Comparator<Player> {

  public int compare(Player a, Player b) {
    return a.getLastName().compareTo(b.getLastName());
  }

}
