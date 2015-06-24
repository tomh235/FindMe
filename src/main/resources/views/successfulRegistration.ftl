<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Registration | Find Me</title>
        <link rel="icon" type="image/ico" href="/FindMe/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/FindMe/assets/css/main.css">
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
                      <a class="navbar-brand" href="/FindMe"><img alt="O2" id="o2-logo" src="http://static.o2.co.uk/shared/img/logo-o2.svg"></a>
                      <a class="navbar-brand" href="/FindMe">Find Me</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                      <ul class="nav navbar-nav">
                        <li><a href="/FindMe">Home</a></li>
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
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Hello ${(currentUser)!""} <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                  <li class="active"><a href="/FindMe/account">Your Account</a></li>
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
            <div class="row">
                <div class="col-md-6 col-md-offset-3 form">
                    <h1>Account Registration</h1>
                    <br>
                    <p>Use this form to register for an account to be created for yourself when the Find Me application is complete.</p>
                    <hr>
                    <br>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3 form">
                    <#if (statusError)??>
                        <div class="status error">
                            <#if statusIcon == true>
                                <i class="fa fa-check-circle fa-3x"></i>
                            <#elseif statusIcon == false>
                                <i class="fa fa-exclamation-circle fa-3x"></i>
                            </#if>
                            <h5>${statusError}</h5>
                        </div>
                    </#if>

                    <hr>
                    <br>
                    <p>Hey Presto! You're done! Time to get started!</p>
                    <p>Before you know it everyone in O2 IT will be stored in this database. Contractors and all!</p>
                    <p>Key places to explore will be the <strong>Daily Competition</strong> and your <strong>Sticker Book</strong> so allow you to get to the top of the leaderboards!</p>
                    <p>For being so kind to register anyway - could you fill out the quick survey in the link below to give us your feedback, expectations or gripes.</p>
                    <a href="" id="surveyLink"><h6>Link to Survey</h6></a>
                    <p>Be as honest as you like - transparancy is key! :-)</p>
                </div>
            </div>
        </div>
        <script src="/FindMe/assets/javascripts/bootstrap.min.js"></script>
    </body>
</html>