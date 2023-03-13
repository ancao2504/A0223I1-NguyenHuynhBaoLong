function calculator() {
    let weight = parseFloat(document.getElementById("weight").value);
    let height = parseFloat(document.getElementById("height").value);
    let bmi = weight / (height * height);
    let result;
    if (bmi < 18.5) {
        result = "Underweight";
    } else if (18.5 <= bmi && bmi < 25.0) {
        result = "Normal";
    } else if (25.0 <= bmi && bmi < 30.0) {
        result = "Overweight";
    } else {
        result = "Obese";
    }
    document.getElementById("result").innerHTML = result;
}
