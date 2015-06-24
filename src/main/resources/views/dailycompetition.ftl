<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Daily Competition | Find Me</title>
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
                        <li><a href="/FindMe/stickerBook">Sticker book <span class="badge">${(stickerCount)!"-"}</span></a></li>
                        <li class="active">
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
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="panel panel-primary panel-spacing">
                            <div class="panel-heading">
                                <h3 class="panel-title">Daily Competition: <strong>Guess Who!</strong></h3>
                            </div>
                            <div class="panel-body">
                                <#if hasPlayed == true>
                                    <p>You've played Guess Who today! Hope it was correct :) Come back again tomorrow for another try.</p>
                                <#elseif hasPlayed == false>
                                    <h4>How to play <i id="gameInfoToggle" onclick="javascript:toggleDiv();" class="fa fa-info-circle"></i></h4>
                                    <div id="infoContent" style="display:none">
                                    <br>
                                        <p>Below you'll see the description (what you wrote in the 'A bit about you') of a random person from IT.</p>
                                        <p>All you need to do is to guess who that person is!</p>
                                        <p><strong>Rewards?</strong> - Yep, if you guessed right then you get a point added to the Guess Who! leaderboard - hooray!</p>
                                        <p>But if you're also able to add them to your stickerbook by 5pm the next day you can get 5 additional points to Guess Who! leaderboard
                                        alongside the point to your sticker leaderboard. :-) bonus!</p>
                                        <hr>
                                    </div>
                                    <br>
                                    <p>Guess the person described below!</p>
                                    <div id="quote">"${(guessString)!"Oops - something is wrong... terribly wrong!"}"</div>
                                    <br>
                                    <br>
                                    <form class="guessForm" role="form" method="post" action="/FindMe/competition">
                                        <input class="form-control" type="text" name="entry" placeholder="Your guess" value="" required>
                                        <br>
                                        <button type="submit" class="btn btn-default">Enter Guess!</button>
                                    </form>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function toggleDiv() {
                $("#infoContent").toggle();
            }
        </script>
        <script src="/FindMe/assets/javascripts/bootstrap.min.js"></script>
    </body>
</html>