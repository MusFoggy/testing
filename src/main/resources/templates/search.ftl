<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
    <#if searchResults??>
        <#list searchResults as result>
            <div class="col">
                <div class="card">
                    <a href="#" onclick="showConfirmationModal('${result.id}');">
                        <img src="${result.image}" class="card-img-top" alt="${result.name}">
                    </a>
                    <div class="card-body">
                        <h5 class="card-title">${result.name}</h5>
                        <p class="card-text">${result.description}</p>
                    </div>
                </div>
            </div>
        </#list>
    <#else>
        <p>Немає результатів для даного пошукового запиту.</p>
    </#if>




