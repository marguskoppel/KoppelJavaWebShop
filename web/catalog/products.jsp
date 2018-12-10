
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp" />



<div class="container">
    <c:choose>
        <c:when test="${products == null}">
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
                <h1>Our products</h1>
            </div>
            <div class="table-responsive"> 
                

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Count</th>
                                    <c:if test="${sessionScope.user != null}">
                                    <th>Set quantity</th>
                                    <th>Buy</th>
                                    </c:if>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${products}">
                                <tr>
                                    <td>${product.nameProduct}</td>
                                    <td>${product.description}</td>
                                    <td>${product.price} &euro;</td>
                                    <td>${product.count} items available</td>
                                    <c:if test="${sessionScope.user != null}">
                                    <form method='post' action="purchase?p=${product.id}&p2=${user.id}">
                                        <td><input type="number"  min="1" value="1" class='form-control' name="quantity" required=""></td>
                                        <td><button name="save" class="btn btn-primary" type="submit">Purchase</button></td>
                                    </form>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                
            </div>
        </c:otherwise>
    </c:choose> 
</div>

<jsp:include page="/footer.jsp" />
