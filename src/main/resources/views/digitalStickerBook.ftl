<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Digital Sticker Book | Find Me</title>
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
                      <a class="navbar-brand" href="/"><img alt="O2" id="o2-logo" src="http://static.o2.co.uk/shared/img/logo-o2.svg"></a>
                      <a class="navbar-brand" href="/">Find Me</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                      <ul class="nav navbar-nav">
                        <li><a href="/">Home</a></li>
                        <li class="active"><a href="/stickerBook">Sticker book <span class="badge">${(stickerCount)!"-"}</span></a></li>
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
            <div class="row">
            <h3>The Lab  <a href=""><i class="fa fa-info-circle fa-lg"></i></a></h3>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Elliot Massey</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Jez Sherwin</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Fahren Wallace</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6><i class="fa fa-star"></i> Stephen Devereux <i class="fa fa-star"></i></h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Benny Hill</h6>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Derek Smith</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Andrew Harland</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Derek Walsh</h6>
                </div>

            </div>
            <div class="row">
            <h3>Ecommerce  <a href=""><i class="fa fa-info-circle fa-lg"></i></a></h3>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Orlando Depp</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Lucy Beinz</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Vivian Martin</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6><i class="fa fa-star"></i> Delvin Troy <i class="fa fa-star"></i></h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Jordan Peshmi</h6>
                </div>
            </div>
            <div class="row">
            <h3>Devo2  <a href=""><i class="fa fa-info-circle fa-lg"></i></a></h3>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Sara Johns</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Boris Matthew</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Kevin Andrews</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Patrick Macqhenciz</h6>
                </div>
                <div class="col-md-3 col-sm-4 sticker">
                    <img class="stickerImg" src="/assets/images/default_profile.jpg">
                    <h6>Alice Khans</h6>
                </div>
            </div>
        </div>
    </body>
</html>