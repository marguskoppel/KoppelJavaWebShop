
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/header.jsp" />

<div class="jumbotron">
   <div class="container">
       <c:if test="${info != null}">
            <div class="alert alert-success" role="alert">
               <p>${info}</p>
               
               <c:if test="${notAdmin != null}">
            <div class="alert alert-danger" role="alert">
               <p>${notAdmin}</p>
            </div>
         </c:if> 
            </div>
         </c:if>
       
                        
                    
      <h1>Welcome to IT Shop!</h1>

      <p>Thanks for visiting. Make yourself at home. Feel free to browse through 
         our products catalog. When you do, you can choose whatever product you like. There are descriptions and other information.</p>

      <p>This is a Java Web project made by Margus Koppel, JKTVR17 in 2018. You can find a Github link below.</p>
                 

   </div>
</div>


<jsp:include page="/footer.jsp" />