class Temperature {
    constructor (celsius) {
        this.celsius=celsius;
        this.changeToFahrenheit =function () {
            return (this.celsius*9/5)+32;
        };
        this.changeToKelvin = function () {
            return this.celsius+273,15 ;
        }
    };
}
let temperature =new Temperature(25);
let Fahrenheit=temperature.changeToFahrenheit();
let Kelvin =temperature.changeToKelvin();

alert("Fahrenheit= "+Fahrenheit);
alert("Kelvin= "+Kelvin);