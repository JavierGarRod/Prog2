package ExamenT1;

import java.util.ArrayList;
import java.util.List;

public class ProcesadorSuministrosPorPunto {
	public static void main(String[] args) {
		if (args.length == 0) {
            System.out.println("Error");
        }
		
		ProcesadorSuministrosPorPunto ref=new ProcesadorSuministrosPorPunto();
		String idPunto=args[0];
		List<Integer> kWh=new ArrayList<Integer>();
		for(int i=1;i<args.length;i++) {
			kWh.add(Integer.parseInt(args[i]));
		}
		ref.calculaKWHyImporteTotal(idPunto, kWh);
	}
	
	public void calculaKWHyImporteTotal(String idPunto, List<Integer> kWh) {
		int kWhTotal=0;
		List<Integer> todokWh=kWh;
		
		for(int i=0;i<todokWh.size();i++) {
			kWhTotal=kWhTotal+todokWh.get(i);
		}
		
		Double importe=kWhTotal*0.3;
		
		System.out.println(importe);
		System.out.println(idPunto +";"+ kWhTotal +";"+ importe);
	}
	
}