function convert() {
    let inputamount =document.forms["change"]["Amout"];
    let fromcurrency =document.forms["change"]["fromCurrency"].value;
    let tocurrency =document.forms["change"]["toCurrency"].value;

    let money;
    let Currency = parseInt(inputamount.value);
    if (fromcurrency== tocurrency) {
        alert("Can't Convert");
    }else if (fromcurrency.value == "Viet-Nam" && tocurrency.value == "USD") {
        money = Currency /23000;
        document.getElementById("result").innerHTML="Result= "+money+"USD";
    }else {
        money= Currency * 23000;
        document.getElementById("result").innerHTML="Result= "+money+"VND"
    }
}
