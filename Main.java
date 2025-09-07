import java.util.InputMismatchException; // Digunakan untuk menangani input yang tidak sesuai tipe data
import java.util.Scanner; // Digunakan untuk membaca input dari konsol

/**
 * Kelas Main adalah titik masuk utama (entry point) aplikasi sistem manajemen inventaris.
 * Kelas ini menyediakan menu interaktif di konsol untuk mengelola daftar barang.
 */
public class Main {

    public static void main(String[] args) {
        // Inisialisasi objek Inventaris untuk mengelola daftar barang
        Inventaris inventaris = new Inventaris();
        Scanner scanner = new Scanner(System.in); // Objek Scanner untuk membaca input pengguna

        // Menambahkan barang-barang awal ke inventaris menggunakan polymorphism
        // BarangTulisan dan BarangElektronik adalah subclass dari Barang
        inventaris.tambahBarang(new BarangTulisan("Pensil", 50, 200, "HB")); // Contoh penggunaan polymorphism untuk BarangTulisan
        inventaris.tambahBarang(new BarangTulisan("Buku", 30, 15000, "Buku Tulis")); // Contoh lain BarangTulisan
        inventaris.tambahBarang(new BarangElektronik("Kalkulator", 10, 75000, 12)); // Contoh penggunaan polymorphism untuk BarangElektronik

        System.out.println("Inventaris Awal:");
        inventaris.tampilkanInventaris(); // Menampilkan seluruh isi inventaris saat aplikasi dimulai

        // ==== MENU INTERAKTIF APLIKASI ====
        // Loop utama untuk menampilkan menu dan memproses pilihan pengguna
        while (true) {
            System.out.println("\n=== MENU MANAJEMEN INVENTARIS ===");
            System.out.println("1. Tampil Data Barang");
            System.out.println("2. Tambah Data Barang Baru");
            System.out.println("3. Update Data Barang (berdasarkan Index)");
            System.out.println("4. Hapus Data Barang (berdasarkan Index)");
            System.out.println("5. Update Stok Barang (berdasarkan Nama)");
            System.out.println("6. Cari Barang (berdasarkan Nama)");
            System.out.println("7. Keluar Aplikasi");
            System.out.print("Pilih opsi (1-7): ");

            int pilihan;
            try {
                // Membaca pilihan pengguna dan mengonversinya ke integer
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // Menangani jika input bukan angka
                System.out.println("Input tidak valid. Mohon masukkan angka.");
                continue; // Lanjutkan ke iterasi loop berikutnya untuk menampilkan menu lagi
            }

            try {
                // Memproses pilihan pengguna menggunakan switch expression (Java 12+)
                switch (pilihan) {
                    case 1 -> { // Opsi 1: Tampilkan Data Barang
                        System.out.println("\n--- Data Inventaris Saat Ini ---");
                        inventaris.tampilkanInventaris();
                    }
                    case 2 -> { // Opsi 2: Tambah Data Barang Baru
                        // Memeriksa apakah inventaris sudah penuh
                        if (inventaris.getUkuranSaatIni() >= 10) {
                            System.out.println("Inventaris penuh. Tidak dapat menambah barang lagi (maks 10).");
                            break;
                        }
                        System.out.print("Masukkan Nama Barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Jumlah Stok: ");
                        int stok = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Masukkan Harga Barang: ");
                        double harga = Double.parseDouble(scanner.nextLine().trim());

                        // Contoh penambahan sebagai Barang biasa. Bisa dikembangkan untuk memilih subtype.
                        boolean berhasilTambah = inventaris.tambahBarang(new Barang(nama, stok, harga));
                        System.out.println(berhasilTambah ? "Barang berhasil ditambahkan." : "Gagal menambahkan barang.");
                    }
                    case 3 -> { // Opsi 3: Update Data Barang
                        // Memeriksa apakah inventaris kosong
                        if (inventaris.getUkuranSaatIni() == 0) {
                            System.out.println("Inventaris kosong. Tidak ada data untuk diupdate.");
                            break;
                        }
                        inventaris.tampilkanInventaris(); // Tampilkan inventaris agar pengguna bisa memilih index
                        System.out.print("Pilih nomor data yang akan diupdate (1-" + inventaris.getUkuranSaatIni() + "): ");
                        int nomorData = Integer.parseInt(scanner.nextLine().trim());
                        int index = nomorData - 1; // Konversi nomor data ke index (0-based)

                        System.out.print("Masukkan Nama Baru: ");
                        String namaBaru = scanner.nextLine();
                        System.out.print("Masukkan Stok Baru: ");
                        int stokBaru = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Masukkan Harga Baru: ");
                        double hargaBaru = Double.parseDouble(scanner.nextLine().trim());

                        // Membuat objek Barang baru dengan data yang diupdate
                        boolean berhasilUpdate = inventaris.updateBarang(index, new Barang(namaBaru, stokBaru, hargaBaru));
                        System.out.println(berhasilUpdate ? "Data barang berhasil diupdate." : "Gagal mengupdate data barang (indeks tidak valid?).");
                    }
                    case 4 -> { // Opsi 4: Hapus Data Barang
                        // Memeriksa apakah inventaris kosong
                        if (inventaris.getUkuranSaatIni() == 0) {
                            System.out.println("Inventaris kosong. Tidak ada data untuk dihapus.");
                            break;
                        }
                        inventaris.tampilkanInventaris(); // Tampilkan inventaris agar pengguna bisa memilih index
                        System.out.print("Pilih nomor data yang akan dihapus (1-" + inventaris.getUkuranSaatIni() + "): ");
                        int nomorDataHapus = Integer.parseInt(scanner.nextLine().trim());
                        int indexHapus = nomorDataHapus - 1; // Konversi nomor data ke index (0-based)

                        boolean berhasilHapus = inventaris.hapusBarang(indexHapus);
                        System.out.println(berhasilHapus ? "Data barang berhasil dihapus." : "Gagal menghapus data barang (indeks tidak valid?).");
                    }
                    case 5 -> { // Opsi 5: Update Stok Barang berdasarkan Nama (SOAL2)
                        // Memeriksa apakah inventaris kosong
                        if (inventaris.getUkuranSaatIni() == 0) {
                            System.out.println("Inventaris kosong. Tidak ada barang untuk diupdate stoknya.");
                            break;
                        }
                        System.out.print("Masukkan Nama Barang yang stoknya akan diupdate: ");
                        String namaUpdateStok = scanner.nextLine();
                        System.out.print("Masukkan Stok Baru: ");
                        int stokBaru = Integer.parseInt(scanner.nextLine().trim());

                        boolean berhasilUpdateStok = inventaris.updateStokByNama(namaUpdateStok, stokBaru);
                        System.out.println(berhasilUpdateStok ? "Stok barang berhasil diupdate." : "Barang tidak ditemukan atau gagal update stok.");
                    }
                    case 6 -> { // Opsi 6: Cari Barang berdasarkan Nama (SOAL2)
                        // Memeriksa apakah inventaris kosong
                        if (inventaris.getUkuranSaatIni() == 0) {
                            System.out.println("Inventaris kosong. Tidak ada barang untuk dicari.");
                            break;
                        }
                        System.out.print("Masukkan Nama Barang yang ingin dicari: ");
                        String namaCari = scanner.nextLine();

                        Barang ditemukan = inventaris.cariBarangByNama(namaCari);
                        if (ditemukan != null) {
                            System.out.println("Barang ditemukan: " + ditemukan.toString());
                        } else {
                            System.out.println("Barang dengan nama '" + namaCari + "' tidak ditemukan.");
                        }
                    }
                    case 7 -> { // Opsi 7: Keluar Aplikasi
                        System.out.println("Terima kasih telah menggunakan aplikasi inventaris. Sampai jumpa!");
                        scanner.close(); // Menutup objek Scanner untuk mencegah resource leak
                        System.exit(0); // Mengakhiri program
                    }
                    default -> System.out.println("Pilihan tidak valid. Mohon masukkan angka antara 1 dan 7.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                // Menangani error umum terkait format input yang salah (misalnya saat parsing int/double)
                System.out.println("Terjadi kesalahan input. Pastikan Anda memasukkan format data yang benar.");
            } catch (IllegalArgumentException e) {
                // Menangani error dari validasi yang ada di kelas Barang dan turunannya
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                // Menangani error tak terduga lainnya
                System.out.println("Terjadi kesalahan tak terduga: " + e.getMessage());
                e.printStackTrace(); // Cetak stack trace untuk debugging lebih lanjut
            }
        }
    }
}
