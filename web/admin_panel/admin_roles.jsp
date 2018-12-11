
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
    <c:when test="${sessionScope.admin != null}">
        <jsp:include page="/admin_panel/header.jsp" />



        <div class="container">

            <div class="page-header centre-align">
                <h1>Manage roles</h1>
            </div>
            <div class="page-header centre-align">
                <h4>Add / Delete roles</h4>
            </div>
            <div class="table-responsive">

                <form method='post' action="createRole" >
                    <table class='table table-hover'>
                        <tr>
                            <td>Create new role</td>
                            <td><input type='text' name='nameRole' value="" class='form-control' ></td>
                            <td colspan="2">
                                <button type="submit" class="btn btn-primary" name="save">
                                    <span class="glyphicon glyphicon-edit"></span> Add role
                                </button>  
                            </td>
                        </tr>                       

                    </table>
                </form> 
            </div>

            <div class="table-responsive">

                <form method='post' action="deleteRole" >
                    <table class='table table-hover'>
                        <tr>
                            <td>Delete role</td>
                            <td><select name="role" style:="width: 300px;">
                                    <option value="" disabled selected hidden ></option>
                                    <c:forEach var="role" items="${listRoles}">
                                        <option  value="${role.id}">${role.name}</option>
                                    </c:forEach>
                                </select></td>
                            <td colspan="2">
                                <button type="submit" class="btn btn-danger" name="save">
                                    <span class="glyphicon glyphicon-edit"></span> Delete role
                                </button>  
                            </td>
                        </tr>                       

                    </table>
                </form> 
            </div>
            <div class="page-header centre-align">
                <h4>Managing user roles</h4>
            </div>


            <form method="post" action="changeUsersRoles">

                <div class="table-responsive"> 

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Users</th>
                                <th>Roles</th>
                                <th>Assign role</th>
                                <th>Remove role</th>


                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td><select name="userSetRole">
                                        <option value="" disabled selected hidden></option>
                                        <c:forEach var="entry" items="${mapUsersRoles}">
                                            <option value="${entry.key.id}">${entry.key.login}, role: ${entry.value} </option>
                                        </c:forEach>
                                    </select></td>
                                

                                <td><select name="roleSetToUser" >
                                        <option value="" disabled selected hidden ></option>
                                        <c:forEach var="role" items="${listRoles}">
                                            <option  value="${role.id}">${role.name}</option>
                                        </c:forEach>
                                    </select></td>
                                    <c:if test="${sessionScope.admin != null}">
                                    <td><input type="submit" name="setRoleButton" class="btn btn-primary" role="button" value="SET ROLE"></td>
                                    <td><input type="submit" name="delRoleButton" class="btn btn-danger" role="button" value="REMOVE ROLE"></td>
                                </c:if>
                            </tr>

                        </tbody>
                    </table>

                </div>
            </form>
        </div>

        <jsp:include page="/footer.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="/noRights.jsp" />
    </c:otherwise>
</c:choose>
