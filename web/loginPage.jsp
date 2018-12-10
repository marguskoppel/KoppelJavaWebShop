
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/header.jsp" />

        <div class="container">
   <div class="page-header">
      <h1 class="centre-align">Please Login into your account</h1>
   </div>
   <p class="centre-align larger_p">
      Before you can buy our products, you must register or login.
   </p>      
   <div class="row push_down"> 
      <div class="col-sm-8 col-sm-offset-2">
         <c:if test="${info != null}">
            <div class="alert alert-success" role="alert">
               <p>${info}</p>
            </div>
         </c:if>     
         <form action="login" method="POST" onsubmit="return validate()" name="form1" id="_form1">
            <div class="form-group">
               <label for="login">Login:</label>
               <input type="text" name="login" id="login" class="form-control" required="true" /> 
            </div>
            <div class="form-group">
               <label for="password">Password:</label>
               <input type="password" name="password" id="password" class="form-control" required="true" />
            </div>
            <div class="form-group">
               <input type="submit" class="btn btn-primary" value="Login" id="button" />
            </div>
         </form>
      </div>
   </div>
</div>
        
  
<jsp:include page="/footer.jsp" />