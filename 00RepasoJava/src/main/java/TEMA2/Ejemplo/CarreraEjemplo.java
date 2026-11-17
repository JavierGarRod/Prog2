package TEMA2.Ejemplo;

class Contador {
	   private int valor = 0;
	   public synchronized void incrementar(String nombre) { 
	       valor++;
	       System.out.println(nombre);
	   }
	   public int getValor() {
	       return valor;
	   }
	}

class TareaIncremento implements Runnable {
   Contador contador;
   public TareaIncremento(Contador contador) {
       this.contador = contador;
   }
   @Override
   public void run() {
       for (int i = 0; i < 100000; i++) {
           contador.incrementar(Thread.currentThread().getName());
       }
   }
}

public class CarreraEjemplo {
   public static void main(String[] args) throws InterruptedException {
       long t_inicio=System.currentTimeMillis();
	   
	   Contador ref = new Contador();
       Thread t1 = new Thread(new TareaIncremento(ref));
       Thread t2 = new Thread(new TareaIncremento(ref));
       Thread t3 = new Thread(new TareaIncremento(ref));
       Thread t4 = new Thread(new TareaIncremento(ref));
       Thread t5 = new Thread(new TareaIncremento(ref));
       Thread t6 = new Thread(new TareaIncremento(ref));
       
       t1.start();
       t2.start();
       t3.start();
       t4.start();
       t5.start();
       t6.start();
       
       t1.join();
       t2.join();
       t3.join();
       t4.join();
       t5.join();
       t6.join();
       
       System.out.println("Valor final: " + ref.getValor()); // esperado: 200000
       System.out.println("Tiempo: "+t_inicio);
   }
}