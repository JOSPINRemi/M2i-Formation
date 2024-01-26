<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add patient</title>
    <jsp:include page="../../includes/head.jsp"/>
</head>
<body>
<jsp:include page="../../includes/header.jsp"/>
<div class="container mt-4">
    <div style="text-align: center;">
        <c:if test="${patient == null}">
            <h2>Ajouter un patient </h2>
        </c:if>
        <c:if test="${patient != null}">
            <h2>Modifier un patient </h2>
        </c:if>
    </div>
    <div>
        <form action="insert" method="post" enctype="multipart/form-data">
            <c:if test="${patient != null}">
                <input type="hidden" name="id" value="<c:out value='${patient.getId()}' />"/>
            </c:if>
            <div class="form-group col-md-6">
                <label for="lastname">Nom : </label>
                <input type="text" class="form-control" id="lastname" name="lastname"
                       value="${patient.getLastName()}">
            </div>
            <div class="form-group col-md-6">
                <label for="firstname">Prénom : </label>
                <input type="text" class="form-control" id="firstname" name="firstname"
                       value="${patient.getFirstName()}">
            </div>
            <div class="form-group col-md-4">
                <label for="birthdate">Date de naissance : </label>
                <input type="date" class="form-control" id="birthdate" name="birthdate"
                       value="${patient.getBirthDate()}">
            </div>
            <div class="mb-3">
                <label for="formFile" class="form-label">Photo de profil : </label>
                <input class="form-control" type="file" id="formFile" name="image" accept=".png">
            </div>
            <button type="submit" class="btn btn-primary">${patient == null ? 'Validation' : 'Update'}</button>
        </form>
    </div>
</div>
</body>
</html>