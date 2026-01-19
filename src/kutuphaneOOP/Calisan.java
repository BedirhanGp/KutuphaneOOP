package kutuphaneOOP;

import java.util.Scanner;

public class Calisan {

	public static void main(String[] args) {
		Scanner giris = new Scanner(System.in);
		KutupServices services = new KutupServices();
		services.dosyadanYukle();
		while(true) {
			menuGoster();
			int secim = giris.nextInt();
			switch (secim) {
            case 1:
                services.Ekle(giris);
                break;
            case 2:
                services.Listele();
                break;
            case 3:
                services.KodIleAra(giris);
                break;
            case 4:
                services.KitapSil(giris);
                break;
            case 5:
                services.KitapAlis(giris);
                break;
            case 6:
                services.KitapSatis(giris);
                break;
            case 7:
                services.Deger();
                break;
            case 0:
            	services.dosyayaKaydet();
                System.out.println("Çıkış yapıldı.");
                System.exit(0);
            default:
                System.out.println("Hatalı seçim.");
        }
		}
	}

	private static void menuGoster() {
		System.out.println("KÜTÜPHANE YÖNETİM SİSTEMİ");
		 System.out.println("***********************");
	     System.out.println("1- Kitap Ekle");
	     System.out.println("2- Kitapları Listele");
	     System.out.println("3- Kod ile Kitap Ara");
         System.out.println("4- Kitap Sil");
         System.out.println("5- Kitap Satış");
	     System.out.println("6- Kitap Alış");
	     System.out.println("7- Toplam Değer");
         System.out.println("0- Çıkış");
	     System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
	}

}
