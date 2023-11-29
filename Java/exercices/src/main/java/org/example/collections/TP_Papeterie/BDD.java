package org.example.collections.TP_Papeterie;

import java.util.HashMap;

public class BDD {
    public static HashMap<String, Article> articles;

    public BDD() {
        articles = new HashMap<>();
    }

    public boolean ajouterArticle(Article article) {
        return articles.put(article.getReference(), article) == article;
    }
}
