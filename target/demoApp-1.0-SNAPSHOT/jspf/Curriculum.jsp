<<%@ page import="com.example.demoApp.Domain.Curriculum" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Учебные планы</title>
<head>
    <meta charset="UTF-8">
    <title>Учебные планы</title>
</head>
<body>
<jsp:include page="/jspf/header.jsp" />
<div id="main">
    <div class="sections">
        <section class="list-section">
        <aside class="leftAside">
            <h3>Список учебных планов</h3>
            <table class="entity-list">
                <thead>
                <tr>
                    <th scope="col">Код</th>
                    <th scope="col">Учебный год</th>
                    <th scope="col">Направление подготовки</th>
                    <th scope="col">Квалификация</th>
                    <th scope="col">Форма обучения</th>
                    <th scope="col">Имя плана</th>
                    <th scope="col">Курс</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cir" items="${curricula}">
                    <tr>
                        <td>${cir.getId()}</td>
                        <td>${cir.getAcademicYear()}</td>
                        <td>${cir.getSpeciality()}</td>
                        <td>${cir.getQualification()}</td>
                        <td>${cir.getFormEducation()}</td>
                        <td>${cir.getNameCurriculum()}</td>
                        <td>${cir.getCourse()}</td>
                        <td> <a href='/delete?id=${cir.getId()}&tableName=Curriculum&redirectPage=Curriculum' onclick="return confirm('Удалить выбранный учебный план?')" style="color: #ff0000">Удалить</a></td>
                        <td><a href="/EditCurriculum?id=${cir.id}">Редактировать.</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>
        <section class="add-section">
        <article>
            <h3>Данные о Учебном плане</h3>
            <div class="text-article">
                <form method="POST" action="">
                    <p>
                        <label >Учебный год
                            <input type="number" name="academicYear" />
                        </label>
                    </p>
                    <p>
                        <label> Направление подготовки
                            <input type="text" name="Speciality" />
                        </label>
                    </p>
                    <p>
                        <label>Квалификация
                            <input type="text" name="Quialification" />
                        </label>
                    </p>
                    <p>
                        <label>Форма обучения
                            <input type="text" name="formEducation" />
                        </label>
                    </p>
                    <p>
                        <label>Имя плана
                            <input type="text" name="NameCircullum" />
                        </label>
                    </p>
                    <p>
                        <label >Курс
                            <input type="number" name="Course" />
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
