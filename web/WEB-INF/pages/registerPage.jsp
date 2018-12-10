<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/header.jsp" />


<div class="container">
    <div class="page-header centre-align">
        <h1>Please register an account!</h1>
    </div>
    <p class="larger_p centre-align">
        If you would like to buy our products, please register by filling the form below.
    </p>
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <c:if test="${info != null}">
                <div class="alert alert-info" role="alert">
                    <p>${info}</p>
                </div>
            </c:if>
            <c:if test="${info_error != null}">
                <div class="alert alert-danger" role="alert">
                    <p>${info_error}</p>
                </div>
            </c:if>
            <form action="register" method="POST" name="form1" id="_form1">
                <div class="form-group">
                    <label for="login">Login:</label>
                    <input type="text" name="login" class="form-control" required="true" />
                </div>
                <div class="form-group">
                    <label for="password1">Password:</label>
                    <input type="password" name="password1" class="form-control" required="true" />
                </div>
                <div class="form-group">
                    <label for="password2">Re-enter password:</label>
                    <input type="password" name="password2" class="form-control" required="true" />
                </div>
                <div class="form-group">
                    <label for="name">First Name:</label>
                    <input type="text" name="name" class="form-control" required="true" />
                </div>
                <div class="form-group">
                    <label for="surname">Last Name:</label>
                    <input type="text" name="surname" class="form-control" required="true" />
                </div>
                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="phone" name="phone" class="form-control" required="true" />
                </div>
                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="city" name="city" class="form-control" required="true" />
                </div> 
                <div class="form-group">
                    <input type="submit" value="Register" class="btn btn-primary" />
                </div>
            </form>        
        </div>
    </div>
</div>

<jsp:include page="/footer.jsp" />
