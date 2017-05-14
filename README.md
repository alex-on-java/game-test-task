# A command line based role playing game.
This is a test task to implement a small RPG game. It should be build for command line and no external libraries are accepted.

## User stories:
 * As a player I want to create a character
 * As a player I want to explore
 * As a player I want to gain experience through fighting
 * As a player I want to save and resume a game
 
## I implement following features
 * At the start of the game you could set the name of you hero. Other stats are predefined
 * There is no map, you just exploring the world, trying to find and beat a monster
 * After each move you could encounter a monster
 * Also you could check monster and hero info on each turn
 * If you think that you couldn't beat a monster, you could flee
 * Fighting is computed in following order: hero hitting monster, than, if monster is alive, it is hitting back. If everybody are alive after that - repeat.  
 * For each killed monster you will gain a bunch of experience points.
 * Your level is increased, and that is increasing you maximum health and damage points
 * On each level up you health points are restored (to the new maximum) 
 * After you'll kill the final monster - the game is over, you won it!
 * You could save the game and resume it at the start (but there could be only one file per installation)
 
## How to run
 * Build project with mvn clean package
 * Run (from project folder) java -jar target/game.jar
 * NB: Java 8 is required