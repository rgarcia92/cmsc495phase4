<%-- 
    Document   : loginAuthenticate
    Created on : Jun 30, 2017, 12:25:29 PM
    Author     : Rob Garcia at rgarcia92.student.umuc.edu
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CMSC 495 EMR Project | Authentication Page</title>
        <jsp:include page="masters/desktopHead.jsp" />
    </head>
    <body>
        <!-- This needs to stay here since you cannot redirect from an included file -->
        <!-- Redirect if mobile -->
        <c:set var="browser" value="${header['User-Agent']}" scope="session" />
        <c:if test = "${fn:containsIgnoreCase(browser, 'mobi')}">
            <c:redirect url="/mobileHome.jsp"/>
        </c:if>
        <noscript>
            <p class="warningText">(Javascript disabled. Please enable Javascript for full functionality)</p>
        </noscript>
        <header>
            <h1>CMSC 495 Electronic Medical Reference Project</h1>
            <h2>Authentication Page</h2>
        </header>
        <main>
            <c:catch var="catchException">
            <c:if test="${empty fn:escapeXml(param.uname) or empty fn:escapeXml(param.pword)}">
                <c:redirect url="login.jsp" >
                    <c:param name="errorMessage" value="Please enter your user name and password" />
                </c:redirect>
            </c:if>
            <c:if test="${not empty fn:escapeXml(param.uname) and not empty fn:escapeXml(param.pword)}">
                <jsp:useBean id="utilities" class="com.cmsc495phase4.models.Utilities">
                    <jsp:setProperty name="utilities" property="*" />
                </jsp:useBean>
                <jsp:useBean id="dataAccess" class="com.cmsc495phase4.models.DataAccess">
                    <jsp:setProperty name="dataAccess" property="*" />
                </jsp:useBean>
                <!-- Authenticate user and set session variables -->
                <c:choose>
                    <c:when test="${utilities.authenticate(fn:escapeXml(param.uname), fn:escapeXml(param.pword))}">
                        <c:set var="u" value="${dataAccess.selectUser(fn:escapeXml(param.uname))}" />
                        <c:set scope="session" var="loggedIn" value="true" />
                        <c:set scope="session" var="uname" value="${u.userName}" />
                        <c:set scope="session" var="role" value="${u.role}" />
                        <c:set scope="session" var="lockedOut" value="${u.lockedOut}" />
                        <c:set scope="session" var="lastLogin" value="${u.lastLogin}" />
                        ${utilities.logEvent(String.format("%s logged in", param.uname))}
                        <c:redirect url="adminMenu.jsp"/>
                    </c:when>
                    <c:otherwise>
                        ${utilities.logEvent("Invalid login attempt")}
                        <c:redirect url="login.jsp" >
                            <c:param name="errorMessage" value="Invalid username or password" />
                        </c:redirect>
                    </c:otherwise>
                </c:choose>
            </c:if>
            </c:catch>
            <p>${catchException == null ? '' : catchException.message}</p>
        </main>
        <footer>
            <jsp:include page="masters/desktopFooter.jsp" />
        </footer>
    </body>
</html>