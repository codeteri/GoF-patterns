package Decorator;

/* 
This program models a game character who can equip different items
that modify their stats using the Decorator pattern but in java. 
*/

// Component Interface
interface Character {
  int getAttack();

  int getDefense();

  String getEquipment();
}

// Concrete Component
class PlayerCharacter implements Character {
  @Override
  public int getAttack() {
    return 10;
  }

  @Override
  public int getDefense() {
    return 5;
  }

  @Override
  public String getEquipment() {
    return "Player";
  }
}

// Decorator Base Class
abstract class ItemDecorator implements Character {
  protected Character character;

  public ItemDecorator(Character character) {
    this.character = character;
  }

  @Override
  public int getAttack() {
    return character.getAttack();
  }

  @Override
  public int getDefense() {
    return character.getDefense();
  }

  @Override
  public String getEquipment() {
    return character.getEquipment();
  }
}

// Concrete Decorator A: Pump
class Pump extends ItemDecorator {
  public Pump(Character character) {
    super(character);
  }

  @Override
  public int getAttack() {
    return super.getAttack() + 15;
  }

  @Override
  public String getEquipment() {
    return super.getEquipment() + ", Pump";
  }
}

// Concrete Decorator B: Shield
class Shield extends ItemDecorator {
  public Shield(Character character) {
    super(character);
  }

  @Override
  public int getDefense() {
    return super.getDefense() + 10;
  }

  @Override
  public String getEquipment() {
    return super.getEquipment() + ", Shield";
  }
}

// Main class to run the demonstration
public class GameCharacter {
  public static void printStats(Character character) {
    System.out.println("Character: [ " + character.getEquipment() + " ]"
        + " | Attack: " + character.getAttack()
        + " | Defense: " + character.getDefense());
  }

  public static void main(String[] args) {
    // 1. Start with a base character.
    Character player = new PlayerCharacter();
    printStats(player);

    // 2. Equip a pump.
    player = new Pump(player);
    printStats(player);

    // 3. Equip a shield.
    player = new Shield(player);
    printStats(player);
  }
}
