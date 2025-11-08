package Factory.Standard.Pizza;

// This is the "Product" interface (or abstract class).
// It defines the common interface for all objects the factory can create.
public abstract class Pizza {
    public abstract void prepare();

    public abstract void bake();

    public abstract void cut();

    public abstract void box();
}