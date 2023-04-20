function showConfirmationModal(categoryId) {
    let confirmationModal = document.getElementById('confirmationModal');
    confirmationModal.setAttribute('data-category-id', categoryId);
    confirmationModal.style.display = 'block';

    let confirmYesBtn = document.getElementById('confirmYesBtn');
    confirmYesBtn.setAttribute('href', '/' //+ categoryId
    );
}

function closeConfirmationModal() {
    let confirmationModal = document.getElementById('confirmationModal');
    confirmationModal.style.display = 'none';
}
