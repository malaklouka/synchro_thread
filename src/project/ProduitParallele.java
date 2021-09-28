package project;

public class ProduitParallele
{


    public static MatriceEntiere main(MatriceEntiere m1,MatriceEntiere m2)
    {
        MatriceEntiere m = new MatriceEntiere(m1.getNbrLignes(),
                                              m2.getNbrColonnes(),
                                              new int[m1.getNbrLignes()][m1.getNbrColonnes()]);
        for (int i = 0; i < m1.getNbrLignes(); i++ )
        {
            for (int j = 0; j < m2.getNbrColonnes(); j++ )
            {
                CalculElem calculElem = new CalculElem(m, m1, m2, i, j);
                calculElem.run();
            }
        }
        return m;

    }

}
