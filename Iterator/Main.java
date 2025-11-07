package Iterator;

import java.util.Iterator;

/* 
Imagine you have a program that sometimes finishes its job in 1 second, 
sometimes in 2 seconds, sometimes in 4, and so on (powers of two). 
But you don't know which run will be fast. 
The program also has a bug where it might freeze and never finish.

Your only tool is to run it for a certain amount of time, 
and if it's not done, you kill it and restart it.

So what The Luby sequence gives you the provably best sequence of timeouts 
to use when you don't know the ideal timeout in advance. 
It balances exploration (trying long timeouts) with exploitation (using short timeouts that are often successful). 
*/

// By implementing Iterable, this class promises it can provide an "iterator" (a "remote control").
class Main implements Iterable<Integer> {
  @Override
  public Iterator<Integer> iterator() {
    // Return an anonymous inner class that implements the Iterator interface.
    // This is the "remote control" object.
    Iterator<Integer> it = new Iterator<Integer>() {
      // State variables for the Luby sequence generator.
      int u = 0; // Tracks the main sequence group.
      int v = 0; // Tracks the power-of-two subsequence.
      int max = 16; // The limit for the sequence generation.

      @Override
      public boolean hasNext() {
        // Check if we are still within the defined limit.
        var result = v < max;

        // This block calculates the *next* value in the sequence *before* it's
        // requested by next().
        if (u == 0) { // Initialize for the very first element.
          u = v = 1;
        } else {
          // (u & -u) is a bitwise trick to get the least significant bit of u.
          // This condition checks if the power-of-two subsequence (v) has "caught up"
          // to the main sequence counter (u), signaling the end of a subsequence.
          if ((u & -u) == v) {
            u++; // Move to the next main sequence group.
            v = 1; // Reset the subsequence to start from 1.
          } else {
            v *= 2; // Otherwise, continue the power-of-two subsequence.
          }
        }
        return result;
      }

      @Override
      public Integer next() {
        // Returns the value that was prepared by the previous call to hasNext().
        // The check for 0 handles the initial state before hasNext() is first called.
        return 0 == v ? 1 : v;
      }

      @Override
      public void remove() {
        // This operation is not supported for this iterator.
        throw new UnsupportedOperationException();
      }
    };
    return it;
  }

  public static void main(String[] args) {
    Main luby = new Main();
    // The for-each loop automatically uses the iterator provided by the 'luby'
    // object.
    // For each loop iteration, it implicitly calls hasNext() and then next().
    for (Integer i : luby) {
      System.out.printf("%d ", i);
    }
  }
}