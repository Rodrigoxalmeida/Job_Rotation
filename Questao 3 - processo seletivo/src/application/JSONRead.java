package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONRead {

	public static void main(String[] args) {

		ArrayList<Faturamento> fatu = new ArrayList<>();
		Double minimo = 0.0;
		Double maximo = 0.0;
		Double media = 0.0;
		Integer totalDias = 0;
		Double mediaMensal = 0.0;
		int qtdDia = 0;
		
		JSONParser parser = new JSONParser();

		try {
			JSONArray faturamentos = (JSONArray) parser.parse(new FileReader("dados.json"));

			for (Object o : faturamentos) {
				JSONObject fat = (JSONObject) o;
				Integer dia = Integer.parseInt(fat.get("dia").toString());
				Double valor = Double.parseDouble(fat.get("valor").toString());

				if (valor > 0.0) {
					Faturamento fatura = new Faturamento();
					fatura.setDia(dia);
					fatura.setValor(valor);
					fatu.add(fatura);
				}

			}
			
			minimo = fatu.get(0).getValor();
			for (int i = 0; i < fatu.size(); i++) {
				if (fatu.get(i).getValor() < minimo) {
					minimo = fatu.get(i).getValor();
				}
			}

			maximo = fatu.get(0).getValor();
			for (int i = 0; i < fatu.size(); i++) {
				if (fatu.get(i).getValor() > maximo) {
					maximo = fatu.get(i).getValor();
				}

			}
			
			for (int i = 0; i < fatu.size(); i++) {
				media = media + fatu.get(i).getValor();
				totalDias = +fatu.get(i).getDia();
			}

			mediaMensal = media / totalDias;
			
			for(int i = 0; i < fatu.size(); i++) {
				if(fatu.get(i).getValor() > mediaMensal) {
					qtdDia++;
				}
			}
			
			System.out.println("minimo: " + minimo);
			System.out.println("maximo: " + maximo);
			System.out.println("Media Mensal: " + String.format("%.4f", mediaMensal));
			System.out.println("Quantidade de dias Maior que a média: " + qtdDia);
			

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}