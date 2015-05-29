<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Find Me | Login to Find 'em!</title>
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
                    <h1>Login to Find Me</h1>
                    <p>Forgot your password? -> <a href="">Request new password</a></p>
                    <br>
                    <form role="form" method="POST" action="/login">
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
    </body>
</html>
