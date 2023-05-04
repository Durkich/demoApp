<%@ page import="com.example.demoApp.Domain.Chair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--  Chair chair1 = new Chair(1l,"Кафедра 1","Каф 1");--%>
<%--  Chair chair2 = new Chair(2l,"Кафедра 2","Каф 2");--%>
<%--  Chair chair3 = new Chair(3l,"Кафедра 3","Каф 3");--%>
<%--  Chair[] chairs = new Chair[]{chair1,chair2,chair3};--%>
<%--  pageContext.setAttribute("chairs",chairs);--%>
<%--%>--%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Кафедры</title>
<head>
    <meta charset="UTF-8">
    <title>Кафедры</title>
</head>
<body>
<jsp:include page="/jspf/header.jsp" />
<div id="main">
    <div class="sections">
        <section class="list-section">
        <aside class="leftAside">
            <h3>Кафедры</h3>
            <table class="entity-list">
                <thead>
                <tr>
                    <th scope="col">Код</th>
                    <th scope="col">Полное наименование</th>
                    <th scope="col">Краткое наименование</th>
                    <th scope="col">Факультет</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="chair" items="${chairs}">
                    <tr>
                        <td>${chair.getId()}</td>
                        <td>${chair.getNameChair()}</td>
                        <td>${chair.getShortNameChair()}</td>
                        <td>${chair.getFacultyName()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>
        <section class="add-section">
        <article>
            <h3>Данные о кафедре</h3>
            <div class="text-article">
                <form method="POST" action="">
                    <p>
                        <label>Наименование Кафедры
                            <input type="text" name="nameFaculty" />
                        </label>
                    </p>
                    <p>
                        <label for>Краткое Наименование Кафедры
                            <input type="text" name="nameShortFaculty" />
                        </label>
                    </p>
                    <label>Факультет
                        <select name="type">
                            <option disabled>Выберите факультет</option>
                            <c:forEach var="fac" items="${facultyNames}">
                                <option>
                                        ${fac}
                                </option>
                            </c:forEach>
                        </select>
                    </label>
                    <p>
                        <button type="submit">Добавить</button>
                    </p>
                </form>
            </div>
        </article>
    </section>

</div>
<jsp:include page="/jspf/footer.jsp" />
</body>
</html>
