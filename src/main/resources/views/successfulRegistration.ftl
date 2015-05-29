<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Registration | Find Me</title>
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
                        <li><a href="/competition">Daily Competition <span class="badge"><i class="fa fa-exclamation"></i></span></a></li>
                        <li><a href="/leaderboards">Leaderboards</a></li>
                      </ul>

                      <ul class="nav navbar-nav navbar-right">
                              <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Hello ${(firstName)!""} <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                  <li class="active"><a href="/account">Your Account</a></li>
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
                    <p>Hey Presto! You're done! Unfortunately that's all there is to it at the moment!</p>
                    <p>Forgive us... please.</p>
                    <p>For being so kind to register anyway - could you fill out the quick survey in the link below to give us your feedback, expectations or gripes.</p>
                    <a href="" id="surveyLink"><h6>Link to Survey</h6></a>
                    <p>Be as honest as you like - transparancy is key! :-)</p>
                </div>
            </div>
        </div>
    </body>
</html>