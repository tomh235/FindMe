<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Find Me | Show All</title>
        <link rel="icon" type="image/ico" href="/FindMe/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/FindMe/assets/css/main.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="/FindMe/assets/javascripts/jquery-1.11.3.min.js"></script>
        <link href="/FindMe/assets/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
<!-- Fixed navbar -->
        <nav class="navbar navbar-default navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/FindMe"><img alt="O2" id="o2-logo" src="http://static.o2.co.uk/shared/img/logo-o2.svg"></a>
              <a class="navbar-brand" href="/FindMe">Find Me</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="/FindMe">Home</a></li>
                <li><a href="/FindMe/stickerBook">Sticker book <span class="badge">${(stickerCount)!"-"}</span></a></li>
                <li>
                    <a href="/FindMe/competition">Daily Competition
                        <#if hasPlayed == true>

                        <#elseif hasPlayed == false>
                            <span class="badge"><i class="fa fa-exclamation"></i></span>
                        </#if>
                    </a>
                </li>
                <li><a href="/FindMe/leaderboards">Leaderboards</a></li>
              </ul>

              <ul class="nav navbar-nav navbar-right">
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Hello ${(currentUser.firstName)!""} <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="/FindMe/account">Your Account</a></li>
                          <li><a href="/FindMe/logout">Logout</a></li>
                        </ul>
                      </li>
                    </ul>
            </div><!--/.nav-collapse -->
          </div>
        </nav>
        <br>
        <br>
        <div class="container">
            <#assign resultsCount = persons?size>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="centered">
                        <br>
                        <a href="/FindMe"><button type="button" class="btn btn-default">Back to Home</button></a>
                        <br>
                </div>
            </div>

            <div id="result">
                <div class="container">
                        <#if persons?has_content>
                            <div>
                                <br>
                                <h1>People</h1>
                            </div>
                            <div class="row">
                                <#list persons as result>


                                    <div class="col-md-3 col-sm-4 entry">
                                        <a href="/FindMe/person/${result.personId}">
                                        <div class="imgWrapper f0f8fc" style="border: 15px solid rgb(240, 248, 252)">
                                            <img class="avatar" src="${result.picture}"/>
                                        </div>
                                        <h4 class="text-center entryName">
                                            <a href="/FindMe/person/${result.personId}">${(result.firstName)!"-"} ${(result.lastName)!"-"}</a>
                                        </h4>
                                        <h5 class="text-center teamName">
                                            ${(result.jobTitle)!"-"}
                                        </h5>
                                        <h5 class="text-center teamName">
                                            ${(result.teamName)!"-"}
                                        </h5>
                                        <h5 class="text-center teamName">
                                            ${(result.location)!"-"}
                                        </h5>
                                        <i class="fa fa-envelope-o"></i> &nbsp; <#if result.phoneNumber == ""> <#else><i class="fa fa-phone"></i></#if>
                                        </a>
                                    </div>

                                </#list>
                            </div>
                        </#if>
                </div>
                <script>
                    $(document).ready(function () {
                        $('img.avatar').fakecrop();
                    });
                </script>
            </div>
        </div>

        <script src="/FindMe/assets/javascripts/bootstrap.min.js"></script>
        <script src="/FindMe/assets/javascripts/search-box.js"></script>
        <script src="/FindMe/assets/javascripts/jquery.fakecrop.js"></script>
    </body>
</html>

