<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/static/js/admin.js"></script>
    <style> body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        h1 {
            margin-bottom: 20px;
        }

        form {
            margin-bottom: 20px;
        }

        form label {
            display: block;
            margin-bottom: 5px;
        }

        form input[type="text"],
        form input[type="number"],
        form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #CCCCCC;
            box-sizing: border-box;
        }

        form input[type="submit"] {
            background-color: #4CAF50;
            color: #FFFFFF;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        #questions-container {
            margin-top: 20px;
        }

        .question-field {
            margin-bottom: 10px;
        }

    </style>
</head>
<body>
<h1>Edit Test</h1>
<form method="post" action="/tests/${test.id}/update">
    <input type="hidden" name="id" value="${test.id}">
    <label>Name: <input type="text" name="name" value="${test.name}"></label><br>
    <label>Description: <input type="text" name="description" value="${test.description}"></label><br>
    <label>Points: <input type="number" name="points" value="${test.points}"></label><br>
    <label>Image: <input type="text" name="image" value="${test.image}"></label><br>
    <label>Category:
        <select name="category" required>
            <option value="" disabled>Select a category</option>
            <#list categories as category>
                <option value="${category.id}"
                        <#if test.category?? && test.category.id == category.id>selected</#if>>${category.name}</option>
            </#list>
        </select>
    </label><br>
    <#if !test.category??>
        <p style="color: red;">Увага: Категорія відсутня для цього тесту.</p>
    </#if>
    <h2>Questions</h2>
    <input type="hidden" id="questions-data" name="questions" required>
    <div id="questions-container">
        <#list test.questions as question>
            <div class="question-field">
                <label for="questions[${question_index}]">Question ${question_index + 1}:</label>
                <input type="text" id="questions[${question_index}]" name="questions[${question_index}]" value="${question}" required>
            </div>
        </#list>
    </div>
    <button id="add-question">Add Question</button>
    <button type="submit">Save</button>
</form>
<a href="/admin">Back to Tests</a>
</body>

