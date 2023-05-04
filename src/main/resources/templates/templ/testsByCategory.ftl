<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tests by Category</title>
    <style>
        .container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
        }
        .card {
            display: flex;
            flex-direction: column;
            width: 350px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
        }
        .card-img-top {
            width: 100%;
            height: auto;
        }
        .card-body {
            display: flex;
            flex-direction: column;
            gap: 5px;
        }
        .card-title {
            font-size: 18px;
            font-weight: bold;
        }
        .card-text {
            font-size: 14px;
        }
    </style>
</head>
<body>
<h1>Tests for Category: ${categoryName}</h1>
<div class="container">
    <#list tests as test>
        <div class="card">
            <img src="${test.image}" class="card-img-top" alt="${test.name}">
            <div class="card-body">
                <h5 class="card-title">
                    <a href="/tests/${test.id}/start">${test.name}</a>
                </h5>
                <p class="card-text">${test.description}</p>
                <p class="card-points"><strong>Points:</strong> ${test.points}</p>
            </div>
        </div>
    </#list>
</div>
</body>
</html>

