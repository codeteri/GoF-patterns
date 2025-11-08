package Factory.Standard;

import Factory.Standard.Pizza.Pizza;
import Factory.Standard.Store.NYPizzaStore;
import Factory.Standard.Store.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza pepperoniPizza = nyPizzaStore.orderPizza("pepperoni");

    }
}