
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${sessionScope.admin != null}">
<jsp:include page="/admin_panel/header.jsp" />



<div class="container">
    <c:choose>
        <c:when test="${info_products == null}">
            <div class="page-header">
                <h1>No products found</h1>
            </div>
            <p>
                Unfortunately there are no product available  right now.

            </p>
        </c:when>
        <c:otherwise>

            <c:if test="${productCreate != null}">
                <div class="alert alert-success" role="alert">
                    <p>${productCreate}</p>
                </div>
            </c:if>


            <div class="page-header centre-align">
                <h1>Manage products</h1>
            </div>
            <div class="page-header centre-align">
                <h4>Active products</h4>
                <a href="notActive" class="btn btn-primary" role="button">Not Active products</a>
            </div>
            <a href="addProduct" class="btn btn-primary" role="button">Add</a>
            <div class="table-responsive"> 

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Count</th>
                            <th>Manage</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${products}">
                            <tr>
                                <td>${product.nameProduct}</td>
                                <td>${product.description}</td>
                                <td>${product.price} &euro;</td>
                                <td>${product.count} items available</td>
                                <c:if test="${sessionScope.admin != null}">
                                    <td><a href="editProduct?ep=${product.id}" class="btn btn-warning" role="button">Edit</a> <a href="deleteProduct?dp=${product.id}" class="btn btn-danger" role="button">Delete</a></td>
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
</c:when>
<c:otherwise>
    <jsp:include page="/noRights.jsp" />
</c:otherwise>
</c:choose>
