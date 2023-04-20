
<%@ page import="java.util.Date" %>
<%@ page import="com.example.demoApp.Domain.Discipline" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Discipline discipline1 = new Discipline(1l, "Дисциплина 1",1,1,1,1,1,"Экзамен1", "Зачет1");
    Discipline discipline2 = new Discipline(2l, "Дисциплина 2",2,2,2,2,2,"Экзамен2", "Зачет2");
    Discipline discipline3 = new Discipline(2l, "Дисциплина 3",3,3,3,3,3,"Экзамен3", "Зачет3");
    Discipline[] disciplines = new Discipline[]{discipline1, discipline2, discipline3};
    pageContext.setAttribute("disciplines",disciplines);
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Дисциплины</title>
<head>
    <meta charset="UTF-8">
    <title>Дисциплины</title>
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
                    <th scope="col">Название дисциплины</th>
                    <th scope="col">№ Курса</th>
                    <th scope="col">№ Семестра</th>
                    <th scope="col">Кол-во Лекций</th>
                    <th scope="col">Кол-во Лаб. занятий</th>
                    <th scope="col">Кол-во Практических занятий</th>
                    <th scope="col">Экзамен</th>
                    <th scope="col">Зачет</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="discipline" items="${disciplines}">
                    <tr>
                        <td>${discipline.getId()}</td>
                        <td>${discipline.getNameDiscipline()}</td>
                        <td>${discipline.getCourse()}</td>
                        <td>${discipline.getSemester()}</td>
                        <td>${discipline.getLecture()}</td>
                        <td>${discipline.getLaboratory()}</td>
                        <td>${discipline.getPractical()}</td>
                        <td>${discipline.getExamen()}</td>
                        <td>${discipline.getSetOff()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>
    <section>
        <article>
            <h3>Данные о Дисциплине</h3>
            <div class="text-article">
                <form method="POST" action="">
                    <p>
                        <label >Название дисциплины
                            <input type="text" name="NameDiscipline" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label>№ Курса
                            <input type="number" name="Course" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label>№ Семестра
                            <input type="number" name="Semester" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label>Кол-во лекций
                            <input type="number" name="Lecture" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label >Кол-во Лаб. занятий
                            <input type="number" name="Laboratory" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label >Кол-во Практических занятий
                            <input type="number" name="Practical" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label >Экзамен
                            <input type="text" name="Examen" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
                    <p>
                        <label >Зачет
                            <input type="text" name="setOff" />
                        </label>
                    </p>
                </form>
                <form method="POST" action="">
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
