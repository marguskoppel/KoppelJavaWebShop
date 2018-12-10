
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${sessionScope.admin != null}">
        <jsp:include page="/admin_panel/header.jsp" />



        <div class="container">
            <c:choose>
                <c:when test="${info_users == null}">
                    <div class="page-header">
                        <h1>No users found</h1>
                    </div>
                    <p>
                        Unfortunately there are no registered users right now.

                    </p>
                </c:when>
                <c:otherwise>
                    <div class="page-header centre-align">
                        <h1>Manage users</h1>
                    </div>
                    <div class="page-header centre-align">
                        <h4>Active users</h4>
                        <a href="usersNotActive" class="btn btn-primary" role="button">Not Active Users</a>
                    </div>
                    <div class="table-responsive"> 

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Phone number</th>
                                    <th>City</th>
                                    <th>Manage</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${users}">
                                    <tr>
                                        <td>${user.name}</td>
                                        <td>${user.surname}</td>
                                        <td>${user.phone}</td>
                                        <td>${user.city}</td>
                                        <c:if test="${sessionScope.admin != null}">
                                            <td><a href="userPurchase?up=${user.id}" class="btn btn-primary" role="button">Purchases</a><a href="editUser?eu=${user.id}" class="btn btn-warning" role="button">Edit</a> <a href="deleteUser?du=${user.id}" class="btn btn-danger" role="button">Delete</a></td>
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
