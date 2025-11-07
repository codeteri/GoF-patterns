#include <iostream>
#include <vector>
#include <string>

// The Iterator interface
class Iterator
{
public:
  virtual ~Iterator() = default;
  virtual std::string next() = 0;
  virtual bool hasNext() const = 0;
};

// The Aggregate (Collection) interface
class Aggregate
{
public:
  virtual ~Aggregate() = default;
  virtual Iterator *createIterator() = 0;
};

// Concrete Iterator for our Television
class ChannelIterator : public Iterator
{
  const std::vector<std::string> &channels;
  size_t position = 0;

public:
  ChannelIterator(const std::vector<std::string> &ch) : channels(ch) {}

  std::string next() override
  {
    // Get current channel and move to the next one
    return channels[position++];
  }

  bool hasNext() const override
  {
    // Is there another channel after this one?
    return position < channels.size();
  }
};

// Concrete Aggregate (Collection)
class Television : public Aggregate
{
  std::vector<std::string> channels;

public:
  Television()
  {
    channels = {"HBO", "CNN", "ESPN", "Discovery"};
  }

  Iterator *createIterator() override
  {
    return new ChannelIterator(channels);
  }
};

int main()
{
  Television tv;
  Iterator *remote = tv.createIterator(); // 1. Get the "remote"

  std::cout << "--- Cycling through channels with the remote ---" << std::endl;
  while (remote->hasNext())
  {                                       // 2. Check the "hasNext()" button
    std::string channel = remote->next(); // 3. Press the "next()" button
    std::cout << "Watching: " << channel << std::endl;
  }

  delete remote; // Clean up the iterator
  return 0;
}
