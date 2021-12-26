function submitupdateFunction() {
    // Getting values
    let emp_id=document.getElementById("emp_id").value;
    let first_name = document.getElementById("first_name").value;
    let last_name = document.getElementById("last_name").value;
    let email = document.getElementById("email").value;
    let photo = document.getElementById("photo").value;

    let obj = {
        employee_id:emp_id,
        fname: first_name,
        lname: last_name,
        email: email,
        photograph_path: photo,
    };

    // Send to Backend
    fetch("http://localhost:8083/Academic_ERP_Employee_war_exploded/api/employee/add", {
        // Adding method type
        method: "POST",
        // Adding body or contents to send
        body: JSON.stringify(obj),
        // Adding headers to the request
        headers: {
            'Content-Type': 'application/json',
        }
    })

        // Displaying results to console
        .then((json) => {
            console.log(json)

            // Popup
            Swal.fire({
                title: 'Submitted!',
                text: 'Details has been updated',
                icon: 'success',
                confirmButtonText: 'Okay'
            })
        });


}