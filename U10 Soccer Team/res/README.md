## Overview
This program allows the user to record players and create a U10 soccer team. 

## List of features
- add players to the waiting list
- remove players from the waiting list
- know the number of players in the waiting list
- create a soccer team
- get the list of the team
- get the starting lineup

## How To Run
use the command
> java -jar <path/to/jar/file.jar>

## How to Use the Program
- add players <br>
Before creating a team, the user should add players to the waiting list. To add players, all the fields in the form should be filled out.
- remove players <br>
To remove players, only fields of first name, last name and birthdate are required. However, players not in the waiting list can not be removed.
- create a team <br>
With 10 or more players, a team can be created. After a team is successfully created, the list of players in the team and in the starting lineup will show on the right side of program. <br>
Please note that if the user choose to create a team multiple times, the jersey number will be assigned randomly every time. As a result, players stayed in the team might have different jersey numbers.

## Design/Model Changes
- added public method of getting the waiting list size <br>
It is convenient for the coach to check whether they can create a team or not

## Assumptions
- Two players cannot have same first name, last name and birthdate at the same time
- players under 10 years old are old enough to play soccer


## Limitations
- The players on the waiting list are not shown <br>
This can be inconvenient for the coach if they want to remove someone but cannot recall their birthdate.
- the players who remain on the team have different jersey numbers if the team is created multiple times <br>

It is better to avoid changing the jersey numbers of these players.
## Citations
- “Java GUI: Full course ☕ (free),” YouTube, 14-Sep-2020. [Online]. Available: https://www.youtube.com/watch?v=Kmgo00avvEw&amp;t=12855s. [Accessed: 14-Apr-2023]. 
- “Java joptionpane 🛑,” YouTube, 27-Aug-2020. [Online]. Available: https://www.youtube.com/watch?v=BuW7y21FcYI&amp;t=571s. [Accessed: 13-Apr-2023]. 