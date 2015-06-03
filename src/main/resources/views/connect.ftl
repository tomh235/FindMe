<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Connect with someone | Find 'em!</title>
        <link rel="icon" type="image/ico" href="/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/assets/css/main.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="/assets/javascripts/jquery-1.11.3.min.js"></script>
        <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <!-- Fixed navbar -->
                <nav class="navbar navbar-default navbar-fixed-top">
                  <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/"><img alt="O2" id="o2-logo" src="http://static.o2.co.uk/shared/img/logo-o2.svg"></a>
                      <a class="navbar-brand" href="/">Find Me</a>
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
                        <#else>
                            <div class="alert alert-danger" role="alert">Oh snap! They haven't been added. Do you already have this person in your stickerbook?</div>
                        </#if>
                    <#else>

                    </#if>

                    <form role="form" method="POST" action="${("/connect/" + targetPerson + "/add")!"/oops"}">
                        <#if error??>
                            <div class="alert alert-danger">
                                <span class="glyphicon glyphicon-remove"></span>${error}
                            </div>
                        </#if>

                        <p>To add someone to your digital stickerbook then enter the email address your account is connected to and press enter.</p>

                        <div class="form-group">
                            <label>Your Email address:</label>
                            <input class="form-control" type="email" name="email" placeholder="Enter email" value="${email!""}" required>
                        </div>

                        <input id="login" class="btn btn-primary btn-lg btn-block" type="submit" value="Add to Stickerbook">
                    </form>
                </div>
            </div>
        </div>
        <script src="/assets/javascripts/bootstrap.min.js"></script>
    </body>
</html>
