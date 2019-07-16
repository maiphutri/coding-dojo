class Bike {
  price: number;
  max_speed: string;
  miles: number;
  constructor(price:number, max_speed:string, miles:number=0) {
     this.price = price;
     this.max_speed = max_speed;
     this.miles = miles;
  }

  displayInfo() {
     console.log(`Price: ${this.price}, Max Speed: ${this.max_speed}, Miles: ${this.miles}`)
  }

  ride() {
     console.log("Riding");
     this.miles += 10;
     return this;
  }

  reverse() {
     console.log("Reversing");
     if (this.miles < 0) {
        this.miles = 0;
        return this;
     }
     this.miles -= 5;
     return this;
  }
}

let bike1 = new Bike(200, "25mph");
let bike2 = new Bike(400, "50mph");
let bike3 = new Bike(100, "10mph");
bike1.ride().ride().reverse().displayInfo();
bike2.ride().ride().reverse().reverse().displayInfo();
bike3.reverse().reverse().displayInfo();



