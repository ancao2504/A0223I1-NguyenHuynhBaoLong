function hover () {
    alert("Your answer is right!!!");
}

function noHover () {
   let width = Math.floor(Math.random()* window.innerHeight);
    height = Math.floor(Math.random()* window.innerWidth) ;
    document.getElementById("noButton").style.left=width+"px";
    document.getElementById("noButton").style.top=height+"px";
    console.log(width);
    console.log(height);
}