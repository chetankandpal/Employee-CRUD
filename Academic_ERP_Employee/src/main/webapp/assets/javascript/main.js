function submitFunction() {
    // Getting values
    let first_name = document.getElementById("first_name").value;
    let last_name = document.getElementById("last_name").value;
    let email = document.getElementById("email").value;
    let title = document.getElementById("title").value;
    let department = document.getElementById("department").value;
    let photo = document.getElementById("photo").value;

    let obj = {
        fname: first_name,
        lname: last_name,
        email: email,
        title: title,
        photograph_path: photo,
        department: {
            department_id:department
        }
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
                text: 'Details has been submitted',
                icon: 'success',
                confirmButtonText: 'Okay'
            })
        });


}