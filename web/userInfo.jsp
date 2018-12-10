

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp" />

<div class="container">

    <div class="page-header centre-align">
        <h1>Profile Information</h1>
    </div>
    <div class="table-responsive"> 

        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Phone</th>
                    <th>City</th>

                </tr>
            </thead>
            <tbody>

                <tr>
                    <td>${user.getName()}</td>
                    <td>${user.getSurname()}</td>
                    <td>${user.getPhone()}</td>
                    <td>${user.getCity()}</td>

                </tr>

            </tbody>
        </table>
    </div>
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
                <c:forEach var="userPurchase" items="${usersInfo}">
                    <tr>
                        <td>${userPurchase.product.nameProduct}</td>
                        <td>${userPurchase.product.description}</td>
                        <td>${userPurchase.dateBegin}</td>
                        <td>${userPurchase.quantity}</td>
                        <td>${userPurchase.total} &euro;</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>






<jsp:include page="/footer.jsp" />
