#include <iostream>
// State pattern example: Vending Machine
class IVendingMachineState
{
public:
  virtual void handleRequest() = 0;
  virtual ~IVendingMachineState() { std::cout << "delete" << std::endl; }
};

class ReadyState : public IVendingMachineState
{
public:
  void handleRequest() override
  {
    std::cout << "Ready state: Please select a product." << std::endl;
  }
};

class ProductSelectedState : public IVendingMachineState
{
public:
  void handleRequest() override
  {
    std::cout << "Product selected state: Processing payment." << std::endl;
  }
};

class PaymentPendingState : public IVendingMachineState
{
public:
  void handleRequest() override
  {
    std::cout << "Payment pending state: Dispensing product." << std::endl;
  }
};

class OutOfStockState : public IVendingMachineState
{
public:
  void handleRequest() override
  {
    std::cout << "Out of stock state: Product unavailable. Please select another product." << std::endl;
  }
};

class VendingMachineContext
{
  IVendingMachineState *state = nullptr;

public:
  VendingMachineContext() : state(nullptr) {}
  ~VendingMachineContext()
  {
    delete state;
  }
  void setState(IVendingMachineState *state_)
  {
    if (state != nullptr)
    {
      delete state;
    }
    this->state = state_;
  }

  void request()
  {
    state->handleRequest();
  }
};

int main()
{
  // Create context on the stack
  VendingMachineContext vendingMachine;

  // Set initial state
  vendingMachine.setState(new ReadyState());

  // Request state change
  vendingMachine.request();

  // Change state
  vendingMachine.setState(new ProductSelectedState());

  // Request state change
  vendingMachine.request();

  // Change state
  vendingMachine.setState(new PaymentPendingState());

  // Request state change
  vendingMachine.request();

  // Change state
  vendingMachine.setState(new OutOfStockState());

  // Request state change
  vendingMachine.request();
}