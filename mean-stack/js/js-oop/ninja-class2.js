function Ninja(name, health=100) {
  var speed = 3;
  var strength = 3;
  var self = this;
  this.health = health;
  this.name = name;
  this.sayName = () => console.log("My name is " + this.name);
  this.showStats = () => console.log("Name: " + this.name + ", Health: " + this.health + ", Strength: " + strength + ", Speed: " + speed);
  this.drinkSake = () => {
    this.health += 10; 
    return this;
  };
  this.punch = (ninja) => {
    if (ninja instanceof Ninja) {
      ninja.health -= 5;
    }
  }
  this.kick = (ninja) => {
    if (ninja instanceof Ninja) {
      ninja.health -= 15;
    }
  }
}

var ninja1 = new Ninja("Tri");
var ninja2 = new Ninja("Z");
ninja1.punch(ninja2);
ninja2.showStats();
ninja1.kick(ninja2);
ninja2.showStats();


