import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
* Represents the {@link Egg}
* @author Evan Vujcec
* @version 11-03-2021
*/
class Egg {
  private Color color;
  private Contents contents;

  Egg() {
    color = randomColor();
    contents = randomContents();
  }

  /**
  * Returns the color of the {@link Egg}
  * @return {@link Color}
  */
  Color getColor() { return color; }

  /**
  * Returns the contents of the {@link Egg}
  * @return {@link Contents}
  */
  Contents getContents() { return contents; }

  private static final List<Color> COLOR_VALUES = Collections.unmodifiableList(Arrays.asList(Color.values()));
  private static final int COLOR_SIZE = COLOR_VALUES.size();

  private static final List<Contents> CONTENTS_VALUES = Collections.unmodifiableList(Arrays.asList(Contents.values()));
  private static final int CONTENTS_SIZE = CONTENTS_VALUES.size();

  private static final Random RANDOM = new Random();

  /**
  * Returns a random {@link Color} value
  * @return {@link Color}
  */
  private Color randomColor() {
    return COLOR_VALUES.get(RANDOM.nextInt(COLOR_SIZE));
  }

  /**
  * Returns a random {@link Contents} value
  * @return {@link Contents}
  */
  private Contents randomContents() {
    return CONTENTS_VALUES.get(RANDOM.nextInt(CONTENTS_SIZE));
  }

  /**
  * Pretty prints the egg
  */
  void printEgg() {
    System.out.printf("%s egg contains %s%n", randomColor(), randomContents());
  }
}