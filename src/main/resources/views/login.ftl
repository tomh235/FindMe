<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Find Me | Login to Find 'em!</title>
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
                        <a class="navbar-brand" href="FindMe"><img alt="O2" id="o2-logo" src="http://static.o2.co.uk/shared/img/logo-o2.svg"></a>
                      <a class="navbar-brand" href="FindMe">Find Me</a>
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
                    <h1>Login to Find Me</h1>
                    <p>Forgot your password? -> <a href="">Request new password</a></p>
                    <p>New to Find Me -> <a href="/FindMe/register">Register</a></p>
                    <br>
                    <form role="form" method="POST" action="/FindMe/login">
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
                </div>
            </div>
        </div>
        <script src="/FindMe/assets/javascripts/bootstrap.min.js"></script>
    </body>
</html>
