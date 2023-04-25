<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <!-- Додайте ваші стилі та скрипти -->
</head>

<body>
<h1>Admin Panel</h1>

<h2>Додати категорію</h2>
<form method="post" action="/category/add">
    <label for="name">Назва:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="description">Опис:</label>
    <textarea id="description" name="description" required></textarea>
    <br>
    <label for="image">Зображення (URL):</label>
    <input type="text" id="image" name="image" required>
    <br>
    <button type="submit">Додати категорію</button>
</form>

<h2>Оновити категорію</h2>
<form method="post" action="/category/update">
    <label for="name">Назва категорії:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="description">Опис:</label>
    <textarea id="description" name="description" required></textarea>
    <br>
    <label for="image">Зображення (URL):</label>
    <input type="text" id="image" name="image" required>
    <br>
    <#if updateResult??>
        <div class="alert alert-success">${updateResult}</div>
    </#if>
    <button type="submit">Оновити категорію</button>
</form>

<h2>Видалити категорію</h2>
<form method="post" action="/category/delete">
    <label for="name">Назва категорії:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <#if deleteResult??>
        <div class="alert alert-success">${deleteResult}</div>
    </#if>
    <button type="submit">Видалити категорію</button>
</form>




</body>

</html>
