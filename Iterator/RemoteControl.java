package Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoteControl {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("CNN");
    names.add("ALJAZEERA");
    names.add("BBC");

    System.out.println("--- Using the iterator directly ---");
    // The "manual" way using the iterator directly, like your remote control
    Iterator<String> it = names.iterator(); // 1. Get the "remote"
    while (it.hasNext()) { // 2. Check the "hasNext()" button
      String name = it.next(); // 3. Press the "next()" button
      System.out.println(name);
    }

    System.out.println("\n--- Using the for-each loop (syntactic sugar) ---");
    // The for-each loop does the same thing automatically
    for (String name : names) {
      System.out.println(name);
    }
  }
}
