<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%-- TODO: Modifier pour récupérer les infos d'un produit à mettre à jour --%>
<html>
<head>
    <title>Création de produit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Formulaire de création d'un produit</h2>
    <form action="produit" method="POST" enctype="multipart/form-data">
        <div>
            <input type="file" name="image"/>
        </div>
        <div class="mb-3">
            <label for="marque" class="form-label">Marque : </label>
            <input type="text" class="form-control" id="marque" name="marque">
        </div>
        <div class="mb-3">
            <label for="reference" class="form-label">Reference : </label>
            <input type="text" class="form-control" id="reference" name="reference">
        </div>
        <div class="mb-3">
            <label for="dateAchat" class="form-label">Date d'achat : </label>
            <input type="date" class="form-control" id="dateAchat" name="dateAchat">
        </div>
        <div class="mb-3">
            <label for="prix" class="form-label">Prix : </label>
            <input type="number" step="0.01" class="form-control" id="prix" name="prix">
        </div>
        <div class="mb-3">
            <label for="stock" class="form-label">Stock : </label>
            <input type="number" class="form-control" id="stock" name="stock">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>
</body>
</html>
