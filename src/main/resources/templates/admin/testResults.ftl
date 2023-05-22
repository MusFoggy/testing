<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Результати тесту</title>
</head>
<body>
<h1>Результати тесту</h1>
<#if userAnswers??>
    <#assign currentUser = "">
    <#assign currentTest = "">
    <#list userAnswers as answer>
        <#if answer.user.username != currentUser || answer.test.name != currentTest>
            <#assign currentUser = answer.user.username>
            <#assign currentTest = answer.test.name>
            <#if currentUser??>
                <form method="post" action="/tests/deleteUserAnswers">
                    <input type="hidden" name="username" value="${currentUser}">
                    <input type="hidden" name="testName" value="${currentTest}">
                    <button type="submit">Видалити результати за цим користувачем</button>
                </form>
                </div>
            </#if>
            <div style="border: 1px solid black; padding: 10px; margin-bottom: 10px;">
            <p>Користувач: ${currentUser}</p>
            <p>Тест: ${currentTest}</p>
            <ul>
        </#if>
        <li>
            <p>Питання: ${answer.question.text}</p>
            <p>Відповідь: ${answer.answer}</p>
        </li>
        <#if answer?is_last>
            </ul>
            </div>
        </#if>
    </#list>
    <#if currentUser??>
        <form method="post" action="/tests/deleteUserAnswers">
            <input type="hidden" name="username" value="${currentUser}">
            <input type="hidden" name="testName" value="${currentTest}">
            <button type="submit">Видалити результати за цим користувачем</button>
        </form>
        </div>
    </#if>
<#else>
    <p>Інформація про відповіді відсутня.</p>
</#if>
</body>
</html>
