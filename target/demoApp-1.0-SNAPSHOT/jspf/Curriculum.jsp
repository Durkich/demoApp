<<%@ page import="com.example.demoApp.Domain.Curriculum" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--    Curriculum curriculum1 = new Curriculum(1l,2023, "Специальность 1", "Квалификация1", "Очная", "План 1", 1);--%>
<%--    Curriculum curriculum2 = new Curriculum(2l,2023, "Специальность 2", "Квалификация2", "Очная", "План 2", 1);--%>
<%--    Curriculum curriculum3 = new Curriculum(3l,2023, "Специальность 3", "Квалификация3", "Очная", "План 3", 1);--%>
<%--    Curriculum[] curriculums = new Curriculum[]{curriculum1,curriculum2,curriculum3};--%>
<%--    pageContext.setAttribute("curriculums",curriculums);--%>
<%--%>--%>
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
    <section>
        <aside class="leftAside">
            <h3>Список учебных планов</h3>
            <table>
                <thead>
                <tr>
                    <th scope="col">Код</th>
                    <th scope="col">Учебный год</th>
                    <th scope="col">Направление подготовки</th>
                    <th scope="col">Квалификация</th>
                    <th scope="col">Форма обучения</th>
                    <th scope="col">Имя плана</th>
                    <th scope="col">Курс</th>
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>
    <section>
        <article>
            <h3>Данные о Учебном плане</h3>
            <div class="text-article">
                <form method="POST" action="">
                    <p>
                        <label >Учебный год
                            <input type="number" name="academicYear" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label> Направление подготовки
                            <input type="text" name="Speciality" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label>Квалификация
                            <input type="text" name="Quialification" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label>Имя плана
                            <input type="text" name="NameCircullum" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label >Курс
                            <input type="text" name="Course" />
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
