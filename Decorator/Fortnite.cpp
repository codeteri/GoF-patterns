#include <iostream>
#include <string>
#include <memory>

/* 
This program models a game character who can equip different items
that modify their stats using the Decorator pattern but in java. 
*/

// Component Interface
class Character
{
public:
  virtual ~Character() = default;
  virtual int getAttack() const = 0;
  virtual int getDefense() const = 0;
  virtual std::string getEquipment() const = 0;
};

// Concrete Component: The base character
class PlayerCharacter : public Character
{
public:
  int getAttack() const override { return 10; }
  int getDefense() const override { return 5; }
  std::string getEquipment() const override { return "Player"; }
};

// Decorator Base Class
class ItemDecorator : public Character
{
protected:
  std::unique_ptr<Character> character;

public:
  ItemDecorator(std::unique_ptr<Character> c) : character(std::move(c)) {}

  int getAttack() const override { return character->getAttack(); }
  int getDefense() const override { return character->getDefense(); }
  std::string getEquipment() const override { return character->getEquipment(); }
};

// Concrete Decorator A: Pump
class Pump : public ItemDecorator
{
public:
  Pump(std::unique_ptr<Character> c) : ItemDecorator(std::move(c)) {}

  int getAttack() const override { return character->getAttack() + 15; }
  std::string getEquipment() const override { return character->getEquipment() + ", Pump"; }
};

// Concrete Decorator B: Shield
class Shield : public ItemDecorator
{
public:
  Shield(std::unique_ptr<Character> c) : ItemDecorator(std::move(c)) {}

  int getDefense() const override { return character->getDefense() + 10; }
  std::string getEquipment() const override { return character->getEquipment() + ", Shield"; }
};

void printStats(const Character &character)
{
  std::cout << "Character: [ " << character.getEquipment() << " ]"
            << " | Attack: " << character.getAttack()
            << " | Defense: " << character.getDefense() << std::endl;
}

int main()
{
  printf("Think of it like fortnite:\n");
  // 1. Start with a base character.
  auto player = std::make_unique<PlayerCharacter>();
  printStats(*player);

  // 2. Equip a pump shotgun.
  auto playerWithPump = std::make_unique<Pump>(std::move(player));
  printStats(*playerWithPump);

  // 3. Equip a shield.
  auto playerWithPumpAndShield = std::make_unique<Shield>(std::move(playerWithPump));
  printStats(*playerWithPumpAndShield);

  return 0;
}
