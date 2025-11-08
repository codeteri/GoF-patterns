package Factory.Standard;

import Factory.Standard.Pizza.Pizza;

// This is the abstract "Creator" class.
// It declares the factory method, which returns an object of type Product.
public abstract class PizzaStore {

  /* 
  This is the FACTORY METHOD. It's abstract, forcing subclasses to implement
  it.
  Subclasses will decide which concrete Pizza object to create.
  */
  protected abstract Pizza createPizza(String type);
  /* 
  This is a concrete method in the Creator that uses the factory method.
  The Creator itself doesn't know which kind of pizza will be created.
  It only knows that it will be some subclass of Pizza. 
  */
  public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);

    System.out.println("--- Making a " + pizza.getClass().getSimpleName() + " ---");
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }
}
