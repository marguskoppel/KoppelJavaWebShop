
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${sessionScope.admin != null}">
        <jsp:include page="/admin_panel/header.jsp" />



        <div class="container">
            <c:choose>
                <c:when test="${info_purchases == null}">
                    <div class="page-header">
                        <h1>No purchases found</h1>
                    </div>
                    <p>
                        Unfortunately there are no purchases made.

                    </p>
                </c:when>
                <c:otherwise>
                    <div class="page-header centre-align">
                        <h1>Purchases</h1>
                    </div>
                    <div class="table-responsive"> 

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Description</th>
                                    <th>Date</th>
                                    <th>Quantity</th>
                                    <th>Total amount</th>


                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="purchase" items="${purchasesA}">
                                    <tr>
                                        <td>${purchase.product.nameProduct}</td>
                                        <td>${purchase.product.description}</td>
                                        <td>${purchase.dateBegin}</td>
                                        <td>${purchase.quantity}</td>
                                        <td>${purchase.total} &euro;</td>

                                        <c:if test="${sessionScope.admin != null}">

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
