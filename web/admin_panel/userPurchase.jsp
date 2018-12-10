

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${sessionScope.admin != null}">
        <jsp:include page="/admin_panel/header.jsp" />

        <div class="container">

            <div class="page-header centre-align">
                <h1>User purchases</h1>
            </div>
            <div class="table-responsive"> 

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>User</th>
                            <th>Product</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th>Quantity</th>
                            <th>Total amount</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="purchase" items="${purchaseUser}">
                            <tr>
                                <td>${purchase.user.login}</td>
                                <td>${purchase.product.nameProduct}</td>
                                <td>${purchase.product.description}</td>
                                <td>${purchase.dateBegin}</td>
                                <td>${purchase.quantity}</td>
                                <td>${purchase.total} &euro;</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="2">  
                                <a href="admin_users" class="btn btn-large btn-success">
                                    <i class="glyphicon glyphicon-backward"></i> &nbsp;Back</a>

                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

        </div>






        <jsp:include page="/footer.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="/noRights.jsp" />
    </c:otherwise>
</c:choose>
