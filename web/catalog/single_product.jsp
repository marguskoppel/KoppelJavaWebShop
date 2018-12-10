<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/header.jsp" />

<div class="container push_down">
   <div class="row">
      <div class="col-sm-8">
         <h1>${singleProduct.nameProduct}</h1>
         <h3>${singleProduct.price}</h3>
         <p class="larger_p">${singleProduct.description}</p>
      </div>
      <div class="col-sm-4">
         <img class="img-thumbnail" src="img/${singleProduct.image}" alt="Cover Image" />
      </div>
   </div>
   <div class="row push_down">
      <div class="col-sm-8">
      </div>
      <div class="col-sm-4">
         <p class="price">${singleProduct.price}</p>
         
         <a href="purchase?p=${singleProduct.id}&p2=${user.id}" class="btn btn-primary" role="button">Purchase</a>
      </div>
   </div>
</div>

<jsp:include page="/footer.jsp" />