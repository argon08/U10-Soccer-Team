package soccerteam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class is used to sort list by the position of players.
 */
public class SortByPosition implements Comparator<Player> {

  /**
   * Compare two objects of Player class.
   *
   * @param a the first object to be compared.
   * @param b the second object to be compared.
   * @return the compare result
   */
  public int compare(Player a, Player b) {
    List<Position> posOrder = Arrays.asList(Position.GOALIE, Position.DEFENDER, Position.MIDFIELDER,
        Position.FORWARD);
    int firstPosition = posOrder.indexOf(a.getDecidedPosition());
    int secondPosition = posOrder.indexOf(b.getDecidedPosition());
    if (firstPosition != secondPosition) {
      return firstPosition - secondPosition;
    } else {
      return a.getLastName().compareTo(b.getLastName());
    }
  }
}
