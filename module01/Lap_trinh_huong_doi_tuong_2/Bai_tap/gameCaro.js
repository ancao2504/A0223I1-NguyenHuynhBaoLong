let boardCaro = new Array();
let isChecked=true;
function init() {
  for (let i = 0; i < 10; i++) {
    boardCaro[i] = new Array();
    for (let j = 0; j < 10; j++) {
      boardCaro[i][j] = "";
    }
  }
}
function display() {
  let temp = "<table  border='1' cellpadding='10' >";
  for (let i = 0; i < 10; i++) {
    temp += "<tr>";
    for (let j = 0; j < 10; j++) {
        temp += "<td style='width: 40px; height: 40px; box-sizing: border-box;' onclick='change("+i+","+j+")'>" + boardCaro[i][j] + "</td>";
    }
    temp += "</tr>";
  }
  temp += "</table>";
  document.write(temp);
}
function change(x,y) {
    if (isChecked) {
        boardCaro[x][y] = "x";
        isChecked=false;
        isWinner('x');
    } else {
        boardCaro[x][y]="o";
        isChecked=true;
        isWinner('o');
    }
    document.body.innerHTML="";
    display();
}
function isWinner(temp) {
    for (let i = 0;i < 5;i++) {
        for (let j = 0;j < 5;j++) {
            if (temp == boardCaro[i][j] && temp == boardCaro[i][j+1] && temp == boardCaro[i][j+2] ||
                temp == boardCaro[i][j] && temp == boardCaro[i+1][j] && temp == boardCaro[i+2][j] ||
                temp == boardCaro[i][j] && temp == boardCaro[i+1][j+1] && temp == boardCaro[i+2][j+2] ||
                i>=3 && temp == boardCaro[i][j] && temp == boardCaro[i-1][j+1] && temp == boardCaro[i-2][j+2] ) {
                    alert(temp+" Winner");
                }
            }
            }
        }
init();
display();
