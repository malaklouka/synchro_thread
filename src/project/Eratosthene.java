package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Eratosthene extends Thread
{

    private int           id;
    private List<Integer> valeurAtraiter = new ArrayList<Integer>();
    private Eratosthene   successeur     = null;
    private String        fichier        = "C:\\Users\\Zayneb\\Desktop\\resultat_Eratosthene.txt";

    public Eratosthene getSuccesseur()
    {
        return successeur;
    }

    public void setSuccesseur(Eratosthene successeur)
    {
        this.successeur = successeur;
    }

    public List<Integer> getValeurAtraiter()
    {
        return valeurAtraiter;
    }

    public void setValeurAtraiter(List<Integer> valeurAtraiter)
    {
        this.valeurAtraiter = valeurAtraiter;
    }

    public Eratosthene(int id)
    {
        super();
        this.id = id;

        try
        {
            System.out.println(this.getEratostheneId());
            FileWriter fileWriter;
            fileWriter = new FileWriter(fichier,
                                        true);
            PrintWriter resultat = new PrintWriter(fileWriter);
            resultat.println(String.valueOf(this.getEratostheneId()));

            resultat.close();
            
        }
        catch (Throwable e)
        {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
          ;
        }

    }

    public int getEratostheneId()
    {
        return id;
    }

    public void setEratostheneId(int id)
    {
        this.id = id;
    }

    public synchronized List<Integer> transmettre(int valeur)
    {
         
            if (valeurAtraiter == null)
            {
                valeurAtraiter = new ArrayList<Integer>();
            }
            valeurAtraiter.add(valeur);
            notify();
            return valeurAtraiter;
        


    }

    public synchronized void attendre(int time)
    {
        Long debut = System.currentTimeMillis();

        
        

            while ((this.valeurAtraiter.size() == 0))
            {
                try
                {
                    System.out.println("waiting in thread "+ this.getEratostheneId());
                    if (time ==0) {
                    wait();
                    }
                    else {
                        wait(time);
                    }

                }
                catch (Throwable e)
                {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            notify();

        
    }

    public  void traiter(int value)
    {
        try {
        if ((value % this.id) == 0)
        {
           // System.out.println("thread with id " + this.getEratostheneId() + " divise value " + value);

            valeurAtraiter.remove((Object) value);

            return;
        }
        else
        {
            if (this.successeur == null)
            {
                
                this.valeurAtraiter.remove((Object) value);

                //Eratosthene eratosthene = 

                this.setSuccesseur(new Eratosthene(value));
                System.out.println("about to run next thread with id " + this.successeur.getEratostheneId() + " " + value);
                this.getSuccesseur().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    
                    public void uncaughtException(Thread myThread, Throwable e) {
                        System.out.println(myThread.getName() + " throws exception: " + e);
                    }
                });
                this.successeur.start();

                
                return;

            }
            else
            {
                valeurAtraiter.remove((Object) value);
//                synchronized (this.successeur)
//                {
                    System.out.println("about to send from id"
                                       + this.getEratostheneId() + " to next thread with id " + this.successeur.getEratostheneId() + " " + value);
                    this.getSuccesseur().transmettre(value);
                    //this.successeur.notify();

//                }

                return;
            }
        }}
        catch( Throwable e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void run()
    {

        // resultat.close();
        attendre(0);

        while (this.getValeurAtraiter().size() > 0)
        {
            

                System.out.println(" valeur a traiter " + this.getValeurAtraiter().get(0) + "thread id "+this.getEratostheneId() +" et il reste "+this.getValeurAtraiter());
                traiter(this.getValeurAtraiter().get(0));
            
   
               if ( this.getValeurAtraiter().size()==0) {
                   System.out.println(" waiting for transfer ");
                   attendre(5000);
               }
               

        
        }
        //attendre();
        
        System.out.println(" finished run " + "thread id "+this.getEratostheneId());
        //System.out.println(" successor finifshed with id "+ this.successeur.getEratostheneId() );
        // les threads se terminent en sortant du cette boucle

    }

}
