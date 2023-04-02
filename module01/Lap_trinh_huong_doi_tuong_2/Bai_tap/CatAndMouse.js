class Rat {
  constructor(name, weight, speed,live) {
    this.name = name;
    this.weight = weight;
    this.speed = speed;
    this.live = live;
  };
  isLive() {
    if (this.live) {
      this.live = false;
      return this.live;
    }
  };

  sayString() {
    console.log("Chít Chít");
  };

}
class Mouse {
  constructor(name, weight, maxSpeed) {
    this.name = name;
    this.weight = weight;
    this.maxSpeed = maxSpeed;
  };

  sayString() {
    console.log("meo meo");
  };

  action(animal) {
    if (animal.speed < this.maxSpeed ) {
      console.log("bắt được chuột");
    }
  };

  eat(animal) {
    if (animal.live) {
      this.weight+=animal.weight;
    }
    return this.weight;
  };
}
let rat = new Rat("Jerry", 10, 50, true);
let mouse = new Mouse("Tom", 30, 60);
mouse.action(rat);
mouse.eat(rat);
mouse.sayString();
console.log("======rat====",rat);
console.log("======mouse====",mouse);
