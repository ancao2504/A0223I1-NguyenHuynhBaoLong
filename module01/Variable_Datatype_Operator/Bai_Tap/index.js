// Bài tập 1
let inputphysic;
let inputchemistry;
let inputbiology;

function average() {
    inputphysic = prompt('Input physic');
    inputchemistry = prompt('Input chemistry');
    inputbiology = prompt('Input biology');

    let physic = parseFloat(inputphysic);
    let chemistry = parseFloat(inputchemistry);
    let biology = parseFloat(inputbiology);

    let Average = (physic + chemistry + biology) / 3;
    alert("Average = " + Average);
}

// Bài tập 2
let inputTemperature;
function temperature() {
    inputTemperature=prompt('input Temperature');

    let Celsius= parseFloat(inputTemperature);

    let Fahrenheit = 32+ (9*Celsius/5);
    alert("Fahrenheit = "+Fahrenheit);
}
// Bài tập 3-4
let pi=3.14;
let inputR;
function area() {
    inputR=prompt("Input R");

    let r= parseFloat(inputR);

    let Area= pi*r*r;
    let Perimeter=r*2*pi;
    alert("Area= " + Area);
    alert("Perimeter= " + Perimeter);
}
