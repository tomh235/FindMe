<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Digital Sticker Book | Find Me</title>
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
                        <li><a href="/FindMe">Home</a></li>
                        <li class="active"><a href="/stickerBook">Sticker book <span class="badge">${(stickerCount)!"-"}</span></a></li>
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
                <br>

        <div class="container">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <h1>Your Digital Sticker Book</h1>
                        <br>
                        <p>This is your very own sticker book (yay)! Scan the QR codes of the people you meet to get their pictures in your book.</p>
                        <p>Remember! By doing so you get the chance to rank up on the <a href="/leaderboards">leaderboard</a> and win prizes!</p>
                        <p>Oh jolly! I've forgotten the rules for this and what the special bonus stuff is! <a href="">Help!</a></p>
                        <hr>
                        <br>
                    </div>
                </div>
            </div>
            <h4 class="centered">You currently have <strong>${(stickerCount + " person(s)")!"no one ... [or there is a problem ;) ]"}</strong> in your sticker book, but you need more!!</h4>
            <div class="row">
            <#list stickerBookPersonList as stickerBookPersonList>

                    <div class="col-md-3 col-sm-4 sticker">
                        <a href="/FindMe/person/${(stickerBookPersonList.personId)!""}" class="thumbnail">
                            <img class="stickerImg" src="${(stickerBookPersonList.picture)!"/FindMe/assets/images/default_profile.jpg"}">
                        </a>
                        <h6>${(stickerBookPersonList.firstName)!"-"} ${(stickerBookPersonList.lastName)!"-"}</h6>
                    </div>

            </#list>
            </div>
        </div>
    </body>
</html>