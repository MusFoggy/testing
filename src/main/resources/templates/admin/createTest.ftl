<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/static/js/admin.js"></script>
    <link rel="stylesheet" href="/static/css/admin.css">
</head>
<body>
<h1>Створити новий тест</h1>
<form action="/tests" method="post">
    <label for="name">Назва:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="description">Опис:</label>
    <textarea id="description" name="description" required></textarea>
    <br>
    <label for="points">Бали:</label>
    <input type="number" id="points" name="points" required>
    <br>
    <label for="image">Зображення:</label>
    <input type="text" id="image" name="image">
    <br>
    <label for="category">Категорія:</label>
    <select id="category" name="category" required>
        <option value="" disabled selected>Оберіть категорію</option>
        <#list categories as category>
            <option value="${category.id}">${category.name}</option>
        </#list>
    </select>
    <br>
    <h2>Питання</h2>
    <input type="hidden" id="questions-data" name="questions" required>
    <div id="questions-container">
        <div class="question-field">
            <label for="questions[0]">Питання 1:</label>
            <input type="text" id="questions[0]" name="questions[0]" required>
        </div>
    </div>
    <button id="add-question">Додати питання</button>
    <input type="submit" value="Створити тест">
</form>
<a href="/admin">Повернутись до списку тестів</a>
</body>
