<%@ page import="com.example.demoApp.Domain.Faculty" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="sections">
        <section class="list-section">
        <aside class="leftAside">
            <h3>Список факультетов</h3>
            <table class="entity-list">
                <thead>
                <tr>
                    <th scope="col">Код</th>
                    <th scope="col">Полное наименование</th>
                    <th scope="col">Краткое наименование</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="fac" items="${faculties}">
                    <tr>
                        <td>${fac.getId()}</td>
                        <td>${fac.getNameFaculty()}</td>
                        <td>${fac.getShortNameFaculty()}</td>
                        <td> <a href='/delete?id=${fac.getId()}&tableName=Faculty&redirectPage=Faculty' onclick="return confirm('Удалить выбранный факультет?')" style="color: #ff0000">Удалить</a></td>
                        <td><a href="/EditFaculty?id=${fac.id}">Редактировать.</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>
        <section class="add-section">
        <article>
            <h3>Данные о факультете</h3>
            <div class="text-article">
                <form method="POST" action="">
                    <p>
                        <label>Наименование Факультета
                            <input type="text" name="nameFaculty" />
                        </label>
                    </p>
                    <p>
                        <label for>Краткое Наименование Факультета
                            <input type="text" name="nameShortFaculty" />
                        </label>
                    </p>
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
