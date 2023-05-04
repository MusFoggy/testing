<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/static/js/admin.js"></script>
    <style>
        body {
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th,
        td {
            text-align: left;
            padding: 10px;
            border: 1px solid #CCCCCC;
        }

        th {
            background-color: #F2F2F2;
        }

        td a {
            display: inline-block;
            margin-right: 10px;
        }

        td form {
            display: inline-block;
            margin: 0;
        }

        td button {
            background-color: #FF4136;
            color: #FFFFFF;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        a.link {
            background-color: #0074D9;
            color: #FFFFFF;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
        }

        a.ajax-link:hover,
        td button:hover {
            opacity: 0.8;
        }

        a.ajax-link:active,
        td button:active {
            opacity: 0.6;
        }


    </style>
</head>
<body>
<h1>Tests</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Points</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#list tests as test>
        <tr>
            <td>${test.name!"Name not available"}</td>
            <td>${test.description!"Description not available"}</td>
            <td>${test.points!"Points not available"}</td>
            <td>
                <a class="ajax-link link" href="/tests/${test.id}/details">Details</a>
                <a class="ajax-link link" href="/tests/${test.id}/edit">Edit</a>
                <form method="post" action="/tests/${test.id}/delete">
                    <input type="hidden" name="_method" value="DELETE">
                    <button type="submit">Видалити категорію</button>
                </form>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
<a class="ajax-link" href="/tests/new">Create a new Test</a>
</body>

