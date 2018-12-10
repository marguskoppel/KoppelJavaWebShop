
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${sessionScope.admin != null}">
        <jsp:include page="/admin_panel/header.jsp" />



        <div class="container">
            <c:choose>
                <c:when test="${info_notActive == null}">
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
                        <h4>Not active products</h4>
                        <a href="admin_products" class="btn btn-primary" role="button">Active products</a>
                    </div>

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
                                <c:forEach var="productNotActive" items="${productsNotActive}">
                                    <tr>
                                        <td>${productNotActive.nameProduct}</td>
                                        <td>${productNotActive.description}</td>
                                        <td>${productNotActive.price} &euro;</td>
                                        <td>${productNotActive.count} items available</td>
                                        <c:if test="${sessionScope.admin != null}">

                                            <td><form action="activateProduct?ap=${productNotActive.id}" method="post">
                                                    <input role="button" class="btn btn-warning" type="submit" name="save" value="SET TO ACTIVE" />
                                                </form></td>
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
