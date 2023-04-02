class Circle {
  constructor(radius, color) {
    this.radius = radius;
    this.color = color;

    this.circle = function (radius) {
      this.radius = radius;
    };
    this.getRadius = function () {
      return radius;
    };
    this.getArea = function () {
      return Math.PI * radius * radius;
    };
  }
}

let circle = new Circle(2, "red");
circle.getRadius();
console.log(circle.getRadius());
circle.getArea();
console.log(circle.getArea());
