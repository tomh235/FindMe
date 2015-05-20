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
                    <form role="form" method="post" action="/register">
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
                            <#if (errors["team"])??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${errors["team"]}
                                </div>
                            </#if>

                            <label>Current Team</label>
                                <select class="form-control" name="team" required>
                                        <option value="The Lab">The Lab</option>
                                        <option value="Digital ID">Digital ID</option>
                                        <option value="Kentucky">Kentucky</option>
                                        <option value="My O2">My O2</option>
                                        <option value="Kanban">Kanban</option>
                                        <option value="SMIP">SMIP</option>
                                        <option value="Support Team">Support Team</option>
                                        <option value="Business Website">Business Website</option>
                                        <option value="SMB Digital Small Change Scrum">SMB Digital Small Change Scrum</option>
                                        <option value="CVOS">CVOS</option>
                                        <option value="Online at the Highstreet">Online at the Highstreet</option>
                                </select>
                        </div>

                        <div class="form-group">
                            <label>Job Title</label>
                            <input class="form-control" type="text" name="role" placeholder="Enter job title" value="${(personInformation.jobTitle)!""}" required>
                        </div>

                        <div class="form-group">
                            <#if (errors["personInformation.project"])??>
                                <div class="alert alert-danger">
                                    <span class="glyphicon glyphicon-remove"></span>${errors["personInformation.project"]}
                                </div>
                            </#if>
                            <label>Your Current Project</label>
                            <input class="form-control" type="text" name="project" placeholder="Enter your project's name" value="${(personInformation.project)!""}" required>
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