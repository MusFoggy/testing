<head>
    <meta charset="UTF-8">
    <title>Авторизація</title>
    <link rel="stylesheet" href="../static/css/loginreg.css">
</head>
    <section class="section-card">
        <div class="login-card">
            <div class="card-header">
                <div class="log">Авторизація</div>
            </div>
            <form>
                <div class="form-group">
                    <label for="username">Ім'я користувача:</label>
                    <input required="" name="username" id="username" type="text">
                </div>
                <div class="form-group">
                    <label for="password">Пароль:</label>
                    <input required="" name="password" id="password" type="password">
                </div>
                <div class="form-group">
                    <input value="Логін" type="submit">
                </div>
            </form>
            <form action="/registration">
                <div class="form-group">
                    <input href="/" value="Зареєструватися" type="submit">
                </div>
            </form>

        </div>
    </section>