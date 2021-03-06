<!DOCTYPE html>

<html>
    <head profile="http://www.w3.org/2005/10/profile">
        <title>Registration | Find Me</title>
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
                    <h1>Account Registration</h1>
                    <br>
                    <p>Have an existing account -> <a href="/FindMe/login">Login</a></p>
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
                    <form role="form" method="post" action="/FindMe/register">
                        <div class="form-group">
                            <#if (errors["personInformation.name"])??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${errors["personInformation.name"]}
                                </div>
                            </#if>

                            <label>First name</label>
                            <input class="form-control" type="text" name="firstName" placeholder="Enter first name" value="${(personInformation.firstName)!""}" required>
                            <br>
                            <label>Last name</label>
                            <input class="form-control" type="text" name="lastName" placeholder="Enter last name" value="${(personInformation.lastName)!""}" required>
                        </div>

                        <div class="form-group">
                            <#if (errors["personInformation.email"])??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${errors["personInformation.email"]}
                                </div>
                            </#if>
                            <label>Email address</label>
                            <input class="form-control" id="emailEntry" type="email" name="email" placeholder="Enter email" value="${(personInformation.email)!""}" required>
                        </div>

                        <div class="form-group">
                            <#if (errors["personInformation.password"])??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${errors["personInformation.password"]}
                                </div>
                            </#if>
                            <label>Password</label>
                            <input class="form-control" id="emailEntry" type="password" name="password" placeholder="Enter password" value="${(personInformation.password)!""}" required>
                        </div>

                        <div class="form-group">
                            <label>Mobile number</label>
                            <input class="form-control" type="text" name="phoneNumber" placeholder="Enter your number" value="${(personInformation.phoneNumber)!""}" required>
                        </div>

                        <label>Current Team</label>
                        <input class="form-control" type="text" name="team" placeholder="Enter your current team" value="${(personInformation.teamName)!""}" required>

                        <br>
                        <div class="form-group">
                            <label>Job Title</label>
                            <input class="form-control" type="text" name="role" placeholder="Enter job title" value="${(personInformation.jobTitle)!""}" required>
                        </div>

                        <div class="form-group">
                            <#if (errors["personInformation.currentProject"])??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${errors["personInformation.currentProject"]}
                                </div>
                            </#if>
                            <label>Your Current Project</label>
                            <input class="form-control" type="text" name="currentProject" placeholder="Enter your project's name" value="${(personInformation.currentProject)!""}" required>
                        </div>

                        <div class="form-group">
                            <#if (errors["personInformation.location"])??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${errors["personInformation.location"]}
                                </div>
                            </#if>
                            <label>Where you are based</label>
                            <select class="form-control" name="location" required >
                                <option value="Bath Road">Bath Road, Slough</option>
                                <option value="Buckingham Avenue">Buckingham Avenue</option>
                                <option value="Leeds">Leeds</option>
                                <option value="Pune">Pune</option>
                                <option value="WFH">WFH</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Link to your picture (maybe use your linkedin picture)</label>
                            <p>Example: http://xxxx.com/xxxxxx.jpg</p>
                            <input class="form-control" type="url" name="photo" placeholder="Enter link to picture" value="${(personInformation.picture)!""}" required>
                        </div>

                        <div class="form-group">
                            <label>A bit about yourself</label>
                            <p>Example: "I like cats, been a developer in Ecom for 5 years and try to hide my balding spot."</p>
                            <input class="form-control" type="text" name="details" placeholder="A bit about yourself" value="${(personInformation.details)!""}" required>
                        </div>

                        <input id="submit" class="btn btn-primary btn-lg btn-block" type="submit">
                    </form>

                    <script>

$('#emailEntry').focusout(function() {
str = $('#emailEntry').val();
    str = str.split('@').slice(1);

    var allowedDomains = [ 'o2.com', 'cognizant.com', 'telefonica.com', 'equalexperts.com' ];

    if ($.inArray(str[0], allowedDomains) == -1) {
            alert(str + ' is not a valid corporate email.');
    }
});
                    </script>
                </div>
            </div>
        </div>
    </body>
</html>