document.addEventListener('DOMContentLoaded', function() {
    var categoryList = document.getElementById('category-list');
    var items = categoryList.getElementsByClassName('list-group-item');
    var category1 = document.getElementById('category-1');
    var category2 = document.getElementById('category-2');

    function updateContent(category) {
        if (category === "1") {
            category1.style.display = "block";
            category2.style.display = "none";
        } else if (category === "2") {
            category1.style.display = "none";
            category2.style.display = "block";
        }
    }

    for (var i = 0; i < items.length; i++) {
        items[i].addEventListener('click', function() {
            var currentActiveItem = categoryList.getElementsByClassName('active')[0];
            currentActiveItem.classList.remove('active');
            this.classList.add('active');

            var selectedCategory = this.getAttribute('data-category');
            updateContent(selectedCategory);
        });
    }
});
