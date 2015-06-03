<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Find Me | Find 'em!</title>
        <link rel="icon" type="image/ico" href="/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/assets/css/main.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="/assets/javascripts/jquery-1.11.3.min.js"></script>
        <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
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
              <a class="navbar-brand" href="/"><img alt="O2" id="o2-logo" src="http://static.o2.co.uk/shared/img/logo-o2.svg"></a>
              <a class="navbar-brand" href="/">Find Me</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/stickerBook">Sticker book <span class="badge">${(stickerCount)!"-"}</span></a></li>
                <li>
                    <a href="/competition">Daily Competition
                        <#if hasPlayed == true>

                        <#elseif hasPlayed == false>
                            <span class="badge"><i class="fa fa-exclamation"></i></span>
                        </#if>
                    </a>
                </li>
                <li><a href="/leaderboards">Leaderboards</a></li>
              </ul>

              <ul class="nav navbar-nav navbar-right">
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Hello ${(currentUser.firstName)!""} <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="/account">Your Account</a></li>
                          <li><a href="/logout">Logout</a></li>
                        </ul>
                      </li>
                    </ul>
            </div><!--/.nav-collapse -->
          </div>
        </nav>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="input-group input-group-lg entry-area-start" id="searchBar">
                        <span class="input-group-btn find-me">
                            <p>Find Me</p>
                        </span>
                        <input tabindex="1" id="searchInput" type="text" name="keywords" class="form-control icon-search" placeholder="Search by person">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                    <div class="centered">
                        <br>
                        <br>
                        <h4>Population<i id="usersimgPop" class="fa fa-users"></i> ${(popCount)!""}</h4>
                        </div>
                </div>
            </div>

            <div id="quickLinks">
                <!--<p><button class="btn btn-primary" type="button">O2</button>
                <button class="btn btn-primary" type="button">DevO2</button>
                <button class="btn btn-primary" type="button">Yammer</button>
                <button class="btn btn-primary" type="button">O2 Intranet</button>
                <button class="btn btn-primary" type="button">JIRA</button></p>-->
            </div>

            <div id="result"></div>
        </div>

        <script src="/assets/javascripts/bootstrap.min.js"></script>
        <script src="/assets/javascripts/search-box.js"></script>
        <script src="/assets/javascripts/jquery.fakecrop.js"></script>
        <script>
            var searchInput = $("#searchInput");
            var result = $("#result");
            searchInput.focus();
            autoSearchOnKeyUp(searchInput, "/results", result);
        </script>

    </body>
</html>

