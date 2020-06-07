<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/home">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">



            </ul>

        </div>
    </nav>


    <form action="/createPost" method="post" id="postform">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group">
            <label class="flex flex-v-center ">
                <span class="label-input-text">Title:</span>
                <input class="form-control mb-2" type="text" name="title">
            </label>
        </div>
        <div class="form-group">
            <label for="exampleTextarea">Content</label>
            <textarea class="form-control" id="exampleTextarea" name="post" rows="3"></textarea>
        </div>
        <div>
            <button class="btn btn-outline-primary btn-block" type="submit">Post!</button>
        </div>

    </form>




</@main.renderWith>