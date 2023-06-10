package soccerteam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Concrete implementation of the TeamView interface that displays adding players and creating a
 * team in a user interface.
 */
public class TeamViewImpl extends JFrame implements TeamView, ActionListener {

  public JLabel waitMember;
  public JTextField firstInput;
  public JTextField lastInput;
  public JTextField birthInput;
  public JComboBox<Position> posInput;
  public JComboBox<Integer> skillLevel;
  public JButton addPlayer;
  public JButton removePlayer;
  public JButton team;
  public JTextArea teamMembers;
  public JTextArea startingLineMember;
  public TeamController teamController;

  /**
   * Constructs a new TeamViewImpl object.
   *
   * @param title the title of the windows
   */
  public TeamViewImpl(String title) {
    super(title);
    setSize(900, 600);
    setLocation(200, 200);
    Color background = Color.decode("#CEDADA");
    setBackground(background);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(null);

    // set the title panel
    JPanel top = new JPanel();
    top.setBounds(0, 0, 900, 50);
    top.setBackground(background);

    // set the info panel
    JPanel info = new JPanel();
    info.setLayout(new GridBagLayout());
    info.setBounds(0, 50, 550, 100);
    info.setBackground(background);
    JPanel labelsPanel = new JPanel();
    labelsPanel.setBackground(background);
    labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.X_AXIS));
    GridBagConstraints infoGbc = new GridBagConstraints();
    infoGbc.gridx = 0;
    infoGbc.gridy = 0;
    infoGbc.weighty = 1;
    infoGbc.fill = GridBagConstraints.VERTICAL;
    info.add(labelsPanel, infoGbc);

    // set the input panel
    JPanel left = new JPanel();
    left.setBounds(0, 150, 550, 250);
    left.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 10, 5);
    gbc.anchor = GridBagConstraints.EAST;
    left.setBackground(background);

    // set submit panel
    JPanel submit = new JPanel();
    submit.setBounds(0, 400, 550, 100);
    submit.setLayout(new GridBagLayout());
    GridBagConstraints subGbc = new GridBagConstraints();
    subGbc.insets = new Insets(0, 5, 10, 5);
    subGbc.anchor = GridBagConstraints.NORTH;
    submit.setBackground(background);
    JPanel back = new JPanel();
    back.setBounds(0, 500, 550, 200);
    back.setBackground(background);

    // set the display panel
    JPanel right = new JPanel();
    right.setBounds(550, 50, 350, 550);
    right.setBackground(background);
    right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
    right.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 20));

    // add title
    JLabel headTitle = new JLabel("U10 Soccer Team");
    headTitle.setPreferredSize(new Dimension(300, 40));
    headTitle.setHorizontalAlignment(JLabel.CENTER);
    headTitle.setVerticalAlignment(JLabel.CENTER);
    headTitle.setFont(new Font("Helvetica", Font.BOLD, 30));
    Color titleColor = Color.decode("#445873");
    headTitle.setForeground(titleColor);
    headTitle.setBackground(background);
    headTitle.setOpaque(true);
    top.add(headTitle);

    // add notes
    JLabel wait = new JLabel("Players on the Waiting List: ");
    wait.setVerticalAlignment(SwingConstants.CENTER);
    wait.setFont(new Font("Helvetica", Font.BOLD, 25));
    wait.setForeground(titleColor);
    wait.setBackground(background);
    wait.setOpaque(true);
    labelsPanel.add(wait);

    waitMember = new JLabel("0");
    waitMember.setFont(new Font("Helvetica", Font.BOLD, 25));
    waitMember.setVerticalAlignment(SwingConstants.CENTER);
    waitMember.setForeground(titleColor);
    waitMember.setBackground(background);
    waitMember.setOpaque(true);
    labelsPanel.add(waitMember);

    // add first name
    JLabel firstName = new JLabel("First Name:");
    Font subtitle2 = new Font("Helvetica", Font.PLAIN, 16);
    firstName.setFont(subtitle2);
    gbc.gridx = 0;
    gbc.gridy = 0;
    left.add(firstName, gbc);
    firstInput = new JTextField();
    Dimension inputSize = new Dimension(250, 30);
    firstInput.setPreferredSize(inputSize);
    gbc.gridx = 1;
    gbc.gridy = 0;
    left.add(firstInput, gbc);

    // add last name
    JLabel lastName = new JLabel("Last Name:");
    lastName.setFont(subtitle2);
    gbc.gridx = 0;
    gbc.gridy = 1;
    left.add(lastName, gbc);
    lastInput = new JTextField(20);
    lastInput.setPreferredSize(inputSize);
    gbc.gridx = 1;
    gbc.gridy = 1;
    left.add(lastInput, gbc);

    // add birthdate
    JLabel birthdate = new JLabel("Birthdate (yyyy/mm/dd):");
    birthdate.setFont(subtitle2);
    gbc.gridx = 0;
    gbc.gridy = 2;
    left.add(birthdate, gbc);
    birthInput = new JTextField(20);
    birthInput.setToolTipText("e.g. 1917/03/10");
    birthInput.setPreferredSize(inputSize);
    gbc.gridx = 1;
    gbc.gridy = 2;
    left.add(birthInput, gbc);

    // add position
    JLabel position = new JLabel("Preferred Position:");
    position.setFont(subtitle2);
    gbc.gridx = 0;
    gbc.gridy = 3;
    left.add(position, gbc);
    Position[] posChoice = Position.values();
    posInput = new JComboBox<>(posChoice);
    posInput.setPreferredSize(inputSize);
    gbc.gridx = 1;
    gbc.gridy = 3;
    left.add(posInput, gbc);

    // add skill level
    JLabel skill = new JLabel("Skill Level");
    skill.setFont(subtitle2);
    gbc.gridx = 0;
    gbc.gridy = 4;
    left.add(skill, gbc);
    Integer[] levels = { 1, 2, 3, 4, 5 };
    skillLevel = new JComboBox<>(levels);
    skillLevel.setPreferredSize(inputSize);
    gbc.gridx = 1;
    gbc.gridy = 4;
    left.add(skillLevel, gbc);

    // add player button
    addPlayer = new JButton("Add Player");
    subGbc.gridx = 1;
    subGbc.gridy = 0;
    addPlayer.addActionListener(this);
    Font button = new Font("Helvetica", Font.BOLD, 15);
    addPlayer.setFont(button);
    addPlayer.setForeground(titleColor);
    addPlayer.setBorder(BorderFactory.createLineBorder(titleColor, 2));
    addPlayer.setPreferredSize(new Dimension(120, 30));
    submit.add(addPlayer, subGbc);

    // clear button
    removePlayer = new JButton("Remove Player");
    subGbc.gridx = 0;
    subGbc.gridy = 0;
    removePlayer.addActionListener(this);
    removePlayer.setBorder(BorderFactory.createLineBorder(titleColor, 2));
    removePlayer.setPreferredSize(new Dimension(120, 30));
    removePlayer.setFont(button);
    removePlayer.setForeground(titleColor);
    submit.add(removePlayer, subGbc);

    // create team button
    team = new JButton("Create A Team");
    subGbc.gridx = 0;
    subGbc.gridy = 1;
    subGbc.gridwidth = 2;
    subGbc.fill = GridBagConstraints.HORIZONTAL;
    team.setBorder(BorderFactory.createLineBorder(titleColor, 2));
    team.setPreferredSize(new Dimension(240, 30));
    team.addActionListener(this);
    team.setFont(button);
    team.setForeground(titleColor);
    submit.add(team, subGbc);

    // add team list
    JLabel teamList = new JLabel("Team List");
    teamList.setVerticalAlignment(SwingConstants.NORTH);
    teamList.setFont(subtitle2);
    teamList.setBackground(background);
    teamList.setOpaque(true);
    right.add(teamList);

    teamMembers = new JTextArea("Team hasn't been created");
    teamMembers.setWrapStyleWord(true);
    teamMembers.setLineWrap(true);
    teamMembers.setEditable(false);
    teamMembers.setFocusable(false);
    right.add(Box.createVerticalStrut(10));
    right.add(new JScrollPane(teamMembers));

    // add starting line up
    JLabel startingLine = new JLabel("Starting Lineup");
    startingLine.setFont(subtitle2);
    right.add(Box.createVerticalStrut(10));
    right.add(startingLine);

    startingLineMember = new JTextArea("Team hasn't been created");
    startingLineMember.setEditable(false);
    startingLineMember.setFocusable(false);
    right.add(Box.createVerticalStrut(10));
    right.add(new JScrollPane(startingLineMember));

    // add panels to the frame
    this.add(top);
    this.add(info);
    this.add(left);
    this.add(submit);
    this.add(back);
    this.add(right);
    setVisible(true);
  }

  @Override public void setController(TeamController controller) {
    teamController = controller;
  }

  @Override public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addPlayer) {
      if (firstInput.getText().isEmpty() || lastInput.getText().isEmpty() || birthInput.getText()
          .isEmpty() || posInput.getSelectedItem() == null
          || skillLevel.getSelectedItem() == null) {
        popEmptyField();
      } else {
        teamController.addPlayer(firstInput.getText(), lastInput.getText(), birthInput.getText(),
            (Position) posInput.getSelectedItem(), (int) skillLevel.getSelectedItem());
      }
    }
    if (e.getSource() == team) {
      teamController.createTeam();
    }
    if (e.getSource() == removePlayer) {
      if (firstInput.getText().isEmpty() || lastInput.getText().isEmpty() || birthInput.getText()
          .isEmpty()) {
        popEmptyField();
      } else {
        teamController.removePlayer(firstInput.getText(), lastInput.getText(),
            birthInput.getText());
      }
    }
  }

  @Override public void popInvalidNumber() {
    JOptionPane.showMessageDialog(null,
        "Oops! You need at least 10 players to create a team. \nPlease add more players "
            + "before trying to create a team.", "Not Enough Players", JOptionPane.WARNING_MESSAGE);
  }

  @Override public void popInvalidAge() {
    JOptionPane.showMessageDialog(null, "Players should be under 10 years " + "old.",
        "Over Age Limit", JOptionPane.WARNING_MESSAGE);
  }

  @Override public void popInvalidBirthdate() {
    JOptionPane.showMessageDialog(null,
        "Please enter the birthdate in the yyyy/mm/dd \nformat (e.g. 1917/03/10)",
        "Invalid Birthdate Format", JOptionPane.WARNING_MESSAGE);
  }

  @Override public void popDuplicate() {
    JOptionPane.showMessageDialog(null,
        "Oops! It looks like you've " + "already added this player.",
        "Duplicate Player Entry",
        JOptionPane.WARNING_MESSAGE);
  }

  @Override public void popEmptyField() {
    JOptionPane.showMessageDialog(null,
        "Oops! It looks like you didn't fill out all the \nrequired fields for the "
            + "player. Please complete \nall fields before adding the player.",
        "Incomplete Player Information", JOptionPane.WARNING_MESSAGE);
  }

  @Override public void popTeamMessage() {
    JOptionPane.showMessageDialog(null,
        "Congratulations! \nYour team has been created successfully. \nPlease note that"
            + " if you create the team multiple times, the jersey numbers will be different.",
        "Team Creation Success", JOptionPane.INFORMATION_MESSAGE);
  }

  @Override public void setPlayerList(String team, String start) {
    teamMembers.setText(team);
    startingLineMember.setText(start);
  }

  @Override public void popRemoveError() {
    JOptionPane.showMessageDialog(null,
        "Oops! It looks like the player you are trying to remove is not \nin the team's"
            + " waiting list. Please check your selection and try again.",
        "Player Not Found", JOptionPane.WARNING_MESSAGE);
  }

  @Override public void popSucMessage(int type) {
    if (type == 1) {
      JOptionPane.showMessageDialog(null,
          "Congratulations! \nYou have added the player successfully.", "Player "
              + "Addition Success",
          JOptionPane.INFORMATION_MESSAGE);
    } else if (type == 2) {
      JOptionPane.showMessageDialog(null,
          "Congratulations! \nYou have removed the player successfully.", "Player "
              + "Removal Success",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  @Override public void setWaitListSize(String size) {
    waitMember.setText(size);
  }
}
