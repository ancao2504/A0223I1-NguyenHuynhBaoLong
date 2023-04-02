class Circle {
    constructor(x, y, radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        
    }
}
function getRandomHex(){
    return Math.floor(Math.random()*255);
}
function getRandomColor() {
    let red =getRandomHex();
    let green =getRandomHex();
    let blue =getRandomHex();
    return "rgb("+red+","+green+","+blue+")";
}
function createCircle(){
    var ctx = document.getElementById("myCanvas").getContext("2d");
    let radius= Math.floor(Math.random()*80);
    let color = getRandomColor();
    let x=Math.floor(Math.random()*window.innerWidth);
    let y=Math.floor(Math.random()*window.innerHeight);
    var circle= new Circle(x, y, radius);
    ctx.beginPath();
    ctx.fillStyle = color;
    ctx.arc(circle.x, circle.y, circle.radius, 0, 2 * Math.PI);
  
    ctx.fill();
}
function createMultipleCircle(){
    for(var i = 0; i < 30; i++){
    createCircle();
}
}

createMultipleCircle();
getRandomColor();
getRandomHex();

