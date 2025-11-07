package Decorator;

/*  
This program models an analogy of a Person getting dressed 
with different clothing items. 
*/

// Component Interface
interface Person {
    String getDescription();
}

// Concrete Component
class You implements Person {
    @Override
    public String getDescription() {
        return "You";
    }
}

// Decorator Base Class
abstract class ClothingDecorator implements Person {
    protected Person person;

    public ClothingDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String getDescription() {
        return person.getDescription();
    }
}

// Concrete Decorator A
class Sweater extends ClothingDecorator {
    public Sweater(Person person) {
        super(person);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " wearing a sweater";
    }
}

// Concrete Decorator B
class Raincoat extends ClothingDecorator {
    public Raincoat(Person person) {
        super(person);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " wearing a raincoat";
    }
}

// Main class to run the demonstration
public class PersonDemo {
    public static void main(String[] args) {
        // 1. Start with the base object.
        Person you = new You();
        System.out.println("Just you: " + you.getDescription());

        // 2. It gets cold. Wrap the 'you' object in a Sweater.
        you = new Sweater(you);
        System.out.println("It's cold: " + you.getDescription());

        // 3. It starts raining. Wrap the already-wrapped object in a Raincoat.
        you = new Raincoat(you);
        System.out.println("It's cold and wet: " + you.getDescription());
    }
}
