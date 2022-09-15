/**
 * Extract form field values and pur into Object
 * @param {HTMLFormElement} form 
 * @returns Object
 */
function extractData(form) {
    let data = {}
    for (i of form.elements) {
        if (!["submit", "reset"].includes(i.getAttribute("type")))
            data[i.name]=i.value;
    }
    return data;
}

/**
 * Send form data to url
 * @param {String} method 
 * @param {String} url 
 * @param {Object} data 
 */
function sendFormData(method, url, data) {
    let req = new XMLHttpRequest();
    req.open(method, url + Object.values(data).join("/"));
    req.setRequestHeader("Content-Type", "application/json");
    req.onload = () => {
        if (req.status === 200) {
            location.reload();
        } else {
            console.log(req.status, req.responseText);
        }
    };
    req.send();
}

/**
 * Perform various steps related to form submission
 * @param {SubmitEvent} event 
 * @param {HTMLFormElement} form 
 */
function processForm(event, form) {
    event.preventDefault();
    console.log(form.getAttribute("method"));
    console.log(form.action);
    console.log(extractData(form));
    sendFormData(form.getAttribute("method"), form.action, extractData(form));
}

/**
 * Collection of forms to watch
 */
const forms = [document.forms["editBookForm"], document.forms["deleteBookForm"]];
forms.forEach(f => f.addEventListener("submit", (e) => {processForm(e, f)}));