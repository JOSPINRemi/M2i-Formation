<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Produit ${produit.getId()} - Détails</title>
</head>
<body>
<h1>Détails du produit ${produit.getId()}</h1>
<br/>
<p>Marque : ${produit.getMarque()}</p>
<p>Reference : ${produit.getReference()}</p>
<p>Date d'achat : ${produit.getDateAchat()}</p>
<p>Prix : ${produit.getPrix()}</p>
<p>Stock : ${produit.getStock()}</p>
</body>
</html>

