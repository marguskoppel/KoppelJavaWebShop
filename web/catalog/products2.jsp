

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp" />
<div class="container">
   <c:choose>
      <c:when test="${products2 == null}">
         <div class="page-header">
            <h1>No products found</h1>
         </div>
         <p>
            Unfortunately there are no product available for purchase right now.
            Please visit our shop later. 
         </p>
      </c:when>
      <c:otherwise>
         <div class="page-header centre-align">
            <h1>The Music Store Catalog</h1>
         </div>
         <div class="row">
            <c:forEach var="product2" items="${products2}">
               <div class="col-sm-6 col-md-4">
                  <div class="thumbnail">
                     <img style="width:auto; height:200px;" src="img/${product2.image}" alt="Cover Image">
                     <div class="caption">
                        <h3>${product2.nameProduct}</h3>
                        <p>${product2.price} &euro;</p>
                        <a href="<c:url value='single_product?sp=${product2.id}' />" class="btn btn-primary btn-block">More</a>
                     </div>
                  </div>
               </div>  
            </c:forEach>
         </div>
      </c:otherwise>
   </c:choose>
</div>

<jsp:include page="/footer.jsp" />