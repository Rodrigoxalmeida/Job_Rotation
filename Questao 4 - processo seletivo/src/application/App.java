package application;

public class App {

	public static void main(String[] args) {
				
		Double SP = 67836.43;
		Double RJ = 36678.66;
		Double MG = 29229.88;
		Double ES = 27165.48;
		Double Outros = 19849.53;
		
		
		Double[] valores = {SP, RJ, MG, ES, Outros};
		
		Double total = 0.0;
		
		for(int i = 0; i < valores.length; i++) {
			total += valores[i];
		}
	
		
		double psp = (valores[0] / total) * 100;
		double prj = (valores[1] / total) * 100;
		double pmg = (valores[2] / total) * 100;
		double pes = (valores[3] / total) * 100;
		double poutros = (valores[4] / total) * 100;
		
		System.out.println("SP - " + String.format("%.2f", psp) + "%");
		System.out.println("RJ - " + String.format("%.2f", prj) + "%");
		System.out.println("MG - " + String.format("%.2f", pmg) + "%");
		System.out.println("ES - " + String.format("%.2f", pes) + "%");
		System.out.println("Outros - " + String.format("%.2f", poutros) + "%");
		

	}

}
