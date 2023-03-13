// Bài tập 1
let browser =prompt("What is your browser?");

switch(browser) {
    case "Edge" :
        alert("You 've got the Edge! ");
        break;
    case "Chrome":
    case "Firefox":
    case "Safari":
    case "Opera":
        alert("Okay we support these browser too! ");
        break;
    default :
    alert("We hope that this page look ok! ");
}

// Bài tập 2
let a= parseInt(prompt("a?",""));

switch(a) {
    case 0:
        alert(0);
        break;
    case 1:
        alert(1);
        break;
    case 2:
    case 3:
        alert('2,3');
        break;
}
// Bài tập 3

let value =parseInt(prompt("Type of number","0"));

if (value < 0) {
    alert(-1);
} else if (value > 0) {
    alert(1);
} else {
    alert(0);
} 
