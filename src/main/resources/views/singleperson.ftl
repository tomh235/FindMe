<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>${person.firstName} ${person.lastName} | Find Me</title>
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
        <br>
        <div class="container">
            <!---<div class="row profile-message">
                <p>Is it me you're looking for? Then add me to your <strong>Found People</strong> list! <a class="FPbtn" id="yesbtn" href="/yes">YES!</a> <a class="FPbtn" id="nobtn" href="/no">NO</a></p>
            </div>-->

            <div class="row">
                <div class="col-md-8 col-md-offset-2 entry">
                    <img class="single-person-pic" width="200px" height="200px" src="${person.picture}"></img>
                    <div class="quickContact">
                        <h5 class="personName">${person.firstName} ${person.lastName}</h5>
                        <p class="lastUpdated">Last updated 20/04/2015</p>
                        <h5 class="personRole">${person.jobTitle}</h5>
                        <h5 class="teamName">${person.teamName} - (${person.statusInTeam})</h5>
                        <h5 class="personLocation">${person.location}</h5>

                        <h5 class="personEmail"><i class="fa fa-envelope-o"></i> - ${person.email}</h5>
                        <br>
                        <h5 class="personPhone"><i class="fa fa-phone"></i> - 0771234567</h5>
                    </div>
                    <h5>A quick bit about me:</h5>
                    <p>${person.details}</p>
                </div>
            </div>
        </div>

    </body>
</html>