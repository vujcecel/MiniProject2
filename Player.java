import java.util.ArrayList;

/**
* Represents the {@link Player}
* @author Evan Vujcec
* @version 11-03-2021
*/
class Player {
  private int numEggs;
  private ArrayList<Egg> basket;

  Player() {
    basket = new ArrayList<Egg>();
    numEggs = basket.size();
  }

  /**
  * Basic accessor method for the number of eggs the {@link Player} has
  * This should be equal to the basket.size()
  * @return int The number of eggs the player has
  */
  int getNumEggs() { return numEggs; }

  /**
  * Basic accessor method for the {@link Player} basket
  * The basket contains the player's eggs
  * @return ArrayList<Egg> An {@link ArrayList} of type {@link Egg}
  */
  ArrayList<Egg> getBasket() { return basket; }

  /**
  * Adds the given egg to the {@link Player} basket
  * Updates the numEggs to the basket's new size
  * @param egg An {@link Egg} to be added to the {@link Player} basket
  */
  void foundEgg(Egg egg) {
    basket.add(egg);
    numEggs = basket.size();
  }

  /**
  * Pretty prints the contents of the {@link Player} basket
  * Does so by calling the printEgg() method on each {@link Egg}
  */
  void printBasket() {
    for (Egg egg : basket) {
      egg.printEgg();
    }
  }
}