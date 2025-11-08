package Factory.Standard.Pizza.NY;

import Factory.Standard.Pizza.Pizza;

// This is a "Concrete Product".
// It's one specific type of object that our factory can create.
public class NYStylePepperoniPizza extends Pizza {

    // Each concrete product provides its own implementation for the abstract
    // methods.
    @Override
    public void prepare() {
        System.out.println("Preparing `NY Style Pepperoni Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking NY Style Pepperoni Pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting NY Style Pepperoni Pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing NY Style Pepperoni Pizza...");
    }
}
