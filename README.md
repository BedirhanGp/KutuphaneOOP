📚 Kütüphane Yönetim Sistemi (Java OOP)

Bu proje, **Java Object Oriented Programming (OOP)** mantığı kullanılarak geliştirilmiş basit bir **kütüphane yönetim sistemi**dir.
Amaç; Java temel OOP kavramlarını, dosya işlemlerini ve koleksiyonları pratik ederek öğrenmektir.

---

🚀 Özellikler

* 📖 Kitap ekleme
* 📋 Kitapları listeleme
* 🔍 Kitap kodu ile arama
* ❌ Kitap silme
* 💰 Kitap satış işlemi (stok düşer)
* 📦 Kitap alış işlemi (stok artar)
* 📊 Kütüphanenin toplam değerini hesaplama
* 💾 Dosyaya kayıt alma
* 📂 Program açıldığında dosyadan otomatik veri yükleme

---

🛠️ Kullanılan Teknolojiler

* Java
* OOP (Class, Encapsulation)
* ArrayList
* Dosya Okuma / Yazma (BufferedReader, BufferedWriter)

---

📁 Proje Yapısı

```
src/
 └── kutuphaneOOP/
     ├── Calisan.java        → Ana menü ve program akışı
     ├── Kitap.java          → Kitap sınıfı (OOP)
     └── KutupServices.java  → Tüm işlemler (ekle, sil, satış, dosya vs.)

kitaplar.txt                → Kitap verilerinin tutulduğu dosya
```

---

▶️ Nasıl Çalışır?

1. Program başlatıldığında `kitaplar.txt` dosyası kontrol edilir
2. Dosya varsa veriler yüklenir, yoksa otomatik oluşturulur
3. Menü üzerinden işlemler yapılır
4. Programdan çıkarken veriler dosyaya kaydedilir

---

✍️ Geliştirici

Bedirhan Günalp
Java öğrenme sürecinde geliştirilmiştir.
Amaç: Temel Java + OOP mantığını sağlamlaştırmak.

---

🔮 Geliştirme Fikirleri

* Iterator ile güvenli silme
* equals / hashCode override (kod üzerinden)
* Exception handling iyileştirme
* Arayüz (GUI) ekleme
