function hover () {
    alert("Your answer is right!!!");
}

function noHover () {
   let width = (Math.random(0.1)* window.innerHeight/10);
    height = (Math.random(0.1)* window.innerWidth/10) ;
    document.getElementById("noButton").style.left=width+"px";
    document.getElementById("noButton").style.top=height+"px";
    console.log(width);
    console.log(height);
}
