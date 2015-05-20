<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>${firstName} ${lastName} | Find Me</title>
        <link rel="icon" type="image/ico" href="/assets/images/favicon.ico" />
        <link rel="stylesheet" media="screen" href="/assets/css/main.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="/assets/javascripts/jquery-1.9.0.min.js"></script>
    </head>
    <body>
        <div class="containerTop">
            <div class="row top">
                <p><span id="mainUser"><i class="fa fa-user"></i></span> ELLIOT MASSEY <br> 82 Connections <span class="floatRight">FIND ME</span></p>

            </div>
        </div>
        <div class="container">
            <!---<div class="row profile-message">
                <p>Is it me you're looking for? Then add me to your <strong>Found People</strong> list! <a class="FPbtn" id="yesbtn" href="/yes">YES!</a> <a class="FPbtn" id="nobtn" href="/no">NO</a></p>
            </div>-->

            <div class="row">
                <div class="col-md-8 col-md-offset-2 entry">
                    <img class="single-person-pic" width="200px" height="200px" src="${picture}"></img>
                    <div class="quickContact">
                        <h5 class="personName">${firstName} ${lastName}</h5>
                        <p class="lastUpdated">Last updated 20/04/2015</p>
                        <h5 class="personRole">${jobTitle}</h5>
                        <h5 class="teamName">${teamName} - ${statusInTeam}</h5>
                        <h5 class="personLocation">${location}</h5>

                        <h5 class="personEmail"><i class="fa fa-envelope-o"></i> - ${email}</h5>
                        <h5 class="personSkype"><i class="fa fa-skype"></i> - john.smith</h5>
                        <h5 class="personPhone"><i class="fa fa-phone"></i> - 0771234567</h5>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>