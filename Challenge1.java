package examples.Challenge1;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import java.util.Random;


public class Challenge1 extends Agent {


	
	double alpha = 0.1;	//si	 
	double solucion=0;            //si
	double solucion_eval=0;
	double gradient=0;
	
	protected void setup() 
	{
	
		  addBehaviour(new GradientDescent());
		
	}
	
	public class GradientDescent extends OneShotBehaviour{
	
	public void action(){
	
	    solucion=bounds();
	  
	   for (int i=0; i<15;i++)
	   {
	   
	   System.out.println("------------------------");
	    System.out.println("iteracion "+ (i+1) );
	    
	    //calculando gradiente
	    //gradiente=2*x;
	   gradient=  gradiente(solucion);
	    
	    //actualizar iteracion y valor correspondiente
	    
	    solucion = solucion - alpha*gradient;
	     
	    
	    solucion_eval=objetive(solucion);
	    //imprimir valores
	     System.out.println(" x = "+ solucion +" y = "+ solucion_eval );

	   
	   }
	   
	   
	    System.out.println("Done!");
	    System.out.println(solucion + " " + solucion_eval);

	   }
	   
	}
	

		public double bounds()
	{
           int min_val = -1;
           int max_val = 1;
           double _x=0;
           Random ran = new Random();
           _x = ran.nextInt(max_val) + min_val;
         // System.out.println("Random Number: "+_x);
	   return _x;
	
	} 
	

	
	public double gradiente(double x)
	{
	return 2.0*x;
	}  
	public double objetive(double x)
	{
	return x*x;
	}  
	

		
	      
}

