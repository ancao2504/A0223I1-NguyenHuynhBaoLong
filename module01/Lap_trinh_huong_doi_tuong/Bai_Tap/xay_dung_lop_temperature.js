class Temperature {
  constructor(celsius) {
    this.celsius = celsius;
  }

  changeToFahrenheit() {
    return (this.celsius * 9) / 5 + 32;
  }

  changeToKelvin() {
    return this.celsius + 273, 15;
  }
}
let temperature = new Temperature(25);
let Fahrenheit = temperature.changeToFahrenheit();
let Kelvin = temperature.changeToKelvin();

alert("Fahrenheit= " + Fahrenheit);
alert("Kelvin= " + Kelvin);
