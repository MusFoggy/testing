<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test Details</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            width: 50%;
            margin: auto;
        }
        .row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 5px 0;
            border-bottom: 1px solid #ccc;
        }
        .row:last-child {
            border-bottom: none;
        }
        h1, h2 {
            text-align: center;
        }
        ul {
            padding-left: 20px;
        }
    </style>
</head>
<body>
<h1>Test Details</h1>
<div class="container">
    <div class="row">
        <strong>Name:</strong>
        <span>${test.name}</span>
    </div>
    <div class="row">
        <strong>Description:</strong>
        <span>${test.description}</span>
    </div>
    <div class="row">
        <strong>Points:</strong>
        <span>${test.points}</span>
    </div>
    <div class="row">
        <strong>Image:</strong>
        <span>${test.image}</span>
    </div>
    <div class="row">
        <strong>Category:</strong>
        <span>${test.category}</span>
    </div>
    <h2>Questions</h2>
    <ul>
        <#list test.questions as question>
            <li>${question.text}</li>
        </#list>
    </ul>
</div>
<a href="/admin">Back to Tests</a>
</body>
</html>

