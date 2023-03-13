let user = prompt("Enter username ","");
let passWord ;
if (user == "Admin") {
    passWord =prompt("Enter the password","");
    if (passWord == "TheMaster ") {
        alert("Welcome!")
    } else if (passWord == "null") {
        alert("Canceled");
    } else {
        alert("Wrong password");
    }
} else if (user == "null") {
    alert("Canceld");
} else {
    alert("I don't know you");
}