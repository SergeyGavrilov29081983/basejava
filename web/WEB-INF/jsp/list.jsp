<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.ContactType" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
<link rel="stylesheet" href="css/style.css">
    <title>База Данных Резюме</title>

</head>




<body class="page">
<header class="header">
    <div class="container">
        <div class="header-flex">
            <div class="logo">
                <a href="https://topjava.ru/basejava">
                    <img src="img/logo.png">
                    <span>
              Практические курсы
              программирования
              на Java со стажировкой
              и трудоустройством
            </span>
                </a>
            </div>
            <span class="title">Проект База Данных Резюме</span>
            <div class="buttonAdd"><a href="resume?action=add">Добавить резюме</a></div>
        </div>
    </div>
</header>
<main class="content">
    <div class="container">
        <div class="item">
            <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" type="model.Resume"/>
                <a class="item-link" href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a>
                <%=ContactType.EMAIL.toHtml(resume.getContact(ContactType.EMAIL))%>

            <div class="item-edit">
                <a href="resume?uuid=${resume.uuid}&action=edit"><div class="button btn-edit" >Редактировать</div></a>
                <a href="resume?uuid=${resume.uuid}&action=delete"><div class="button delete">Удалить</div></a>
            </div>
            </c:forEach>
        </div>
    </div>
</main>
<footer class="footer">
    <div class="container">Футер</div>
</footer>
</body>
</html>