class ElectricLamp {
  constructor(status) {
    this.status=status;
  };

  turnOn() {
    if (this.status) {
      console.log("Đèn đã sáng");
    } else {
      console.log("Đèn đã được bật!");  
      this.status=true;
    }
  }

  turnOff() {
    if (this.status == false) {
      console.log("Đèn đã tắt!");
    } else {
      console.log("Đèn đã được tắt");
      this.status=false;
    }
  }
}
class SwitchButton {
  constructor(status,lamp){
    this.status=status;
    this.lamp=lamp;
  };

  connectToLamp(object) {
    this.lamp=object;
  };

  switchOn() {
    if (!this.status) {
      this.lamp.turnOn();
      this.status=true;
      return this.status;
    }
  };

  switchOff() {
    if (this.status) {
    this.lamp.turnOff();
    this.status=false;
    return this.status;
  };
}
}
let button=new SwitchButton(true,"sony");
let sony=new ElectricLamp(true);
button.connectToLamp(sony);
button.switchOff()
console.log("=======switchOff=====",button);
button.switchOn();
console.log("=======switchOn=====",button);







