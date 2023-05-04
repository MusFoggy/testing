function showConfirmationModal(id) {
    let confirmationModal = document.getElementById('confirmationModal');
    confirmationModal.setAttribute('data-category-id', id);
    confirmationModal.style.display = 'block';

    let confirmYesBtn = document.getElementById('confirmYesBtn');
    confirmYesBtn.setAttribute('href', '/tests/category/' + id);

}

function closeConfirmationModal() {
    let confirmationModal = document.getElementById('confirmationModal');
    confirmationModal.style.display = 'none';
}


