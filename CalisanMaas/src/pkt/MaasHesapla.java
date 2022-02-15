package pkt;

import net.sourceforge.jFuzzyLogic.FIS;

import java.io.File;
import java.net.URISyntaxException;

public class MaasHesapla {
	
	private final FIS fis;
	private double egitimSuresi;
	private double tecrube;
	private double cinsiyet;
	
	public MaasHesapla(double egitimSure, double tcb, double cst) throws URISyntaxException {
		this.egitimSuresi = egitimSure;
		this.tecrube = tcb;
		this.cinsiyet = cst;
		
		File file = new File(getClass().getResource("MaasHesapla.fcl").toURI());
		fis = FIS.load(file.getPath());
		fis.setVariable("egitimSuresi", egitimSure);
		fis.setVariable("tecrube", tcb);
		fis.setVariable("cinsiyet", cst);
		fis.evaluate();
	}
	
	public FIS getModel() {
		return fis;
	}
	
	public String toString() {
		String cikti = "Maaþ: " + Math.round(fis.getVariable("maas").getValue()) + "000 TL"; 
		return cikti;
	}

}
