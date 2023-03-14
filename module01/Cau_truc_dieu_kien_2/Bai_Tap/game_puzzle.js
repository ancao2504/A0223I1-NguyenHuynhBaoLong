let cat_1=document.getElementById("img_1");
let cat_2=document.getElementById("img_2");
let cat_3=document.getElementById("img_3");
let cat_4=document.getElementById("img_4");
let cat_5=document.getElementById("img_5");

function setUp(numer) {
    switch(numer) { 
        case 1:
            if (cat_1.getAttribute("src")==="img\\cat_1.jpg") {
                src="img\\monkey_1.jpg";
            } else if (cat_1.getAttribute("src") === "img\\monkey_1.jpg") {
                src = "img\\panda_1.jpg";
            } else if (cat_1.getAttribute("src") === "img\\panda_1.jpg") {
                src = "img\\cat_1.jpg"
            }
            break;
        case 2:
            if (cat_2.getAttribute("src")==="img\\cat_2.jpg") {
                src="img\\monkey_2.jpg";
            } else if (cat_2.getAttribute("src") === "img\\monkey_2.jpg") {
                src = "img\\panda_2.jpg";
            } else if (cat_2.getAttribute("src") === "img\\panda_2.jpg") {
                src = "img\\cat_2.jpg"
            }
            break;
        case 3:
            if (cat_3.getAttribute("src")==="img\\cat_3.jpg") {
                src="img\\monkey_3.jpg";
            } else if (cat_3.getAttribute("src") === "img\\monkey_3.jpg") {
                src = "img\\panda_3.jpg";
            } else if (cat_3.getAttribute("src") === "img\\panda_3.jpg") {
                src = "img\\cat_3.jpg"
            }
            break;
         case 4:
            if (cat_4.getAttribute("src")==="img\\cat_4.jpg") {
                src="img\\monkey_4.jpg";
            } else if (cat_4.getAttribute("src") === "img\\monkey_4.jpg") {
                src = "img\\panda_4.jpg";
            } else if (cat_4.getAttribute("src") === "img\\panda_4.jpg") {
                src = "img\\cat_4.jpg"
            }
            break;
         case 5:
            if (cat_5.getAttribute("src")==="img\\cat_5.jpg") {
                src="img\\monkey_5.jpg";
            } else if (cat_5.getAttribute("src") === "img\\monkey_5.jpg") {
                src = "img\\panda_5.jpg";
            } else if (cat_5.getAttribute("src") === "img\\panda_5.jpg") {
                src = "img\\cat_5.jpg"
            }
            break;
    }   
}