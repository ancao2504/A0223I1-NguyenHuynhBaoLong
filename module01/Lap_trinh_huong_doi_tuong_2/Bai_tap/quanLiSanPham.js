class Product {
  constructor(name, price) {
    this.name = name;
    this.price = price;
  }
}

let item1 = new Product("Sony Xperia", 1500);
let item2 = new Product("Samsung Galaxy", 2500);

let list = [item1, item2];

function display() {
  let temp = '<table>'+
   '<tr> <th>STT</th> <th>Product Name</th> <th>Price</th> <th></th>';
  for (let i = 0; i < list.length; i++) {
    temp +=
      "<tr> <td>" +
      i +
      "</td>" +
      "<td>" +
      list[i].name +
      "</td>" +
      "<td>" +
      list[i].price +
      "</td>" +
      "<td> <button onclick='btnEdit("+i+")'>Edit</button> " +
      " <button onclick='btnDelete("+i+")'>Delete</button> </td>" +
      "</tr>";
  }
  temp += "</table>";
  document.getElementById("display").innerHTML=temp;
}

function addProduct() {
    let price = prompt("Enter the price");
    let nameProduct=document.getElementById("nameProduct").value;
    let newItem =new Product(nameProduct,price);
    list.push(newItem);
    display();
    document.getElementById("nameProduct").innerText="a";
}

function btnDelete(value) {
  console.log("==========",value);
  list.splice(value,1);
  display();
}

function btnEdit(value) {
  let name=prompt("Enter new name product",list[value].name);
  let price=prompt("Enter new price of product",list[value].price);
  list[value].name=name;
  list[value].price=price;
  display();
}

display();
