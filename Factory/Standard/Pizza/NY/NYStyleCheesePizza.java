package Factory.Standard.Pizza.NY;

import Factory.Standard.Pizza.Pizza;

// Another "Concrete Product".
public class NYStyleCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing NY Style Cheese Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking NY Style Cheese Pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting NY Style Cheese Pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing NY Style Cheese Pizza...");
    }
}
