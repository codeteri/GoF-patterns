package Factory.Standard;

import Factory.Standard.Pizza.Pizza;

public class PizzaTestDrive {
  public static void main(String[] args) {
    /* Create a New York style pizza store.
    The client code only knows about the abstract PizzaStore. */
    PizzaStore nyStore = new NYPizzaStore();
    /* 
    The client calls the orderPizza method, which is defined in the abstract
    PizzaStore.
    The client doesn't know or care that NYPizzaStore is the one actually
    creating the pizza.
    This decouples the client from the concrete pizza creation process.
     */

    Pizza pizza = nyStore.orderPizza("cheese");
    System.out.println("Ethan ordered a " + pizza.getClass().getSimpleName() + "\n");

    pizza = nyStore.orderPizza("pepperoni");
    System.out.println("Joel ordered a " + pizza.getClass().getSimpleName() + "\n");
  }
}
