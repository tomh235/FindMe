<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Daily Competition | Find Me</title>
         <meta contentType="text/html; charset="UTF-8"/>
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
                        <li>
                            <a href="/FindMe/competition">Daily Competition
                                <#if hasPlayed == true>

                                <#elseif hasPlayed == false>
                                    <span class="badge"><i class="fa fa-exclamation"></i></span>
                                </#if>
                            </a>
                        </li>
                        <li class="active"><a href="/FindMe/leaderboards">Leaderboards</a></li>
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
                                <h3 class="panel-title">Leaderboards</strong></h3>
                            </div>
                            <br>
                            <br>
                            <div class="spacing">
                                <p>To view the leaderboards please click on the title for the boards you want to see.</p>

                                <!-- Table -->

                                <div class="alert"><h4 id="competitionToggle">Competition Leaderboard <i class="fa fa-chevron-circle-down"></i></h4></div>

                                <div id="competitionTable">
                                    <table class="table displayBoard">
                                        <thead>
                                          <tr>
                                            <th>Name</th>
                                            <th>Job Title</th>
                                            <th>Game Score</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                            <#list gameDataLBList as gameDataLBList>
                                            <tr>
                                                <!--<th scope="row">1</th>-->
                                                <td>${(gameDataLBList.firstName)!"-"} ${(gameDataLBList.lastName)!"-"}</td>
                                                <td>${(gameDataLBList.jobTitle)!"-"}</td>
                                                <td>${(gameDataLBList.gameScore)!"-"}</td>
                                            </tr>
                                            </#list>
                                        </tbody>
                                    </table>
                                </div>

                                <br>
                                <br>
                                <br>

                                <div class="alert"><h4 id="stickerBookToggle">StickerBook Leaderboard <i class="fa fa-chevron-circle-down"></i></h4></div>

                                <div id="stickerBookTable">
                                <!-- Table -->
                                    <table class="table displayBoard">
                                        <thead>
                                          <tr>
                                            <th>Name</th>
                                            <th>Job Title</th>
                                            <th>Sticker book Score</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                            <#list stickerBookLBList as stickerBookLBList>
                                            <tr>
                                                <!--<th scope="row">1</th>-->
                                                <td>${(stickerBookLBList.firstName)!"-"} ${(stickerBookLBList.lastName)!"-"}</td>
                                                <td>${(stickerBookLBList.jobTitle)!"-"}</td>
                                                <td>${(stickerBookLBList.stickerbookScore)!"-"}</td>
                                            </tr>
                                            </#list>
                                        </tbody>
                                      </table>
                                <div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="/FindMe/assets/javascripts/bootstrap.min.js"></script>
        <script type="text/javascript">
            $("#competitionToggle").click(function () {
               $('#competitionTable').slideToggle();
            });

            $("#stickerBookToggle").click(function () {
               $('#stickerBookTable').slideToggle();
            });
        </script>
    </body>
</html>