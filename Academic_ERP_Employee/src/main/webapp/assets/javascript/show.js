var table=document.createElement("table");
var thead=document.createElement("thead");
var tbody=document.createElement("tbody");

table.appendChild(thead);
table.appendChild(tbody);
table.offsetWidth=10;
table.offsetHeight=10;
table.offsetLeft=10;
table.cellPadding="10";
table.border="2";
var row1=document.createElement("tr");
var heading1=document.createElement("th");
heading1.innerHTML="Employee id";
var heading2=document.createElement("th");
heading2.innerHTML="Email";
var heading3=document.createElement("th");
heading3.innerHTML="First Name";
var heading4=document.createElement("th");
heading4.innerHTML="Last Name";
var heading5=document.createElement("th");
heading5.innerHTML="Title";
var heading6=document.createElement("th");
heading6.innerHTML="Department id";
var heading7=document.createElement("th");
heading7.innerHTML="Department Name";
var heading8=document.createElement("th");
heading8.innerHTML="Salary";
var heading9=document.createElement("th");
heading9.innerHTML="Photo";
row1.appendChild(heading1);
row1.appendChild(heading2);
row1.appendChild(heading3);
row1.appendChild(heading4);
row1.appendChild(heading5);
row1.appendChild(heading6);
row1.appendChild(heading7);
row1.appendChild(heading8);
row1.appendChild(heading9);
thead.appendChild(row1);

async function showFunction() {
    // Getting values
    let emp_id = document.getElementById("emp_id").value;


    let obj = {
        employee_id: emp_id
    };

    // Send to Backend
    let response = await fetch("http://localhost:8083/Academic_ERP_Employee_war_exploded/api/employee/show", {
        // Adding method type
        method: "POST",
        // Adding body or contents to send
        body: JSON.stringify(obj),
        // Adding headers to the request
        headers: {
            'Content-Type': 'application/json',
        }
    });

    // Displaying results to console
    let result = response;
    console.log(response);
    if (result["status"] === 200) {
        let data = await result.json();
        createTable(data);
    }


}

function createTable(data){


    document.getElementById("table_holder").appendChild(table);


    //Row data insertion
    var row1=document.createElement("tr");
    var data1=document.createElement("td");
    data1.innerHTML=data[0]['employee_id'];
    var data2=document.createElement("td");
    data2.innerHTML=data[0]['email'];
    var data3=document.createElement("td");
    data3.innerHTML=data[0]['fname'];
    var data4=document.createElement("td");
    data4.innerHTML=data[0]['lname'];
    var data5=document.createElement("td");
    data5.innerHTML=data[0]['title'];
    var data6=document.createElement("td");
    data6.innerHTML=data[0]['department']['department_id'];
    var data7=document.createElement("td");
    data7.innerHTML=data[0]['department']['department_name'];
    var data8=document.createElement("td");
    data8.innerHTML=data[0]['empsal']['amount'];
    var data9=document.createElement("td");
    data9.innerHTML=data[0]['photograph_path'];
    var a=document.createElement('a');
    var link=document.createTextNode("Photo link");
    a.appendChild(link);
    a.title="Photo Link";
    a.href=data9.innerHTML;


   row1.appendChild(data1);row1.appendChild(data2);row1.appendChild(data3);row1.appendChild(data4);row1.appendChild(data5);row1.appendChild(data6);
   row1.appendChild(data7);row1.appendChild(data8);row1.appendChild(a);
   tbody.appendChild(row1);

}