// bài tập 1
let i = 10;
let f = 20.5;
let b = true;
let s = "Hà Nội";
document.write('<br/>');
document.write("i = " + i);
document.write('<br/>');
document.write("f = " + f);
document.write('<br/>');
document.write("s = " + s);
document.write('<br/>');

// bài tập 2
let width = 20;
let height = 10;
let area = width + height;
document.write('area = '+ area);
document.write('<br/>');

// bài tập 3
function myFuction() {
    let a;
    let b;
    prompt('Input a',a);
    prompt('Input b',b);
    if (a % b!=0) {
        alert('a là bội của b');
    }else {
        alert('a không là bội của b');
    }
}