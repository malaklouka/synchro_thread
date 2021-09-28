package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatriceEntiere
{
    private int     nbrLignes;
    private int     nbrColonnes;
    private int[][] tableau;
    Random random = new Random();

    public MatriceEntiere(int nbrLignes,
                          int nbrColonnes,
                          int[][] tableau)
    {
        super();
        this.nbrLignes = nbrLignes;
        this.nbrColonnes = nbrColonnes;
        this.tableau = tableau;
    }

    public MatriceEntiere(int nbrLignes,
                          int nbrColonnes,
                          File fichier)
    {

        this.nbrLignes = nbrLignes;
        this.nbrColonnes = nbrColonnes;
        this.tableau = new int[nbrLignes][nbrColonnes];
        List<Integer> entiers = new ArrayList<Integer>();
            
        
        BufferedReader lecteurAvecBuffer = null;
        String ligne;

        try
        {
            lecteurAvecBuffer = new BufferedReader(new FileReader(fichier));
            while ((ligne = lecteurAvecBuffer.readLine()) != null)
            {
                entiers.add(Integer.valueOf(ligne));
                System.out.println(ligne);
            }
            lecteurAvecBuffer.close();
        }
        catch (IOException exc)
        {
            System.out.println("Erreur d'ouverture");
        }
        for (int i=0;i<nbrLignes;i++) {
            for(int j=0;j<nbrColonnes;j++) {
                this.setElem(i, j, entiers.get(random.nextInt(entiers.size())));
            }
        }
    }

    public int getNbrLignes()
    {
        return nbrLignes;
    }

    public void setNbrLignes(int nbrLignes)
    {
        this.nbrLignes = nbrLignes;
    }

    public int getNbrColonnes()
    {
        return nbrColonnes;
    }

    public void setNbrColonnes(int nbrColonnes)
    {
        this.nbrColonnes = nbrColonnes;
    }

    public int[][] getTableau()
    {
        return tableau;
    }

    public void setTableau(int[][] tableau)
    {
        this.tableau = tableau;
    }

    public int getElem(int i, int j)
    {
        return this.tableau[i][j];

    }

    public void setElem(int i, int j, int val)
    {
        this.tableau[i][j] = val;
    }

    @Override
    public String toString()
    {
        return "MatriceEntiere [nbrLignes=" + nbrLignes + ", nbrColonnes=" + nbrColonnes + ", tableau=" + Arrays.toString(tableau) + "]";
    }

    public void show() {
        System.out.println("Matrice Entiere : ["+nbrLignes+"x"+nbrColonnes+"]");
        for (int i=0;i<nbrLignes;i++) {
            System.out.print("|");
            for(int j=0;j<nbrColonnes;j++) {
                System.out.print(this.getElem(i,j)+"|");
            }
            System.out.println("");
        }
    }
    
    public static int produitLigneColonne(MatriceEntiere m1,int i, MatriceEntiere m2, int j ) {
        int result=0;
        for (int l=0;l<m1.getNbrColonnes();l++) {
            
                result=result+(m1.getElem(i,l)*m2.getElem(l,j));
                
        }
        
        return result;
        
    }
}
