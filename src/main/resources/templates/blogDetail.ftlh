<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/home">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">




            </ul>

        </div>
    </nav>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Author:${blog.author.name}</h5>
            <h6 class="card-title">Title:${blog.title}</h6>
            <p class="card-text">Content:${blog.content}</p>
            <form action="/createComment" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>

               <input type="hidden" name="blogId" value="${blog.id}">
                <div class="form-group">
                    <label for="exampleTextarea">Leave comment:</label>
                    <textarea class="form-control" id="exampleTextarea" name="comment" rows="3"></textarea>
                </div>
                <div>
                    <button class="btn btn-outline-primary btn-block" type="submit">submit</button>
                </div>
            </form>
        </div>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">comment</th>
            <th scope="col">author</th>
            <th scope="col">date</th>
        </tr>
        </thead>

        <tbody>
        <#list comments as c>
            <tr>

                <td>${c.comment}</td>
                <td>${c.blogger.name}</td>
                <td>${c.localDate}</td>

            </tr>

        </#list>
        </tbody>

    </table>




</@main.renderWith>