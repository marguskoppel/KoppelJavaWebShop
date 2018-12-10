

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-GB">
   <head>
      <title>JavaWebShop</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta name="author" content="M. Koppel" />

      <!-- jQuery -->
      <script src="<c:url value='/js/showLogin.js' />"</script>
      <script src="<c:url value='/includes/js/jquery-2.1.4.min.js' />"></script>
      
      

      <!-- Bootstrap -->
      <link href="<c:url value='/includes/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" />
      <script src="<c:url value='/includes/bootstrap/js/bootstrap.min.js' />"></script> 
      
      <link href="<c:url value='/includes/css/style.css' />" rel="stylesheet" />
      
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
 
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>

      
      <!--<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/af-2.3.2/b-1.5.4/cr-1.5.0/fc-3.2.5/fh-3.1.4/kt-2.5.0/r-2.2.2/rg-1.1.0/rr-1.2.4/sc-1.5.0/sl-1.2.6/datatables.min.css"/>
 
       <!--<script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/af-2.3.2/b-1.5.4/cr-1.5.0/fc-3.2.5/fh-3.1.4/kt-2.5.0/r-2.2.2/rg-1.1.0/rr-1.2.4/sc-1.5.0/sl-1.2.6/datatables.min.js"></script>

      
      <!-- Font awesome -->
      <link href="<c:url value='/includes/css/font-awesome.min.css' />" rel="stylesheet" />
      
      <!-- jQuery script which makes appropriate navbar tab active -->
      <script>
         var j$ = jQuery.noConflict();
         j$(document).ready(function() {
            j$(".nav").find(".active").removeClass("active");
            var url = j$(location).attr('href');
            if (url.indexOf("products") >= 0) {
               j$("#catalog").addClass("active");
            } else if (url.indexOf("userInfo") >= 0) {
               j$("#userInfo").addClass("active");
            } else if (url.indexOf("contact") >= 0) {
               j$("#contact").addClass("active");
            } else if (url.indexOf("logout") >= 0) {
               j$("#logout").addClass("active");
            } else {
               j$("#home").addClass("active");
            }
         });
      </script>
      
   </head>
   <body>
      <div class="navbar navbar-default">
         <div class="container">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="<c:url value='/' />">Java Web Shop</a>
            </div>
            <div class="collapse navbar-collapse">
               <ul class="nav navbar-nav">
                  <li id="home"><a href="<c:url value='/' />">Home</a></li>
                  <li id="catalog"><a href="<c:url value='/products' />">Catalog</a></li>
                  
                  <li id="contact"><a href="<c:url value='/contact' />">Contact</a></li> 
               </ul>
               <ul class="nav navbar-nav navbar-right">
                  
                  <c:choose>
                  <c:when test="${sessionScope.user != null || sessionScope.admin != null}">
                      <li id='userInfo'><a href="<c:url value='/userInfo?userI=${user.id}' />">${user.getName()}</a></li>
                        <li id="logout"><a href="<c:url value='/logout' />">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                  <li id=""><a href="<c:url value='/loginPage' />">Login</a></li>
                  <li id=""><a href="<c:url value='/registerPage' />">Register</a></li>
                  </c:otherwise>
                  </c:choose>
               </ul>
            </div>
         </div>
      </div>
                  
