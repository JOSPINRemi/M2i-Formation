<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Patients</title>
</head>
<body>
<div class="container mt-4">
    <div style="text-align: center;">
        <h2>Liste des patients</h2>
    </div>
    <div class="m-4">
        <a href="new" class="btn btn-success text-start">Add Patient</a>
    </div>
    <div style="text-align: center;">
        <table border="1" cellpadding="5" class="table table-dark text-center">
            <caption><h2>Liste des Patients</h2></caption>
            <tr>
                <th>#</th>
                <th>Image</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date de naissance</th>
                <th>Actions</th>
            </tr>
            <c:choose>
                <c:when test="${patients != null && not empty patients}">
                    <c:forEach items="${patient}" var="patient">
                        <tr>
                            <td>${patient.getId()}</td>
                            <td><img src="${pageContext.request.contextPath}/imageServlet?id=${patient.getId()}"
                                     class="img-thumbnail" style="width: 50px;height: 50px;" alt="Photo du patient">
                            </td>
                            <td>${patient.getLastName()}</td>
                            <td>${patient.getFirstName()}</td>
                            <td>${patient.getBirthDate()}</td>
                            <td>
                                <a href="edit?id=${patient.getId()}" class="btn btn-info">Edit</a>
                                <a href="delete?id=${patient.getId()}" class="btn btn-danger">Delete</a>
                                <a href="details?id=${patient.getId()}" class="btn btn-primary">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="6">Aucun patient enregistré</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
    </div>
</div>
</body>
</html>