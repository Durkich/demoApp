<%@ page import="com.example.demoApp.Domain.Chair" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="chair" items="${chairs}">
                    <tr>
                        <td>${chair.getId()}</td>
                        <td>${chair.getNameChair()}</td>
                        <td>${chair.getShortNameChair()}</td>
                        <td>${chair.getFacultyName()}</td>
                        <td> <a href='/delete?id=${chair.getId()}&tableName=Chair&redirectPage=Chair' onclick="return confirm('Удалить выбранную кафедру?')" style="color: #ff0000">Удалить</a></td>
                        <td><a href="/EditChair?id=${chair.id}">Редактировать.</a></td>
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
                            <input type="text" name="nameChair" />
                        </label>
                    </p>
                    <p>
                        <label for>Краткое Наименование Кафедры
                            <input type="text" name="nameShortChair" />
                        </label>
                    </p>
                    <label>Факультет
                        <select name="faculty">
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
