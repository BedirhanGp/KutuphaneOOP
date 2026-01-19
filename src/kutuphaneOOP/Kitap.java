package kutuphaneOOP;

public class Kitap {
	private int kod;
    private String ad;
    private String yazar;
    private int sayfa;
    private int fiyat;
    private int miktar;
     
	public Kitap(int kod, String ad, String yazar, int sayfa, int fiyat, int miktar) {
		this.kod = kod;
		this.ad = ad;
		this.yazar = yazar;
		this.sayfa = sayfa;
		this.fiyat = fiyat;
		this.miktar = miktar;
	}
	
	public int getKod() {
		return kod;
	}
	public void setKod(int kod) {
		this.kod = kod;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getYazar() {
		return yazar;
	}
	public void setYazar(String yazar) {
		this.yazar = yazar;
	}
	public int getSayfa() {
		return sayfa;
	}
	public void setSayfa(int sayfa) {
		this.sayfa = sayfa;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	public int getMiktar() {
		return miktar;
	}
	public void setMiktar(int miktar) {
		this.miktar = miktar;
	}
	@Override
	public String toString() {
		return "Kitabın kodu : " + kod + ", adı = " + ad + ", yazarı = " + yazar + ", sayfa = " + sayfa + ", fiyat = " + fiyat
				+ ", miktar = " + miktar;
	}
    
}
