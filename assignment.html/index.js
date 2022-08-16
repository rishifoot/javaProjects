const LOCAL_RECORDS = "LOCAL_RECORDS";
const clearButton = document.getElementById("clearBtn");
const enrollmentForm = document.getElementById("enrollment-form");
const enrollmentRecords = document.getElementById("enrollment-records");

// Function to fetch records
const getStoredRecords = () =>{
    return localStorage.getItem(LOCAL_RECORDS);
}

// Function to store records
const storeRecords = (data) =>{
    const PrevRecords = getStoredRecords();
    arr = PrevRecords ? JSON.parse(PrevRecords) : []
    arr.push(data);
    localStorage.setItem(LOCAL_RECORDS, JSON.stringify(arr));
}

// Function to display record
const displayRecords = (data) =>{
    const td1 = enrollmentRecords;
    td1.innerHTML += data;
}

//function to remove all user data
const deleteData = () => {
    localStorage.clear();
    window.location.reload();
    clearButton.style.display = 'none';
}

// Creating data and storing it
const dataSumbit = (e) => {
    // Preventing from refreshing
    e.preventDefault();

    var formInput = enrollmentForm;
    var name = formInput.name.value;
    var email = formInput.email.value;
    var gender = formInput.gender.value;
    var website = formInput.website.value;
    var imageLink = formInput.imageLink.value;
    var skills = [];
    if (document.getElementById("java").checked) {
        skills.push("Java")
    }
    if (document.getElementById("html").checked) {
        skills.push("HTML")
    }
    if (document.getElementById("css").checked) {
        skills.push("CSS")
    }

    const rec = {name, email, gender, website, imageLink, skills}
    //Adding new enrollment
    addNewEnrollment(rec);

    //  Displaying delete button
    clearButton.style.display = 'block';

    //Resseting the form
    e.target.reset();
}

// Adding new enrollment data
const addNewEnrollment = (rec) =>{
    const {name, email, gender, website, imageLink, skills} = rec;
    newData =
        `
        <tr class="record">
          <td class="border-end">
                <div>
                    <p class="m-0"><b>${name}</b></p>
                    <p class="m-0">${email}</p>
                    <a class="m-0" target="_blank" href=${website}>
                        Website
                    </a>
                    <p class="m-0">${gender}</p>
                    <p>${skills.join(", ")}</p>
                </div>
          </td>
          <td>
                <div class="h-100 w-100">
                    <img
                        src=${imageLink}
                        class="img-fluid w-100 h-100 border rounded"
                        alt="image"
                    />
                </div>
            </td>
        </tr>
    `.trim();

    // saving data to local storage
    storeRecords(newData);
    // showRecords();
    displayRecords(newData);
}

// Lets display the previous data if present
const displayData = () =>{
    clearButton.style.display = 'none';
   let PrevRecords = getStoredRecords();
    arr = PrevRecords ? JSON.parse(PrevRecords) : []
    arr.forEach((rec) => displayRecords(rec));
 }

displayData();

