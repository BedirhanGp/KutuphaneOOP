package kutuphaneOOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class KutupServices {
	private List<Kitap> kitaplar = new ArrayList<Kitap>();
	boolean donguDevam = true;
	
	public void Ekle(Scanner giris) {
		System.out.print("Kitap adı : ");
		String ad = giris.next();
		System.out.print("Kitap kodu : ");
		int kod = giris.nextInt();
		System.out.print("Yazar adı : ");
        String yazar = giris.next();
        System.out.print("Sayfa sayısı : ");
        int sayfa = giris.nextInt();
        System.out.print("Fiyat : ");
        int fiyat = giris.nextInt();
        System.out.print("Miktar : ");
        int miktar = giris.nextInt();
        Kitap kitap = new Kitap(kod, ad, yazar, sayfa, fiyat, miktar);
        kitaplar.add(kitap);
        System.out.println("Kitap başarıyla eklendi.");
        System.out.println("************************");
	}
	
	public void Listele() {
		if(kitaplar.isEmpty()) {
			System.out.println("Kütüphanede kitap yok.");
			return;
		}
		for (int i = 0; i < kitaplar.size(); i++) {
			System.out.println("************************");
			System.out.print(i+1 + ". ");
			System.out.println(kitaplar.get(i));
		}
	}
	
	public void KodIleAra(Scanner giris) {
		System.out.println("Aramak istediğiniz kitabın kodunu giriniz : ");
		int kod = giris.nextInt();
		for (Kitap k : kitaplar) {
			if (k.getKod() == kod) {
				System.out.println(k);
				return;
			}
		}
		System.out.println("Kitap bulunamadı!");
	}
	
	public void KitapSil(Scanner giris) {
		System.out.println("Silmek istediğiniz kitabın kodunu giriniz : ");
		int kod = giris.nextInt();
		for (Kitap k : kitaplar) {
			if (k.getKod() == kod) {
				System.out.print("Silinecek kitap : ");
				System.out.println(k);
				donguDevam = true;
				while(donguDevam) {
					System.out.println("Silmek istediğinize emin misiniz ? (e/h)");
					String cevap = giris.next();
					if (cevap.equalsIgnoreCase("e")) {
						kitaplar.remove(k);
						System.out.println("Kitap silindi.");
						donguDevam = false;
						return;
					}
					System.out.println("Silme işlemi iptal edildi.");
					donguDevam = false;
					return;
				}
			}
		}
		System.out.println("Kitap bulunamadı!");
	}
	
	public void KitapSatis(Scanner giris) {
		System.out.println("Satılacak kitabın kodunu giriniz : ");
		int kod = giris.nextInt();
		for (Kitap k : kitaplar) {
			if (k.getKod() == kod) {
				System.out.println("Kitaptan " + k.getMiktar() + " adet var.");
				System.out.println("Kaç adet satılacak : ");
				int adet = giris.nextInt();
				if (k.getMiktar() >= adet) {
					donguDevam = true;
					while(donguDevam) {
						System.out.println("Satış işlemini onaylıyor musunuz ? (e/h)");
						String cevap = giris.next();
						if (cevap.equalsIgnoreCase("e")) {
							k.setMiktar(k.getMiktar() - adet);
							System.out.println("Satış işlemi tamamlandı.");
							System.out.println("Kitaptan " + k.getMiktar() + " adet kaldı.");
							donguDevam = false;
							return;
						}
						System.out.println("Satış işlemi iptal edildi.");
						donguDevam = false;
						return;
					}
				}else {
					System.err.println("Yetersiz stok!");
				}
				return;
			}
		}
		System.out.println("Kitap bulunamadı!");
	}
	
	public void KitapAlis(Scanner giris) {
		System.out.println("Alınacak kitabın kodunu giriniz : ");
		int kod = giris.nextInt();
		for (Kitap k : kitaplar) {
			if (k.getKod() == kod) {
				System.out.println("Kitaptan " + k.getMiktar() + " adet var.");
				System.out.println("Kaç adet alınacak : ");
				int adet = giris.nextInt();
				donguDevam = true;
				while(donguDevam) {
					System.out.println("Alış işlemini onaylıyor musunuz ? (e/h)");
					String cevap = giris.next();
					if (cevap.equalsIgnoreCase("e")) {
						k.setMiktar(k.getMiktar() + adet);
						System.out.println("Alış işlemi tamamlandı.");
						System.out.println("Kitaptan " + k.getMiktar() + " adet var.");
						donguDevam = false;
						return;
					}
					System.out.println("Alış işlemi iptal edildi.");
					donguDevam = false;
					return;
				}
			}
		}
		System.out.println("Kitap bulunamadı!");
	}
	
	public void Deger() {
		int toplam = 0;
		for (Kitap k : kitaplar) {
			toplam += k.getFiyat() * k.getMiktar();
		}
		System.out.println("Toplam kütüphane değeri : " + toplam + "TL");
	}
	
	public void dosyayaKaydet() {
	    dosyaKontrolEt();

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(DOSYA_ADI))) {

	        for (Kitap k : kitaplar) {
	            bw.write(
	                k.getKod() + "," +
	                k.getAd() + "," +
	                k.getYazar() + "," +
	                k.getSayfa() + "," +
	                k.getFiyat() + "," +
	                k.getMiktar()
	            );
	            bw.newLine();
	        }

	        System.out.println("Veriler dosyaya kaydedildi.");

	    } catch (IOException e) {
	        System.out.println("Dosyaya yazma hatası!");
	    }
	}

	
	public void dosyadanYukle() {
	    dosyaKontrolEt();

	    try (BufferedReader br = new BufferedReader(new FileReader(DOSYA_ADI))) {

	        String satir;
	        while ((satir = br.readLine()) != null) {
	            String[] veri = satir.split(",");

	            int kod = Integer.parseInt(veri[0]);
	            String ad = veri[1];
	            String yazar = veri[2];
	            int sayfa = Integer.parseInt(veri[3]);
	            int fiyat = Integer.parseInt(veri[4]);
	            int miktar = Integer.parseInt(veri[5]);

	            kitaplar.add(new Kitap(kod, ad, yazar, sayfa, fiyat, miktar));
	        }

	        System.out.println("Veriler dosyadan yüklendi.");

	    } catch (IOException e) {
	        System.out.println("Dosya okuma hatası!");
	    }
	}

	private final String DOSYA_ADI = "kitaplar.txt";
	private void dosyaKontrolEt() {
	    File dosya = new File(DOSYA_ADI);

	    try {
	        if (dosya.createNewFile()) {
	            System.out.println("Dosya bulunamadı, yeni dosya oluşturuldu.");
	        }
	    } catch (IOException e) {
	        System.out.println("Dosya oluşturulurken hata oluştu!");
	    }
	}

}
