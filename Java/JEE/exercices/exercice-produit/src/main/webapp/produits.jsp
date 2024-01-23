<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Produits</title>
</head>
<body>
<h1>Liste de produits</h1>
<br/>
<table>
    <tr>
        <th>#</th>
        <th>Marque</th>
        <th>Reference</th>
        <th>Prix</th>
        <th>Détails</th>
        <th>Supprimer</th>
    </tr>
    <c:forEach items="${produits}" var="produit">
        <tr>
            <td>${produit.getId()}</td>
            <td>${produit.getMarque()}</td>
            <td>${produit.getReference()}</td>
            <td>${produit.getPrix()}</td>
            <td><a href="produit?id=${produit.getId()}">i</a></td>
            <td><a href="produit?id=${produit.getId()}&mode=delete">x</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
