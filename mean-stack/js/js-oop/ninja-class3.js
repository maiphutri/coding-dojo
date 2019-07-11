class Ninja {
  constructor(name, health=100, speed=3, strength=3) {
    this.name = name
    this.health = health
    this.speed = speed
    this.strength = strength
  }

  sayName() {
    console.log("My name is " + this.name);
  }

  showStats() {
    console.log("Name: " + this.name + ", Health: " + this.health + ", Strength: " + this.strength + ", Speed: " + this.speed);
  }

  drinkSake() {
    this.health += 10;
  }
}

class Sensei extends Ninja {
  constructor(name, health, speed, strength, wisdom=10) {
    super(name, health, speed, strength);
    this.wisdom = wisdom;
  }

  speakWisdom() {
    super.drinkSake();
    console.log("What one programmer can do in one month, two programmers can do in two months.")
  }
}

const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();