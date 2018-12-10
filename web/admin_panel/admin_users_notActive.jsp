
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
                        <h4>Not active users</h4>
                        <a href="admin_users" class="btn btn-primary" role="button">Active Users</a>
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
                                <c:forEach var="userNotActive" items="${usersNotActive}">
                                    <tr>
                                        <td>${userNotActive.name}</td>
                                        <td>${userNotActive.surname}</td>
                                        <td>${userNotActive.phone}</td>
                                        <td>${userNotActive.city}</td>
                                        <c:if test="${sessionScope.admin != null}">
                                            <td><form action="activateUser?au=${userNotActive.id}" method="post">
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
