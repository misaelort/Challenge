package examples.Challenge1;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import java.util.Random;


public class Challenge1 extends Agent {


	

	
	
	protected void setup() 
	{
	
		  addBehaviour(new GradientDescent());
		
	}
	
	public class GradientDescent extends OneShotBehaviour{
	
	public void action(){
	
		gradiente_descendente();


	   }//Termina action
	   
	}
	

	public double bounds()
	{
        	int min_val = -1;
       	int max_val = 1;
        	double _x=0;
        	Random ran = new Random();
        	_x = ran.nextInt(max_val) + min_val;
        	System.out.println("Random Number: "+_x);
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
	
	public void gradiente_descendente()
	{
		double alpha = 0.01;		 
		double solucion=0;           
		double solucion_eval=0;
		double gradient=0;
		double iter=1e-2;	
	
		solucion=bounds();
	  
			for (int i=0; i<1000;i++)
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
	      			 
	       			 if (solucion_eval<iter)
	       		 	{
	       		 		break;
	       		 	}
	       	} 
	       	  
	    System.out.println("Done!");
	    System.out.println(solucion + " " + solucion_eval);	
	}
	
		
}

