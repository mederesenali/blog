<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <h3 class="mb-3" style="text-align: center">Регистрация</h3>

    <div class="d-flex justify-content-center">
        <div class="mx-3">
            <form action="/registration" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <div>
                    <label class="flex flex-v-center ">
                        <span class="label-input-text">Имя:</span>
                        <input class="form-control mb-2"  name="name">
                    </label>
                </div>
                <div>
                    <label class="flex flex-v-center ">
                        <span class="label-input-text">Электронная почта:</span>
                        <input class="form-control mb-2" type="email" name="email">
                    </label>
                </div>
                <div>
                    <label class="flex flex-v-center label-input-text">
                        <span class="label-input-text">Пароль:</span>
                        <input  class="form-control mb-2" name="password">
                    </label>
                </div>
                <div>
                    <button class="btn btn-outline-primary btn-block"type="submit">Потвердить</button>
                </div>
            </form>
        </div>
    </div>
</@main.renderWith>
