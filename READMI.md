# Sistem Manajemen Inventaris Sederhana

## Deskripsi
Proyek ini adalah sistem manajemen inventaris berbasis konsol yang memungkinkan pengguna untuk menambah, menampilkan, memperbarui, dan menghapus item inventaris, serta mengelola stok barang dengan beberapa jenis barang seperti barang umum, barang elektronik, dan barang alat tulis.

## Fitur Utama
- Menambah barang baru (barang umum, barang elektronik, barang tulisan)
- Menampilkan semua item inventaris
- Memperbarui informasi item (nama, stok, harga)
- Menghapus item dari inventaris
- Mencari item berdasarkan nama (pencarian tidak sensitif huruf besar/kecil)
- Memperbarui stok item secara langsung

## Teknologi yang Digunakan
- Bahasa Pemrograman: Java
- JDK yang direkomendasikan: JDK 21 atau versi yang lebih baru

## Struktur Proyek
- `Main.java` : Berisi logika utama aplikasi dan menu interaktif untuk berinteraksi dengan inventaris.
- `Inventaris.java` : Kelas pengelola daftar barang dan operasi CRUD (Create, Read, Update, Delete).
- `Barang.java` : Kelas dasar (superclass) untuk semua jenis barang.
- `BarangElektronik.java` : Subkelas untuk barang elektronik dengan atribut garansi.
- `BarangTulisan.java` : Subkelas untuk barang alat tulis dengan jenis alat tulis.
- `FormatUtil.java` : Utilitas untuk pemformatan harga menjadi rupiah.

## Cara Menjalankan Proyek
1. Pastikan sudah menginstal Java Development Kit (JDK) di sistem.
2. Clone repositori ini:
   ```bash
   git clone https://github.com/alannuarii/PA1
   cd PA1
3. javac *.java
4. java Main

