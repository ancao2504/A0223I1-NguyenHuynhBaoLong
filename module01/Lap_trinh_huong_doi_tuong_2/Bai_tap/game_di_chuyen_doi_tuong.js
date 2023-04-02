class Hero {
  constructor(picture, left, top, size) {
    this.picture = picture;
    this.left = left;
    this.top = top;
    this.size = size;
    this.getHeroElement = function () {
      return (
        '<img width="' +
        this.size +
        '"' +
        ' height="' +
        this.size +
        '"' +
        ' src="' +
        this.picture +
        '"' +
        ' style="top: ' +
        this.top +
        "px; left:" +
        this.left +
        'px;position:absolute;" />'
      );
    };
    this.moveRight = function () {
      this.left += 20;
      console.log("=========right:======", this.left);
    };
    this.moveDown = function () {
      this.top += 20;
      console.log("=======bottom:======", this.top);
    };
  }
}
let hero = new Hero("pikachu.jpg", 20, 30, 300);

function start() {
  if (hero.left < window.innerWidth - hero.size) {
    hero.moveRight();
  } else if (
    hero.left == window.innerWidth - hero.size &&
    hero.top < window.innerHeight - hero.size
  ) {
    hero.moveDown();
  }
  document.getElementById("game").innerHTML = hero.getHeroElement();
  setTimeout(start, 50);
}
start();
