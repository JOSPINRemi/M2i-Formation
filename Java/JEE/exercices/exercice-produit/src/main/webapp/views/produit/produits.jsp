<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Produits</title>
</head>
<body>
<h1>Liste de produits</h1>
<br/>
<a href="produit">Ajouter un produit</a>
<br/>
<c:if test="${produits.isEmpty()}">
    <p>Aucun produits en stock</p>
</c:if>
<c:if test="${!produits.isEmpty()}">
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
                <td><img src="images/${produit.getUrlImage()}"></td>
                <td>${produit.getMarque()}</td>
                <td>${produit.getReference()}</td>
                <td>${produit.getPrix()}</td>
                <td><a href="produit?id=${produit.getId()}">i</a></td>
                <td><a href="produit?id=${produit.getId()}&mode=delete">x</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
