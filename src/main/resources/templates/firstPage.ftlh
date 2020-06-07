<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/createPost">Create Post</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>





        <ul class="nav navbar-nav ml-auto w-100 justify-content-end">
            <li class="nav-item">
                <a class="nav-link " href="/login">Login</a>

            </li>
            <li class="nav-item">
                <a class="nav-link border border-success" href="/registration">Register</a>
            </li>

        </ul>
    </nav>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">title</th>
            <th scope="col">content</th>
            <th scope="col">date</th>
            <th scope="col">author</th>
        </tr>
        </thead>

        <tbody>
        <#list blog as b>
            <tr  onclick="window.location='/blogDetail/${b.id}'" class="pointer">
                <th scope="row">${b.id}</th>
                <td>${b.title}</td>
                <td>${b.content}</td>
                <td>${b.localDate}</td>
                <td>${b.author.name}</td>
            </tr>

        </#list>
        </tbody>

    </table>

</@main.renderWith>