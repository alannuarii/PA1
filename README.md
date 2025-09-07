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
Proyek ini dikembangkan menggunakan bahasa pemrograman Java. Untuk memastikan kompatibilitas dan kinerja optimal, disarankan untuk menggunakan **Java Development Kit (JDK) versi 11 atau yang lebih baru**. JDK menyediakan semua *tool* yang diperlukan untuk mengompilasi dan menjalankan aplikasi Java ini, termasuk *Java compiler* (`javac`) dan *Java Virtual Machine* (`java`).

## Cara Menjalankan Proyek
Ikuti langkah-langkah di bawah ini untuk mengompilasi dan menjalankan aplikasi sistem manajemen inventaris ini di lingkungan lokal Anda.

1.  **Pastikan JDK Terinstal:**
    Sebelum memulai, pastikan Anda telah menginstal Java Development Kit (JDK) di sistem Anda. Anda dapat mengunduhnya dari situs web resmi Oracle atau menggunakan *package manager* yang sesuai dengan sistem operasi Anda.
    Untuk memverifikasi instalasi JDK, buka *terminal* atau *command prompt* dan jalankan perintah berikut:
    ```bash
    java -version
    javac -version
    ```
    Output harus menampilkan versi JDK yang terinstal (misalnya, `openjdk version "11.0.12"`).

2.  **Kloning Repositori:**
    Unduh kode sumber proyek ini ke mesin lokal Anda dengan mengkloning repositori Git. Ganti `https://github.com/alannuarii/PA1.git` dengan URL repositori aktual Anda, dan `PA1` dengan nama folder proyek yang Anda inginkan.
    ```bash
    git clone https://github.com/alannuarii/PA1.git
    cd PA1
    ```

3.  **Kompilasi Seluruh File Java:**
    Setelah masuk ke direktori proyek, gunakan *Java compiler* (`javac`) untuk mengompilasi semua file `.java` menjadi file `.class` (bytecode yang dapat dieksekusi oleh JVM). Perintah ini akan mengompilasi semua file Java yang ada di direktori saat ini.
    ```bash
    javac *.java
    ```
    Jika ada *error* saat kompilasi, pastikan semua file `.java` berada di direktori yang sama atau sesuaikan *classpath* (`-cp`) jika Anda menggunakan struktur folder yang lebih kompleks.

4.  **Jalankan Aplikasi:**
    Setelah kompilasi berhasil, Anda dapat menjalankan aplikasi utama menggunakan *Java Virtual Machine* (`java`). Aplikasi akan dimulai di konsol, menampilkan menu interaktif.
    ```bash
    java Main
    ```
    Anda sekarang dapat berinteraksi dengan sistem manajemen inventaris melalui menu yang disediakan di *terminal* atau *command prompt* Anda.

## Kontak
Untuk pertanyaan lebih lanjut, saran, atau diskusi terkait proyek ini, jangan ragu untuk menghubungi: [alan.pln50@gmail.com]
