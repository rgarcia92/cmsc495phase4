<%-- 
    Document   : adminCreateUser
    Created on : Jul 11, 2017, 4:04:34 PM
    Author     : Rob Garcia at rgarcia92.student.umuc.edu
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMSC 495 EMR Project | Admin Menu</title>
        <jsp:include page="masters/adminHead.jsp" />
    </head>
    <body>
        <!-- This needs to stay here since you cannot redirect from an included file -->
        <!-- Redirect if mobile -->
        <c:set var="browser" value="${header['User-Agent']}" scope="session" />
        <c:if test = "${fn:containsIgnoreCase(browser, 'mobi')}">
            <c:redirect url="/mobileHome.jsp"/>
        </c:if>
        <!-- Redirect if not authenticated -->
        <c:if test="${sessionScope['loggedIn'] != true}">
            <c:redirect url="/login.jsp" />
        </c:if>
        <noscript>
            <p class="warningText">(Javascript disabled. Please enable Javascript for full functionality)</p>
        </noscript>
        <header>
            <h1>CMSC 495 Electronic Medical Reference Project</h1>
            <h2>Create User</h2>
        </header>
        <main>
            <c:catch var="catchException">
            <div style="text-align: left; width: 100%;">
            <c:choose>
                <c:when test="${empty fn:escapeXml(param.userName) or
                              empty fn:escapeXml(param.roleID)}">
                    <c:redirect url="adminAddUser.jsp" >
                        <c:param name="errorMessage" value="All fields must be filled in" />
                    </c:redirect>
                </c:when>
                <c:otherwise>
                    <jsp:useBean id="dataAccess" class="com.cmsc495phase4.models.DataAccess">
                        <jsp:setProperty name="dataAccess" property="*" />
                    </jsp:useBean>
                    <c:choose>
                        <c:when test="${dataAccess.insertUser(fn:escapeXml(param.userName), 
                                        fn:escapeXml(param.roleID))}">
                            <c:redirect url="adminAddUser.jsp" >
                                <c:param name="errorMessage" value="User Added!" />
                            </c:redirect>
                        </c:when>
                        <c:otherwise>
                            <c:redirect url="adminAddUser.jsp" >
                                <c:param name="errorMessage" value="Unable to add user to database" />
                            </c:redirect>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
            </div>
            </c:catch>
            <p>${catchException == null ? '' : catchException.message}</p>
        </main>
        <footer>
            <jsp:include page="masters/adminFooter.jsp" />
        </footer>
    </body>
</html>