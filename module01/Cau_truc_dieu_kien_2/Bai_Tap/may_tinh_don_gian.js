let result = document.getElementById("output");
result.value ='';
function inputValue(num) {
    result.value = result.value + num;
    console.log(result.value);
}
function calculate() {
    result.value = eval(result.value);
}
function removeValue() {
    result.value='';
}

