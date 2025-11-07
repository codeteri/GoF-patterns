#include <iostream>
#include <string>

// Legacy Printer (Adaptee)
class LegacyPrinter {
public:
    void printInUppercase(const std::string& text) {
        auto copy = text;
        for (auto& c: copy) {
            if (!std::isupper(c)) { c = ' '; }
        }
        std::cout << "Printing: " << copy << std::endl;
    }
};

// Modern Computer (Client)
class ModernComputer {
public:
    void sendCommand(const std::string& command) {
        std::cout << "Sending command: " << command << std::endl;
    }
};

// Adapter class to make the LegacyPrinter compatible with
// ModernComputer
class PrinterAdapter {
    LegacyPrinter legacyPrinter;
public:
    void sendCommand(const std::string& command) {
        // Convert the command to uppercase and pass it to the LegacyPrinter
        std::string uppercaseCommand = command;
        for (char& c : uppercaseCommand) {
            c = std::toupper(c);
        }
        legacyPrinter.printInUppercase(uppercaseCommand);
    }
};

int main() {
    LegacyPrinter oldPrinter;
    ModernComputer computer;
    PrinterAdapter adapter;

    oldPrinter.printInUppercase("Print this in lowercase");
    computer.sendCommand("Print this in lowercase");
    adapter.sendCommand("Print this in lowercase (adapted)");

    return 0;
}