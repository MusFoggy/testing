<!DOCTYPE html>
<html>
<head>
    <title>Test Page</title>
</head>
<body>
<#if test??>
    <h1>${test.name}</h1>
</#if>
<form action="/tests/${test.id}/submit" method="POST">
    <#list questions as question>
        <div>
            <p>${question_index + 1}. ${question.text}</p>
            <input type="hidden" name="questionIndex" value="${question_index}">
            <label for="answer_${question_index}">Ваша відповідь:</label>
            <textarea id="answer_${question_index}" name="answers[]"></textarea>
        </div>
    </#list>
    <button type="submit">Відправити відповіді</button>
</form>
</body>
</html>
