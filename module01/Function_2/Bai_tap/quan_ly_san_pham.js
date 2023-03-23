let list =["Sony Xperia","Samsung Galaxy","Nokia 6","Xiaomi Redmi Note 4","Apple iphone 6S","Xiaomi Mi 5s Plus","Apple iphone 8 Plus","Fujitsu F-04E","Oppo A71"]

function addProduct() {
    let input=document.getElementById("newProduct").value;
    list.push(input);
    console.log(list.length);
    document.getElementById("newProduct").value="";
    display();
    
};
function deleteProduct(index) {
    console.log('=======index========', index);
    list.splice(index, 1)
    display();
}
function editProduct(index) {
    let new_name=prompt("New name of product","");
    list[index]=new_name;
    display();
}
function display() {
    let temp="<table>";
    for (let i = -1;i < list.length;i++) {
        let count=i+1;
        if (i == -1) {
            temp+="<tr>"+"<th></th> <th>Produc Name</th> <th>" +list.length+ ' product'+"</th>";
        } else {
            temp+="<tr>" +"<th>" +count+"</th>"  + "<td>" + list[i] +"</td>" +"<td> <button id='edit' onclick='editProduct("+i+")'>Edit</button> "+" <button id='deltele' onclick='deleteProduct("+i+")'>Deltele</button></td>"
        }    
    }
    temp+="</table>";
    document.getElementById("form_list").innerHTML=temp;
}

display();

