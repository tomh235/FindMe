<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Find Me | Login to Find 'em!</title>
        <link rel="icon" type="image/ico" href="/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/assets/css/main.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="/assets/javascripts/jquery-1.9.0.min.js"></script>
    </head>
    <body>
        <div class="containerTop">
            <div class="row top">
                <p><span id="mainUser"><i class="fa fa-user"></i></span> Hello <br> Please Login <span class="floatRight">FIND ME</span></p>

            </div>
        </div>
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
