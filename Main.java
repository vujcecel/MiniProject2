/*
Mini Project 2
Group #4: Evan Vujcec, Zak Howe, Jake Hartman, Zachary Preszler
Date: 16-03-2021
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
* The main executing class
* This is a simple representation of an Easter Egg Hunt
* @author Evan Vujcec
* @version 11-03-2021
*/
class Main {
  private static ArrayList<Player> players = new ArrayList<Player>();

  /**
  * Adds a random number of eggs to each {@link Player} in the players list's basket
  */
  private static void hunt() {
    Random random = new Random();
    for (Player player : players) {
      int numEggs = random.nextInt(11);
      for (int i = 0; i < numEggs; i++)
        player.foundEgg(new Egg());
    }
  }

  /**
  * Pretty prints each {@link Player} in the player list by calling their printBasket() method
  */
  private static void recap() {
    for (int i = 0; i < players.size(); i ++) {
      System.out.printf("Player %d found %d eggs%n", i, players.get(i).getNumEggs());
      players.get(i).printBasket();
      System.out.println();
    }
    System.out.println();
  }

  /**
  * Pretty prints the overall stats for the hunt
  * This includes:
  *   Player with most eggs and their total
  *   Total eggs found
  *   Total eggs of each {@link Color} found
  *   Total eggs with each {@link Contents} found
  */
  private static void stats() {
    int idxMost = 0;
    int mostEggs = players.get(idxMost).getNumEggs();
    int playersSize = players.size();
    if (playersSize > 1) {
      for (int i = 1; i < playersSize; i++) {
        int numEggs = players.get(i).getNumEggs();
        if (numEggs > mostEggs) {
          idxMost = i;
          mostEggs = numEggs;
        }
      }
    }
    System.out.printf("Player %d found the most eggs, with %d eggs!%n%n%n", idxMost, mostEggs);

    int totalEggs = 0;
    int colorCount[] = { 0, 0, 0, 0 };
    int contentsCount[] = { 0, 0, 0, 0, 0, 0, 0 };
    for (Player player : players) {
      for (Egg egg : player.getBasket()) {
        Color eggColor = egg.getColor();
        Contents eggContents = egg.getContents();

        switch (eggColor) {
          case blue:
            colorCount[0]++;
            break;
          case pink:
            colorCount[1]++;
            break;
          case yellow:
            colorCount[2]++;
            break;
          case green:
            colorCount[3]++;
            break;
          default:
            System.out.printf("Error: unable to count invalid color %s", eggColor);
        }
        
        switch (eggContents) {
          case cadbury:
            contentsCount[0]++;
            break;
          case reeses:
            contentsCount[1]++;
            break;
          case starburst:
            contentsCount[2]++;
            break;
          case peep:
            contentsCount[3]++;
            break;
          case quarter:
            contentsCount[4]++;
            break;
          case fifty:
            contentsCount[5]++;
            break;
          case dollar:
            contentsCount[6]++;
            break;
          default:
            System.out.printf("Error: unable to count invalid contents %s", eggContents);
        }

        totalEggs++;
      }
    }
    System.out.printf("Total eggs found: %d%n%n", totalEggs);

    System.out.printf("Blue eggs: %d%n", colorCount[0]);
    System.out.printf("Pink eggs: %d%n", colorCount[1]);
    System.out.printf("Yellow eggs: %d%n", colorCount[2]);
    System.out.printf("Green eggs: %d%n%n", colorCount[3]);

    System.out.printf("Cadbury eggs: %d%n", contentsCount[0]);
    System.out.printf("Reese's eggs: %d%n", contentsCount[1]);
    System.out.printf("Starburst eggs: %d%n", contentsCount[2]);
    System.out.printf("Peep eggs: %d%n", contentsCount[3]);
    System.out.printf("Quarter eggs: %d%n", contentsCount[4]);
    System.out.printf("Fifty cent eggs: %d%n", contentsCount[5]);
    System.out.printf("Dollar eggs: %d%n", contentsCount[6]);
  }

  /**
  * The executing method on the main thread
  * @param args A primitive array of Strings for command line arguments
  */
  public static void main(String[] args) {
    // Get desired number of players
    Scanner scanner = new Scanner(System.in);
    int numPlayers;
    System.out.print("How many players are in this Easter egg hunt? ");
    do {
      System.out.print("Enter a positive whole number: ");
      while (!scanner.hasNextInt()) {
        System.out.print("Enter a positive whole number: ");
        scanner.next();
      }
      numPlayers = scanner.nextInt();
    } while (numPlayers <= 0);
    scanner.close();

    // Create roster of players
    for (int i = 0; i < numPlayers; i++)
      players.add(new Player());
    System.out.printf("We have added %d players to this hunt. Let's find some eggs!%n%n", players.size());
    
    hunt();
    recap();
    stats();
  }
}