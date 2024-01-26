<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patient ${patient.getId()}</title>
    <jsp:include page="../../includes/head.jsp"/>
</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <div style="text-align: center;">
        <div class="card" style="width: 18rem;">
            <img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}"
                 class="card-img-top img-thumbnail" alt="Photo de profil du Patient">
            <div class="card-body">
                <h5 class="card-title">${patient.getLastName()} ${patient.getFirstName()}</h5>
                <p class="card-text">Date de naissance : ${patient.getBirthDate()}</p>
            </div>
            <ul class="list-group list-group-flush">
                <c:forEach items="${patient.getConsultations()}" var="consultation">
                    <li class="list-group-item">${consultation.getDate()}</li>
                    <li class="list-group-item">${consultation.getDoctorName()}</li>
                </c:forEach>
            </ul>
            <div class="card-body">
                <a href="list" class="btn btn-primary">Retour</a>
                <a href="delete?id=${patient.getId()}" class="btn btn-danger">Delete</a>
            </div>

        </div>
    </div>
</div>
</body>
</html>
