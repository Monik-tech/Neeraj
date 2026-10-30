const API_URL = "/students";


// =================================
// LOAD ALL STUDENTS
// =================================

async function loadStudents() {

    try {

        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Failed to fetch students");
        }

        const students = await response.json();

        displayStudents(students);

    } catch (error) {

        console.error(error);

        alert("Unable to load students");
    }
}


// =================================
// DISPLAY STUDENTS
// =================================

function displayStudents(students) {

    const tableBody =
        document.getElementById("studentTableBody");

    tableBody.innerHTML = "";

    if (students.length === 0) {

        tableBody.innerHTML = `
            <tr>
                <td colspan="6">
                    No students found
                </td>
            </tr>
        `;

        return;
    }


    students.forEach(student => {

        const row = document.createElement("tr");

        row.innerHTML = `

            <td>${student.id}</td>

            <td>${student.name}</td>

            <td>${student.email}</td>

            <td>${student.course}</td>

            <td>${student.age}</td>

            <td>

                <button
                    class="btn-edit"
                    onclick="editStudent(${student.id})"
                >
                    Edit
                </button>

                <button
                    class="btn-delete"
                    onclick="deleteStudent(${student.id})"
                >
                    Delete
                </button>

            </td>
        `;

        tableBody.appendChild(row);

    });
}


// =================================
// ADD STUDENT
// =================================

document
    .getElementById("studentForm")
    .addEventListener("submit", async function(event) {

        event.preventDefault();

        const studentId =
            document.getElementById("studentId").value;

        const student = {

            name:
                document.getElementById("name").value,

            email:
                document.getElementById("email").value,

            course:
                document.getElementById("course").value,

            age:
                Number(
                    document.getElementById("age").value
                )
        };


        try {

            let response;

            // UPDATE
            if (studentId) {

                response = await fetch(
                    `${API_URL}/${studentId}`,
                    {
                        method: "PUT",

                        headers: {
                            "Content-Type":
                                "application/json"
                        },

                        body: JSON.stringify(student)
                    }
                );

            }

            // CREATE
            else {

                response = await fetch(
                    API_URL,
                    {
                        method: "POST",

                        headers: {
                            "Content-Type":
                                "application/json"
                        },

                        body: JSON.stringify(student)
                    }
                );

            }


            if (!response.ok) {

                throw new Error(
                    "Operation failed"
                );

            }


            alert(
                studentId
                    ? "Student updated successfully!"
                    : "Student added successfully!"
            );


            resetForm();

            loadStudents();


        } catch (error) {

            console.error(error);

            alert("Something went wrong");

        }

    });


// =================================
// EDIT STUDENT
// =================================

async function editStudent(id) {

    try {

        const response =
            await fetch(`${API_URL}/${id}`);

        if (!response.ok) {

            throw new Error(
                "Student not found"
            );

        }

        const student =
            await response.json();


        document.getElementById("studentId")
            .value = student.id;

        document.getElementById("name")
            .value = student.name;

        document.getElementById("email")
            .value = student.email;

        document.getElementById("course")
            .value = student.course;

        document.getElementById("age")
            .value = student.age;


        document.getElementById("formTitle")
            .innerText = "Update Student";


        document.getElementById("cancelBtn")
            .style.display = "inline-block";


        window.scrollTo({
            top: 0,
            behavior: "smooth"
        });


    } catch (error) {

        console.error(error);

        alert("Unable to load student");

    }
}


// =================================
// DELETE STUDENT
// =================================

async function deleteStudent(id) {

    const confirmDelete =
        confirm(
            "Are you sure you want to delete this student?"
        );

    if (!confirmDelete) {
        return;
    }


    try {

        const response =
            await fetch(
                `${API_URL}/${id}`,
                {
                    method: "DELETE"
                }
            );


        if (!response.ok) {

            throw new Error(
                "Delete failed"
            );

        }


        alert(
            "Student deleted successfully!"
        );


        loadStudents();


    } catch (error) {

        console.error(error);

        alert("Unable to delete student");

    }
}


// =================================
// SEARCH STUDENT
// =================================

async function searchStudent() {

    const id =
        document.getElementById("searchId").value;


    if (!id) {

        alert("Please enter student ID");

        return;
    }


    try {

        const response =
            await fetch(`${API_URL}/${id}`);


        if (response.status === 404) {

            alert("Student not found");

            return;
        }


        if (!response.ok) {

            throw new Error(
                "Search failed"
            );

        }


        const student =
            await response.json();


        displayStudents([student]);


    } catch (error) {

        console.error(error);

        alert("Unable to search student");

    }
}


// =================================
// RESET FORM
// =================================

function resetForm() {

    document
        .getElementById("studentForm")
        .reset();


    document
        .getElementById("studentId")
        .value = "";


    document
        .getElementById("formTitle")
        .innerText = "Add Student";


    document
        .getElementById("cancelBtn")
        .style.display = "none";
}


// =================================
// LOAD STUDENTS WHEN PAGE OPENS
// =================================

loadStudents();