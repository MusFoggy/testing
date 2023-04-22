<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/css/home.css">
    <link rel="stylesheet" href="../static/css/all.css.css">
</head>
<body class="body">
<div class="row align-items-end">
    <div class="col">
        <#include "templ/header.ftl">
    </div>
</div>
<section class="container">
    <h1>${hello}</h1>
    <a href="/category">Go</a>
    <div>
        <#if (session.getAttribute("user"))??>
            <span>Привіт, ${(session.getAttribute("user")).username}!</span>
            <a href="/logout">Вийти</a>
        <#else>
            <a href="/login">Увійти</a>
        </#if>
    </div>

</section>
<section class="container">
    <div class="item-alls">
        <article class="items">
            <div class="item-boxs">
                <a href="#" class="aaas3">
                    <img src="../static/image/31.svg" alt="">
                </a>
                <div class="p">
                    <div сlass="p13">Penalty for the Good Corporation: what will happen to Google and others for violating the GDPR</div>
                    <p class="p23">September 29</p>
                    <p class="p33">And why the recovery of 50 million euros could be a fateful precedent According to Mind.ua January 21 National Commission for Data Protection.</p>
                </div>
            </div>
        </article>
        <article class="items">
            <div class="item-boxs">
                <a href="#" class="aaas3">
                    <img src="../static/image/32.svg" alt="">
                </a>
                <div class="p">
                    <div сlass="p13">Penalty for the Good Corporation: what will happen to Google and others for violating the GDPR</div>
                    <p class="p23">September 29</p>
                    <p class="p33">And why the recovery of 50 million euros could be a fateful precedent According to Mind.ua January 21 National Commission for Data Protection.</p>
                </div>
            </div>
        </article>
        <article class="items1">
            <div class="item-boxs">
                <a href="#" class="aaas3">
                    <img src="../static/image/33.jpg" alt="">
                </a>
                <div class="p">
                    <div сlass="p13">Millennial Testament</div>
                    <p class="p23">August 19</p>
                    <p class="p33">What and how modern vloggers, opinion leaders and crypto-millionaires will inherit A typical legacy of the Ukrainian generation X looks like this: an apartment in…</p>
                </div>
            </div>
        </article>
    </div>
</section>
<div class="row align-items-end">
    <div class="col">
        <#include "templ/footer.ftl">
    </div>
</div>
</body>
</html>