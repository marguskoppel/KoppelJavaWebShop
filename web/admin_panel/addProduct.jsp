<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${sessionScope.admin != null}">
<jsp:include page="/admin_panel/header.jsp" />



<div class="container">
    <div class="page-header centre-align">
        <h1>Add product</h1>
    </div>
    <div class="table-responsive">
        <form method='post' action="createProduct" name="form1" onsubmit="return validate();" id="form1">
            <table class='table table-hover'>
                <tr>
                    <td>Product name</td>
                    <td><input type='text' name='nameProduct' class='form-control' required></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><textarea rows="5" name="description" class='form-control' required></textarea></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="number"  class='form-control' name="price" required=""></td>
                </tr>
                <tr>
                    <td>Count</td>
                    <td><input type="number"  class='form-control' name="count" required=""></td>
                </tr>

                <tr>
                    <td colspan="2">
                        <button type="submit" class="btn btn-primary" name="save">
                            <span class="glyphicon glyphicon-plus"></span> Save
                        </button>  
                        <a href="admin_products" class="btn btn-large btn-success">
                        <i class="glyphicon glyphicon-backward"></i> &nbsp;Back</a>

                    </td>
                </tr>
            </table>
        </form> 
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/newProduct.js"></script>


<jsp:include page="/footer.jsp" />
</c:when>
<c:otherwise>
    <jsp:include page="/noRights.jsp" />
</c:otherwise>
</c:choose>