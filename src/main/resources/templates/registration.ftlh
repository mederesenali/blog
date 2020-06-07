<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <h2 class="h2_for_css">Войдите</h2>
    <div class="d-flex justify-content-center">
        <div class="mx-3">
            <form action="/registration" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <div class="form-group">
                    <label class="flex flex-v-center ">
                        <span class="label-input-text">Name:</span>
                        <input class="form-control mb-2" type="text" name="name">
                    </label>
                </div>
                <div class="form-group">
                    <label class="flex flex-v-center ">
                        <span class="label-input-text">Email:</span>
                        <input class="form-control mb-2" type="email" name="email">
                    </label>
                </div>
                <div class="form-group">
                    <label class="flex flex-v-center ">
                        <span class="label-input-text">Password:</span>
                        <input class="form-control mb-2" type="password" name="password">
                    </label>
                </div>
                <div>
                    <button class="btn btn-outline-primary btn-block" type="submit">Register</button>
                </div>
            </form>
            <div>
                <button class="btn btn-outline-primary btn-block" onclick="location.href='/login'">Registration</button>
            </div>
        </div>
    </div>
</@main.renderWith>
