
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${sessionScope.admin != null}">
        <jsp:include page="/admin_panel/header.jsp" />

        <div class="container">
            <div class="page-header centre-align">
                <h1>Edit user</h1>
            </div>
            <div class="table-responsive">

                <form method='post' action="editU?euId=${userEdit.id}" >
                    <table class='table table-hover'>
                        <tr>
                            <td>User name</td>
                            <td><input type='text' name='name' value="${userEdit.name}" class='form-control' required></td>
                        </tr>
                        <tr>
                            <td>Surname</td>
                            <td><input type='text' name='surname' value="${userEdit.surname}" class='form-control' required></td>
                        </tr>
                        <tr>
                            <td>Phone</td>
                            <td><input type="text"  value="${userEdit.phone}" class='form-control' name="phone" required=""></td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td><input type="text"  value="${userEdit.city}" class='form-control' name="city" required=""></td>
                        </tr>

                        <tr>
                            <td colspan="2">
                                <button type="submit" class="btn btn-warning" name="save">
                                    <span class="glyphicon glyphicon-edit"></span> Edit
                                </button>  
                                <a href="admin_users" class="btn btn-large btn-success">
                                    <i class="glyphicon glyphicon-backward"></i> &nbsp;Back</a>

                            </td>
                        </tr>
                    </table>
                </form> 
            </div>
        </div>

        <jsp:include page="/footer.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="/noRights.jsp" />
    </c:otherwise>
</c:choose>