class Apple {
  constructor(weight) {
    this.weight = weight;
  }

  isEmpty() {
    if (this.weight > 0) {
      return true;
    } else {
      return false;
    }
  };

  decrease() {
    this.weight--;
    this.getWeight();
  };

  setWeight(weight) {
    this.weight = weight;
  }

  getWeight() {
    return this.weight;
  }
}

class Human {
  constructor(name, gender, weight) {
    this.name = name;
    this.gender = gender;
    this.weight = weight;
  }

  isMale() {
    if (this.gender) {
      return true;
    } else {
      return false;
    }
  };

  setGender(gender) {
    this.gender = gender;
  };

  checkApple(apple) {
    if (apple.weight > 0) {
      return true;
    } else {
      return false;
    }
  };

  eat(apple) {
    if (this.checkApple) {
      apple.decrease();
      this.weight++;
      console.log("Còn lại khối lượng táo là: " +apple.weight);
    } else {
      alert("Hết táo");
    }
  };

  say(string) {
    console.log(string);
  };

  getName() {
    return this.name;
  };

  setName(nameString) {
    this.name = nameString;
  };

  getWeight() {
    return weight;
  };

  setWeight(weight) {
    this.weight = weight;
  }
}

let apple = new Apple(10);
console.log('=====apple.weight=======', apple.weight);


let adam = new Human("Adam", true, 60);
adam.say("I'm Adam");
adam.setGender("Male");
console.log("Khối lượng táo lớn hơn 0", adam.checkApple(apple));
adam.eat(apple);

