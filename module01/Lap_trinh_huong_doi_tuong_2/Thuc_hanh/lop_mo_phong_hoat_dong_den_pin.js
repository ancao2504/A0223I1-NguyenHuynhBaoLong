class Battery {
  constructor(energy) {
    this.energy = energy;
    this.setEnergy = function (energy) {
      this.energy = energy;
    };
    this.getEnergy = function () {
      return this.energy;
    };
    this.decreaseEnergy = function () {
      if (this.energy > 0) {
        this.energy--;
      }
    };
  }
}
class Flashlamp {
  constructor(status, battery) {
    this.status = status;
    this.battery = battery;
    this.setBettery = function (battery) {
      this.battery = battery;
    };
    this.getBatteryInfo = function () {
        return (this.battery.setEnergy());
    };
    this.light = function () {
      if (this.status) {
        alert("Light is on");
        this.battery--;
      } else {
        alert("Light is off");
      }
    };
    this.turnOn = function () {
      if (this.status == false) {
        this.status = true;
      }
    };
    this.turnOff = function () {
      if (this.status) {
        this.status = false;
      }
    };
  }
}
let battery = new Battery();
battery.setEnergy(90);
battery.getEnergy();
console.log("========battery========", battery);

let lamp = new Flashlamp(false, battery.getEnergy());
lamp.turnOn();
lamp.light();
// document.write("Battery info: "+ lamp.getBatteryInfo()+"<br>");
// lamp.light();

 console.log("=========this.battery.setEnergy()=======", this.battery.setEnergy());
