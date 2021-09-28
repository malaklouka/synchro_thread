package project;


public class CalculElem implements Runnable
{
    private MatriceEntiere m;
    private MatriceEntiere m1;
    private MatriceEntiere m2;
    private int i;
    private int j;
    
    public CalculElem(MatriceEntiere m,
                      MatriceEntiere m1,
                      MatriceEntiere m2,
                      int i,
                      int j)
    {
        super();
        this.m = m;
        this.m1 = m1;
        this.m2 = m2;
        this.i = i;
        this.j = j;
    }

    @Override
    public void run()
    {
        int valeur = MatriceEntiere.produitLigneColonne(m1, i, m2, j);
        m.setElem(i, j, valeur);
        
    }

}
