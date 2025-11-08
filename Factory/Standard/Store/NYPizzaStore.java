package Factory.Standard.Store;

import Factory.Standard.Pizza.NY.NYStyleCheesePizza;
import Factory.Standard.Pizza.NY.NYStylePepperoniPizza;
import Factory.Standard.Pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

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
