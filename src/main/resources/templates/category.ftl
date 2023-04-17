<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2>Category</h2>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

    <div class="row row-cols-2 row-cols-md-2 g-4">

        <#if allCategory??>
            <#list allCategory as category>
                <div class="col">
                    <div class="card">
                        <a href="/category/${category.id}">
                            <img src="${category.image}" class="card-img-top" alt="${category.name}">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title">${category.name}</h5>
                            <p class="card-text">${category.description}</p>
                        </div>
                    </div>
                </div>
            </#list>
        </#if>

    </div>
</@p.pages>