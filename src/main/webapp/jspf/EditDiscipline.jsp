<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="sections">
        <section class="list-section">
            <aside class="leftAside">
                <h3>Список Дисциплин</h3>
                <table class="entity-list">
                    <thead>
                    <tr>
                        <th scope="col">Код</th>
                        <th scope="col">Название дисциплины</th>
                        <th scope="col">№ Курса</th>
                        <th scope="col">№ Семестра</th>
                        <th scope="col">Кол-во Лекций</th>
                        <th scope="col">Кол-во Лаб. занятий</th>
                        <th scope="col">Кол-во Практических занятий</th>
                        <th scope="col">Тип аттестации</th>
                        <th scope="col">Кафедра</th>
                        <th scope="col">Учебный план</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
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
                            <td>${discipline.getDisciplineType()}</td>
                            <td>${discipline.getNameChair()}</td>
                            <td>${discipline.getNameCurriculum()}</td>
                            <td> <a href='/delete?id=${discipline.getId()}&tableName=Discipline&redirectPage=Discipline' onclick="return confirm('Удалить выбранную дисциплину?')" style="color: #ff0000">Удалить</a></td>
                            <td><a href="/EditDiscipline?id=${discipline.id}">Редактировать.</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </aside>
        </section>
        <section class="add-section">
            <article>
                <h3>Изменить Дисциплину</h3>
                <div class="text-article">
                    <form method="POST" action="">
                        <p>
                            <label >Название дисциплины
                                <input value="${editDiscipline.getNameDiscipline()}" type="text" name="NameDiscipline" />
                            </label>
                        </p>
                        <p>
                            <label>№ Курса
                                <input value="${editDiscipline.getCourse()}" type="number" name="Course" />
                            </label>
                        </p>
                        <p>
                            <label>№ Семестра
                                <input value="${editDiscipline.getSemester()}" type="number" name="Semester" />
                            </label>
                        </p>
                        <p>
                            <label>Кол-во лекций
                                <input value="${editDiscipline.getLecture()}" type="number" name="Lecture" />
                            </label>
                        </p>
                        <p>
                            <label >Кол-во Лаб. занятий
                                <input value="${editDiscipline.getLaboratory()}" type="number" name="Laboratory" />
                            </label>
                        </p>
                        <p>
                            <label >Кол-во Практических занятий
                                <input value="${editDiscipline.getPractical()}" type="number" name="Practical" />
                            </label>
                        </p>
                        <label>Тип аттестация
                            <select name="disciplinesType">
                                <option disabled>Выберите Тип аттестация</option>
                                <c:forEach var="disciplineType" items="${disciplinesType}">
                                    <option <c:if test="${editDiscipline.getDisciplineType() == disciplineType }">selected</c:if>>
                                            ${disciplineType}
                                    </option>
                                </c:forEach>
                            </select>
                            <p>
                        </label>
                        <label>Кафедра
                            <select name="chairName">
                                <option disabled>Выберите кафедру</option>
                                <c:forEach var="chairName" items="${chairNames}">
                                    <option <c:if test="${editDiscipline.getNameChair() == chairName }">selected</c:if>>
                                            ${chairName}
                                    </option>
                                </c:forEach>
                            </select>
                        </label>
                        </p>
                        <label>Учебный план
                            <select name="curriculumName">
                                <option disabled>Выберите Учебный план</option>
                                <c:forEach var="curriculumName" items="${curriculumNames}">
                                    <option <c:if test="${editDiscipline.getNameCurriculum() == curriculumName }">selected</c:if>>
                                            ${curriculumName}
                                    </option>
                                </c:forEach>
                            </select>
                        </label>
                        <p>
                            <button type="submit">Изменить</button>
                        </p>
                    </form>
                </div>
            </article>
        </section>

    </div>
    <jsp:include page="/jspf/footer.jsp" />
</body>
</html>
