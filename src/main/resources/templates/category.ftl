<#import "templ/templ.ftl" as p>

<@p.pages>
    <body>

    <h2>Category</h2>
    <div id="category-1" class="category-content">
        <div class="row row-cols-2 row-cols-md-2 g-4">
            <#if showSearchResults>
                <#include "search.ftl">
            <#else>
                <#if allCategory??>
                    <#list allCategory as category>
                        <div class="col">
                            <div class="card">
                                <a href="#" onclick="showConfirmationModal('${category.id}');">
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
            </#if>
        </div>
    </div>
    <div id="category-2" class="category-content" style="display: none;">
        <div class="row row-cols-2 row-cols-md-2 g-4">
            <p>Немає результатів для даного пошукового запиту.</p>
        </div>
    </div>
    <div id="confirmationModal" style="display: none; position: fixed; z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0,0,0,0.4);">
        <div style="background-color: #fefefe; margin: 15% auto; padding: 20px; border: 1px solid #888; width: 50%;">
            <h4>Ви справді хочете пройти цей тест?</h4>
            <div style="display: flex; justify-content: space-between;">
                <button type="button" onclick="closeConfirmationModal();" style="background-color: #f44336; color: white; padding: 8px 16px; border-radius: 4px;">Ні</button>
                <a id="confirmYesBtn" href="#" style="background-color: #4CAF50; color: white; padding: 8px 16px; text-decoration: none; border-radius: 4px;">Так</a>
            </div>
        </div>
    </div>
    <script src="../static/js/modalwindowTest.js"></script>
    <script src="../static/js/leftmenu.js"></script>
    </body>


</@p.pages>