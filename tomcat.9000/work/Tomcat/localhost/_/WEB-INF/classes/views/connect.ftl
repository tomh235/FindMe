<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Connect with someone | Find 'em!</title>
        <link rel="icon" type="image/ico" href="/FindMe/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/FindMe/assets/css/main.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">-->
        <script src="/FindMe/assets/javascripts/jquery-1.11.3.min.js"></script>
        <link href="/FindMe/assets/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <!-- Fixed navbar -->
                <nav class="navbar navbar-default navbar-fixed-top">
                  <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/FindMe"><img alt="O2" id="o2-logo" src="http://static.o2.co.uk/shared/img/logo-o2.svg"></a>
                      <a class="navbar-brand" href="/FindMe">Find Me</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                      <ul class="nav navbar-nav">

                      </ul>
                      <ul class="nav navbar-nav navbar-right">
                        <p class="navbar-text">Welcome to Find Me</p>
                      </ul>
                    </div><!--/.nav-collapse -->
                  </div>
                </nav>
                <br>
                <br>
                <br>
                <br>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 form">
                    <h1>Add to your Stickerbook!</h1>
                    <p>Want to go home? -> <a href="/">Home</a></p>
                    <br>
                    <#if beenAdded??>
                        <#if beenAdded == "true">
                            <div class="alert alert-success" role="alert">Hoorah! You've successfully added someone to your stickerbook! Rock on.</div>
                        <#elseif beenAdded == "false">
                            <div class="alert alert-danger" role="alert">Oh snap! They haven't been added. Do you already have this person in your stickerbook?</div>
                        <#elseif beenAdded == "noSelfAdding">
                            <div class="alert alert-danger" role="alert">Woah! You can't add yourself! It's not cricket.</div>
                        </#if>
                    <#else>

                    </#if>

                    <#if isLoggedIn == "false">
                        <form role="form" method="POST" action="${("/FindMe/connect/" + targetPerson + "/login")!""}">
                            <#if error??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${error}
                                </div>
                            </#if>

                            <div class="form-group">
                                <label>Email address</label>
                                <input class="form-control" type="email" name="email" placeholder="Enter email" value="${email!""}" required>
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" name="password" placeholder="Enter password" value="${password!""}" required>
                            </div>
                            <input id="login" class="btn btn-primary btn-lg btn-block" type="submit" value="Login">
                        </form>
                    </#if>
                </div>
            </div>
        </div>
        <script src="/FindMe/assets/javascripts/bootstrap.min.js"></script>
    </body>
</html>
