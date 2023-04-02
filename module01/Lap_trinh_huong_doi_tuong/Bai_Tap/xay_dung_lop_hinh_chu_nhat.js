class Rectangle {
    constructor(x,y,width,height) {
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
    }
}
function getArea (rectangle){
    console.log(rectangle.width);
    let area=rectangle.width * rectangle.height;
    console.log(area);
    return area;
};
function getPerimeter (rectangle) {
    let perimeter=(rectangle.width +rectangle.height)*2;
    return perimeter;
};
function createRectangle(){
    let ctx = document.getElementById("myCanvas").getContext("2d");
    let width=rectangle.width;
    let height=rectangle.height;
    let x=rectangle.x;
    let y=rectangle.y;
    let rectangles= new Rectangle(x, y,width,height);
    ctx.beginPath();
    ctx.fillRect(x, y, rectangles.width, rectangles.height); 
    ctx.fill();
}
let rectangle = new Rectangle(0,0,50,60);
createRectangle();

console.log("======Area=====",getArea(rectangle));
console.log("=====perimeter======",getPerimeter(rectangle));