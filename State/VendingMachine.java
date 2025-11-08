package State;

// State interface
interface IVendingMachineState {
  void handleRequest();
}

// Concrete State: Ready
class ReadyState implements IVendingMachineState {
  @Override
  public void handleRequest() {
    System.out.println("Ready state: Please select a product.");
  }
}

// Concrete State: Product Selected
class ProductSelectedState implements IVendingMachineState {
  @Override
  public void handleRequest() {
    System.out.println("Product selected state: Processing payment.");
  }
}

// Concrete State: Payment Pending
class PaymentPendingState implements IVendingMachineState {
  @Override
  public void handleRequest() {
    System.out.println("Payment pending state: Dispensing product.");
  }
}

// Concrete State: Out of Stock
class OutOfStockState implements IVendingMachineState {
  @Override
  public void handleRequest() {
    System.out.println("Out of stock state: Product unavailable. Please select another product.");
  }
}

// Context class that holds the current state
class VendingMachineContext {
  private IVendingMachineState state;

  public VendingMachineContext() {
    this.state = null; // Start with no state
  }

  public void setState(IVendingMachineState state) {
    this.state = state;
  }

  public void request() {
    if (this.state != null) {
      this.state.handleRequest();
    }
  }
}

// Main class to demonstrate the State pattern
public class VendingMachine {
  public static void main(String[] args) {
    // Create context
    VendingMachineContext vendingMachine = new VendingMachineContext();

    // Set initial state
    vendingMachine.setState(new ReadyState());
    vendingMachine.request();

    // Change state
    vendingMachine.setState(new ProductSelectedState());
    vendingMachine.request();

    // Change state
    vendingMachine.setState(new PaymentPendingState());
    vendingMachine.request();

    // Change state
    vendingMachine.setState(new OutOfStockState());
    vendingMachine.request();
  }
}
