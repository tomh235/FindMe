<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Registration | Find Me</title>
        <link rel="icon" type="image/ico" href="/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/assets/css/main.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="/assets/javascripts/jquery-1.9.0.min.js"></script>
    </head>
    <body>
        <div class="containerTop">
            <div class="row top">
                <p><span id="mainUser"><i class="fa fa-user"></i></span> Hello <#if !(personInformation.firstName)??> New User <#else> <em>${personInformation.firstName}</em> </#if> <br> Pre-Alpha <span class="floatRight">FIND ME</span></p>

            </div>
        </div>

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