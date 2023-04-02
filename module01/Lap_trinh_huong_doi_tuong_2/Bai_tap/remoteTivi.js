class Remote {
  constructor(pinCode) {
    this.pinCode = pinCode;
  };

  change(tivi, some) {
    tivi.channel = some;
  };

  turnOff(tivi) {
    tivi.status = false;
  };

  changeSound(tivi) {
    tivi.sound++;
    return tivi.sound;
  };
}
class Tivi {
  constructor(status, channel, sound) {
    this.status = status;
    this.channel = channel;
    this.sound = sound;
  };

  getStatus() {
    return this.status;
  }
  isOn() {
    if (this.status ) {
      console.log("Tivi đang được mở");
    } else {
      console.log("Tivi đã tắt");
    }
  };

  

}
let remote = new Remote("132");
let tv = new Tivi(true, 7, 2);
tv.isOn();
remote.change(tv,9);
remote.changeSound(tv);
remote.turnOff(tv);
tv.isOn();
console.log("=======tv=====",tv);
console.log("=======remote====",remote);
