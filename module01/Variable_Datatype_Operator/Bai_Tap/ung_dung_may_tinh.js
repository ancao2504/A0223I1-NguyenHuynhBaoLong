let inputDivisor;
let inputDividend;

inputDivisor = document.forms["change"]["divisor"];
inputDividend = document.forms["change"]["dividend"];
function addition() {
    let divisor = parseInt(inputDivisor.value);
    let dividend = parseInt(inputDividend.value);
    let sum;
    sum=divisor +dividend;
    document.getElementById("result").innerHTML="Result= "+sum;
}
function subtraction() {
    let divisor = parseInt(inputDivisor.value);
    let dividend = parseInt(inputDividend.value);
    let sub;
    sub=divisor -dividend;
    document.getElementById("result").innerHTML="Result= "+sub;
}
function multiplication() {
    let divisor = parseInt(inputDivisor.value);
    let dividend = parseInt(inputDividend.value);
    let mul;
    mul=divisor *dividend;
    document.getElementById("result").innerHTML="Result= "+mul;
}
function division() {
    let divisor = parseInt(inputDivisor.value);
    let dividend = parseInt(inputDividend.value);
    let div;
    div=divisor/dividend;
    document.getElementById("result").innerHTML="Result= "+div;
}