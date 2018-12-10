
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
    <c:when test="${sessionScope.admin != null}">
<jsp:include page="/admin_panel/header.jsp" />

<div class="container">
   <div class="page-header centre-align">
      <h1>Admin Panel</h1>
   </div>
   <div class="row">
      <div class="col-sm-9">
         <p class="larger_p">
            This is your admin panel from which you can manage your web store. 
         </p>
      </div>
      
   </div>   
</div>

<jsp:include page="/footer.jsp" />
</c:when>
<c:otherwise>
    <jsp:include page="/noRights.jsp" />
</c:otherwise>
</c:choose>