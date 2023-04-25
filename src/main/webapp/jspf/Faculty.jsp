<%@ page import="com.example.demoApp.Domain.Faculty" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--    Faculty Faculty1 = new Faculty(1L, "Факультет1", "Факулт1");--%>
<%--    Faculty Faculty2 = new Faculty(2L, "Факультет2", "Факулт2");--%>
<%--    Faculty Faculty3= new Faculty(3L, "Факультет3", "Факулт3");--%>
<%--    Faculty[] facs = new Faculty[]{Faculty1,Faculty2,Faculty3};--%>
<%--    pageContext.setAttribute("facs",facs);--%>
<%--%>--%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Факультеты</title>
<head>
    <meta charset="UTF-8">
    <title>Факультеты</title>
</head>
<body>
<jsp:include page="/jspf/header.jsp" />
<div id="main">
    <section>
        <aside class="leftAside">
            <h3>Список факультетов</h3>
            <table>
                <thead>
                <tr>
                    <th scope="col">Код</th>
                    <th scope="col">Полное наименование</th>
                    <th scope="col">Краткое наименование</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="fac" items="${faculties}">
                    <tr>
                        <td>${fac.getId()}</td>
                        <td>${fac.getNameFaculty()}</td>
                        <td>${fac.getShortNameFaculty()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>
    <section>
        <article>
            <h3>Данные о факультете</h3>
            <div class="text-article">
                <form method="POST" action="">
                    <p>
                        <label>Наименование Факультета
                            <input type="text" name="nameFaculty" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label for>Краткое Наименование Факультета
                            <input type="text" name="nameShortFaculty" />
                        </label>
                    </p>
                </form>
                <p>
                    <button type="submit">Добавить</button>
                </p>
            </div>
        </article>
    </section>

</div>
<jsp:include page="/jspf/footer.jsp" />
</body>
</html>
