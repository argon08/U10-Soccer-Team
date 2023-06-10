package soccerteam;

import java.util.Comparator;

/**
 * This class is used to sort list by the skill level of players.
 */
public class SortBySkill implements Comparator<Player> {

  public int compare(Player a, Player b) {
    return b.getSkillLevel() - a.getSkillLevel();
  }
}
