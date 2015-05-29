<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Daily Competition | Find Me</title>
        <link rel="icon" type="image/ico" href="/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/assets/css/main.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

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
                      <a class="navbar-brand" href="/">Find Me</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                      <ul class="nav navbar-nav">
                        <li><a href="/">Home</a></li>
                        <li><a href="/stickerBook">Sticker book <span class="badge">1060</span></a></li>
                        <li class="active"><a href="/competition">Daily Competition <span class="badge"><i class="fa fa-exclamation"></i></span></a></li>
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
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="panel panel-primary panel-spacing">
                            <div class="panel-heading">
                                <h3 class="panel-title">Daily Competition: <strong>Guess Who!</strong></h3>
                            </div>
                            <div class="panel-body">
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
                                <div id="quote">"I like cats, been a developer in Ecom for 5 years and try to hide my balding spot."</div>
                                <br>
                                <br>
                                <form class="guessForm" role="form" method="post" action="/competition/entry">
                                    <input class="form-control" type="text" name="entry" placeholder="Your guess" value="" required>
                                    <br>
                                    <button type="submit" class="btn btn-default">Enter Guess!</button>
                                </form>
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
    </body>
</html>