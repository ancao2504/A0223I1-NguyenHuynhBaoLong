class Computer {
  constructor(id, name, companyName, cost) {
    this.id = id;
    this.name = name;
    this.companyName = companyName;
    this.cost = cost;
  }

  setId(value) {
    this.id = value;
  }

  getId() {
    return this.id;
  }

  setName(value) {
    this.name = value;
  }

  getName() {
    return this.name;
  }

  setCompanyName(value) {
    this.companyName = value;
  }

  getCompanyName() {
    return this.companyName;
  }

  setCost(value) {
    this.cost = value;
  }

  getCost() {
    return this.cost;
  }
}
let computer1 = new Computer("001", "Acer", "Aspire", 100);
let computer2 = new Computer("002", "Dell", "GAM", 150);
let computer3 = new Computer("003", "Mac", "Apple", 30);
let computerList = [computer1, computer2, computer3];
function display() {
  let temp = "<table>";
  temp +=
    "<th> Mã máy </th>" +
    "<th> Tên máy </th>" +
    "<th> Hãng sản xuất </th>" +
    "<th> Giá </th>";
  for (let i = 0; i < computerList.length; i++) {
    temp +=
      "<tr> <td>" +
      computerList[i].id +
      "</td>" +
      "<td>" +
      computerList[i].name +
      "</td>" +
      "<td>" +
      computerList[i].companyName +
      "</td>" +
      "<td>" +
      computerList[i].cost +
      "</td> </tr>";
  }
  temp += "</table>";
  document.getElementById("displayTable").innerHTML = temp;
}
function addComputer() {
  let id;
  do {
    id = prompt("Enter the id");
  } while (id < 0);
  let name = prompt("Enter name of computer");
  let companyName = prompt("Enter name of company");
  let cost = +prompt("Enter the price");
  let newComputer = new Computer(id, name, companyName, cost);
  computerList.push(newComputer);
  display();
}
function displayComputer() {
  for(let i =0;i<computerList.length;i++) {
    for(let j = computerList.length-1;j>0;j--) {
      if(computerList[j].cost <= computerList[i].cost) {
        let temp = computerList[j];
        computerList[j] = computerList[i];
        computerList[i] =temp;
      }
    }
  }
  let temp = "<table>";
  temp +=
    "<th> Mã máy </th>" +
    "<th> Tên máy </th>" +
    "<th> Hãng sản xuất </th>" +
    "<th> Giá </th>";
  for (let i = 0; i < computerList.length; i++) {
    temp +=
      "<tr> <td>" +
      computerList[i].id +
      "</td>" +
      "<td>" +
      computerList[i].name +
      "</td>" +
      "<td>" +
      computerList[i].companyName +
      "</td>" +
      "<td>" +
      computerList[i].cost +
      "</td> </tr>";
  }
  temp += "</table>";
  document.getElementById("displayTable").innerHTML = temp;
}

display();
