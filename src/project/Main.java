package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main
{
    private int MAX;
    private  File fichier = new File("C:\\Users\\Zayneb\\Desktop\\resultat_Eratosthene.txt") ;
    

    public Main(int max)
    {
        super();
        MAX = max;
        if(!fichier.exists()){
            try
            {
                fichier.createNewFile();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

         }
        else {
            try
            {
                PrintWriter out = new PrintWriter(fichier);
                
                out.print("");
            
                out.close();
            }
            catch (FileNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void start() throws FileNotFoundException
    {
       
            
        Eratosthene eratosthene = new Eratosthene(2);

        List<Integer> list = IntStream.rangeClosed(3, MAX)
                .boxed().collect(Collectors.toList());
        System.out.println(list);
        System.out.println("les nombres premiers inférieurs à  "+MAX+" sont :");
        eratosthene.setValeurAtraiter(list);
        eratosthene.start();
        

    
    

    }
    public int getMAX()
    {
        return MAX;
    }

    public void setMAX(int mAX)
    {
        MAX = mAX;
    }

    

}
