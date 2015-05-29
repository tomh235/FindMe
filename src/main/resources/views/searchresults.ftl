<#assign resultsCount = persons?size>
<div class="container">
    <#if !persons?has_content>
            <div class="col-md-8 col-md-offset-2">
                <h1 class="no-results search"><img src="/assets/images/smiley_sad.png" height="55" />No results found!</h1>
            </div>
        </div>
    <#else>
        <div>
            <h3 class="results-counter">There were ${resultsCount} matching results</h3>
        </div>
        <#if persons?has_content>
            <!---<div>
                <ul class="nav nav-tabs nav-justified">
                    <li><a id="people" href="/">People</a></li>
                    <li><a id="teams" href="/">Teams</a></li>
                    <li><a id="companies" href="/">Companies</a></li>
                    <li><a id="jobRole" href="/">Job Role</a></li>
                </ul>
            </div>

            <script>
                $("ul.nav").children().eq(0).addClass("active");
            </script>-->

            <div>
                <h1>People</h1>
            </div>
            <div class="row">
                <#list persons as result>


                    <div class="col-md-3 col-sm-4 entry">
                        <a href="/person/${result.personId}">
                        <div class="imgWrapper f0f8fc" style="border: 15px solid rgb(240, 248, 252)">
                            <img class="avatar" src="${result.picture}"/>
                        </div>
                        <h4 class="text-center entryName">
                            <a href="/person/${result.personId}">${result.firstName} ${result.lastName}</a>
                        </h4>
                        <h5 class="text-center teamName">
                            ${result.jobTitle}
                        </h5>
                        <h5 class="text-center teamName">
                            ${result.teamName} - ${result.statusInTeam}
                        </h5>
                        <#if result.location??>
                            <h5 class="text-center teamName">
                                ${result.location}
                            </h5>
                        <#else>
                            <h5 class="text-center teamName">
                                Bath Road, Slough
                            </h5>
                        <i class="fa fa-envelope-o"></i> &nbsp; <i class="fa fa-phone"></i>
                        </#if>
                        </a>
                    </div>

                </#list>
            </div>
        </#if>
    </#if>
</div>
<script>
    $(document).ready(function () {
        $('img.avatar').fakecrop();
    });
</script>