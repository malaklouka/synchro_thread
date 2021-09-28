package project;

import java.io.File;

import org.junit.Test;

public class TestProduitParallele
{
    private int nbrLignes = 10;
    private int nbrColonnes = 10;
    private File fichier = new File("C:\\\\Users\\\\Zayneb\\\\Desktop\\\\resultat_Eratosthene.txt");
    
    @Test 
    public void test() {
        
        
        MatriceEntiere m1 = new MatriceEntiere(nbrLignes, nbrColonnes, fichier);
        MatriceEntiere m2 = new MatriceEntiere(nbrLignes, nbrColonnes, fichier);
        System.out.println("La matrice m1: ");
        m1.show();
        System.out.println("La matrice m2: ");
        m2.show();
        MatriceEntiere m = ProduitParallele.main(m1, m2);
        System.out.println("Le produit matricielle m est : ");
        m.show();
        
        System.out.println("Le produit a la main est : ");
        Long result = 0L;
        for (int i=0;i<m1.getNbrColonnes();i++) {
            result = result + (m1.getElem(0, i)*m2.getElem(i, 0));
        }
        System.out.println(result);
    }
}
