package Adapter;

public class Main {

  // Legacy Printer (Adaptee)
  static class LegacyPrinter {
    public void printInUppercase(String text) {
      StringBuilder copy = new StringBuilder();
      for (char c : text.toCharArray()) {
        if (Character.isUpperCase(c)) {
          copy.append(c);
        } else {
          copy.append(' ');
        }
      }
      System.out.println("Printing: " + copy.toString());
    }
  }

  // Modern Computer (Client)
  static class ModernComputer {
    public void sendCommand(String command) {
      System.out.println("Sending command: " + command);
    }
  }

  // Adapter class to make the LegacyPrinter compatible with ModernComputer
  static class PrinterAdapter {
    private LegacyPrinter legacyPrinter = new LegacyPrinter();

    public void sendCommand(String command) {
      // Convert the command to uppercase and pass it to the LegacyPrinter
      String uppercaseCommand = command.toUpperCase();
      legacyPrinter.printInUppercase(uppercaseCommand);
    }
  }

  public static void main(String[] args) {
    LegacyPrinter oldPrinter = new LegacyPrinter();
    ModernComputer computer = new ModernComputer();
    PrinterAdapter adapter = new PrinterAdapter();

    oldPrinter.printInUppercase("Print this in lowercase");
    computer.sendCommand("Print this in lowercase");
    adapter.sendCommand("Print this in lowercase (adapted)");
  }
}
