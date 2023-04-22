<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реєстрація</title>
    <link rel="stylesheet" href="../static/css/loginreg.css">
</head>
<body>
<section class="section-card">
    <div class="login-card">
        <div class="card-header">
            <div class="log">Реєстрація</div>
        </div>
        <form action="/registration" method="post">
            <div class="form-group">
                <label for="username">Ім'я користувача:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="name">Ім'я:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="surname">Прізвище:</label>
                <input type="text" id="surname" name="surname" required>
            </div>
            <div class="form-group">
                <label for="email">Електронна пошта:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <button type="submit">Зареєструватися</button>
            </div>
        </form>
        <!-- Display error message if present -->
        <#if error??>
            <p>${error}</p>
        </#if>
    </div>
</section>
</body>
</html>
