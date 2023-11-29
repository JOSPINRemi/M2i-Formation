package org.example.collections.TP_Papeterie;

public class Ligne {
    private Article article;
    private int quantiteAchetee;

    public Ligne(Article article, int quantiteAchetee) {
        this.article = article;
        this.quantiteAchetee = quantiteAchetee;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantiteAchetee() {
        return quantiteAchetee;
    }

    public String afficheLigne() {
        String ligne = "";
        if (this.article instanceof ArticleUnitaire) {
            ligne = this.quantiteAchetee + " " + this.article.getReference() + " " + ((ArticleUnitaire) this.article).getNom() + " " + ((ArticleUnitaire) this.article).getPrixUnitaire() + " " + (((ArticleUnitaire) this.article).prixUnitaire) * quantiteAchetee;
        } else if (this.article instanceof Lot) {
            if (((Lot) this.article).getArticle() instanceof ArticleUnitaire) {
                double remise = ((Lot) this.article).getQuantite() * ((ArticleUnitaire) ((Lot) this.article).getArticle()).prixUnitaire * ((Lot) this.article).getPourcentageRemise();
                ligne = this.quantiteAchetee + " Lot " + ((Lot) this.article).getQuantite() + " " + ((Lot) this.article).getReference() + " " + ((ArticleUnitaire) ((Lot) this.article).getArticle()).getNom() + " " + ((ArticleUnitaire) ((Lot) this.article).getArticle()).getPrixUnitaire() + " " + (((Lot) this.article).getQuantite() * ((ArticleUnitaire) ((Lot) this.article).getArticle()).getPrixUnitaire() - remise) * quantiteAchetee;

            }
        } else {
            ligne = "L'Article n'est ni un lot ni ArticleUnitaire ni un Lot";
        }
        return ligne;
    }
}
