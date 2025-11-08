package Factory.Standard;

import Factory.Standard.Pizza.Pizza;
import Factory.Standard.Pizza.NY.NYStyleCheesePizza;
import Factory.Standard.Pizza.NY.NYStylePepperoniPizza;

// This is a "Concrete Creator".
// It overrides the factory method to return an instance of a Concrete Product.
public class NYPizzaStore extends PizzaStore {

  // This is the implementation of the factory method.
  // It's responsible for creating the specific, concrete products for this store.
  @Override
  protected Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new NYStyleCheesePizza();
    } else if (type.equals("pepperoni")) {
      return new NYStylePepperoniPizza();
    } else {
      return null;
    }
  }
}
