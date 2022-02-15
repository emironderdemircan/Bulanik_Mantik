package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class program {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Eðitim Süresi (0-5): ");
		double es = in.nextDouble();
		System.out.print("Tecrübe (0-10): ");
		double t = in.nextDouble();
		System.out.print("Cinsiyet (1-2): ");
		double c = in.nextDouble();
		try {
			MaasHesapla maas = new MaasHesapla(es,t,c);
			System.out.println(maas);
			
			FIS fis = maas.getModel();
			
			for(Rule r : fis.getFunctionBlock("MaasHesapla").getFuzzyRuleBlock("kuralBlok1").getRules()) {
				if(r.getDegreeOfSupport() > 0) System.out.println(r);
			}
			JFuzzyChart.get().chart(fis.getVariable("maas").getDefuzzifier(),"Maaþ",true);
			//JFuzzyChart.get().chart(fis);
		}
		catch(URISyntaxException ex){
			System.out.println(ex.getMessage());
		}

	}

}
