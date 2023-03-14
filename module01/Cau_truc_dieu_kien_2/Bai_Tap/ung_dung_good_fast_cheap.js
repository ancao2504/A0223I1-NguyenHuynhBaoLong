let Good = document.getElementById("good");
let Cheap = document.getElementById("cheap");
let Fast = document.getElementById("fast");
function option(number) {
    switch (number) {
        case 1:
            if (Good.checked && Cheap.checked) {
                Fast.checked=false;
            }
            break;
        case 2:
            if (Cheap.checked && Fast.checked) {
                Good.checked = false;
            }
            break;
        case 3:
            if (Good.checked && Fast.checked) {
                Cheap.checked= false;
                break;
            }
    }
}