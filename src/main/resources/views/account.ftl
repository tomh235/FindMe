<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Your Account | Find 'em!</title>
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
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 text-center">
                   <h2>Your account</h2>
                </div>
            </div>
            <div class="row">
                <form  role="form" method="POST" action="/account">
                    <br>
                    <p>To change any of your details, please edit the fields below and then submit the form.</p>
                    <hr>
                    <div class="accountForm">
                        <div class="col-md-4 col-md-offset-2">
                        <h4>Name</h4>
                        <span style="display:inline-block">
                            First: <input class="form-control" type="text" name="firstName" placeholder="Enter first name" value="${(firstName)!""}" required>
                        </span>
                        <br>
                        <span style="display:inline-block">
                            Last: <input class="form-control" type="text" name="lastName" placeholder="Enter last name" value="${(lastName)!""}" required></span>
                        </span>

                                <h4>Email</h4>
                                <input class="form-control" id="emailEntry" type="email" name="email" placeholder="Enter email" value="${(email)!""}" required>

                                <h4>Job Title</h4>
                                <input class="form-control" type="text" name="jobTitle" placeholder="Enter job title" value="${(jobTitle)!""}" required>

                                <h4>Location</h4>
                                <input class="form-control" type="text" name="location" placeholder="Enter office location" value="${(location)!""}" required>

                                <h4>Team</h4>
                                <input class="form-control" type="text" name="teamName" placeholder="Enter team name" value="${(teamName)!""}" required>

                                <h4>Project</h4>
                                <input class="form-control" type="text" name="currentProject" placeholder="Enter your project" value="${(currentProject)!""}" required>
                        </div>

                            <div class="col-md-4">
                                <h4>Phone</h4>
                                <input class="form-control" type="text" name="phoneNumber" placeholder="Enter phone number" value="${(phoneNumber)!""}" required>

                                <h4>Picture</h4>
                                <input class="form-control" id="imageLink" type="url" name="picture" placeholder="Enter photo url" value="${(picture)!""}">
                                <br>
                                <p>Preview</p>
                                <a href="#">
                                    <img class="signup-pic" src="${picture}" alt="">
                                </a>
                                <br>
                                <h4>A bit about you</h4>
                                <input class="form-control" type="text" name="details" placeholder="Enter a bit about you" value="${(details)!""}" required>
                            </div>
                        </div>
                    </div>
                    <br>
                    <input id="accountSubmit" class="btn btn-primary btn-lg btn-block" type="submit">
                </form>
                <br>
                <br>
                <hr>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-2">
                    <h4>Request password reset link</h3>
                    <p>If you require a new password then please use the link:</p>
                    <a href="">Request Password Reset</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-2">
                    <h3>Generate QR code</h3>
                    <p>If your original QR code has been lost or damaged, then print a new one using this link:</p>
                    <a href="">Request new QR code</a>
                </div>
            </div>
        </div>
        <script>
            $(function() {
              $("#imageLink").on("focusout", function() {
                $(".signup-pic").prop("src", $(this).val());
              });
            });
        </script>
    </body>
</html>