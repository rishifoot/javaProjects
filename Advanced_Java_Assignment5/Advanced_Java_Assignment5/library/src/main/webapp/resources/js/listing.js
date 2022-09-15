/**
 * Toggle view for Add Book Form
 */
const addBookForm = document.querySelector("#addForm");
function showAddBookForm() {
    addBookForm.classList.toggle("show-pop-up");
}
document.querySelector("#addBook").addEventListener("click", showAddBookForm);
document.querySelector("#hideAddForm").addEventListener("click", showAddBookForm);

/**
 * Toggle view for Edit Book Form
 */
const editForm = document.querySelector("#editForm");
const fixBookId = editForm.querySelector("#id");
function showEditForm() {
    editForm.classList.toggle("show-pop-up");
    fixBookId.setAttribute("value", this.dataset.id);
}
function hideEditForm() {
   editForm.classList.toggle("show-pop-up");
}
document.querySelectorAll("#editBtn").forEach(e => e.addEventListener("click", showEditForm));
editForm.querySelector("#hideEditForm").addEventListener("click", hideEditForm);

/**
* Toggle view for Delete Book Form
*/
const deleteForm = document.querySelector("#deleteForm");
const fixBookId2 = deleteForm.querySelector("#id");
function showDeleteForm() {
    deleteForm.classList.toggle("show-pop-up");
    fixBookId2.setAttribute("value", this.dataset.id);
}
function hideDeleteForm() {
    deleteForm.classList.toggle("show-pop-up");
}
document.querySelectorAll("#deleteBtn").forEach(e => e.addEventListener("click", showDeleteForm));
deleteForm.querySelector("#hideDeleteForm").addEventListener("click", hideDeleteForm);