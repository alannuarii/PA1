/**
 * Kelas Inventaris mengelola koleksi objek Barang menggunakan array.
 * Kelas ini menyediakan fungsionalitas untuk menambah, menampilkan, mengupdate,
 * menghapus, mencari, dan mengubah stok barang dalam inventaris.
 */
public class Inventaris {
    // Array untuk menyimpan objek Barang. Kapasitas maksimum inventaris adalah 10.
    private final Barang[] daftarBarang;
    // Variabel untuk melacak jumlah barang yang saat ini ada di inventaris.
    // Ini juga berfungsi sebagai indeks berikutnya yang tersedia di array.
    private int jumlahBarangSaatIni;

    /**
     * Konstruktor untuk kelas Inventaris.
     * Menginisialisasi array daftarBarang dengan kapasitas 10 dan
     * mengatur jumlahBarangSaatIni menjadi 0.
     */
    public Inventaris() {
        this.daftarBarang = new Barang[10]; // Kapasitas inventaris tetap 10
        this.jumlahBarangSaatIni = 0;
    }

    /**
     * Menambahkan objek Barang baru ke dalam inventaris.
     */
    public boolean tambahBarang(Barang barang) {
        // Memeriksa apakah objek barang yang akan ditambahkan tidak null
        if (barang == null) {
            System.out.println("Error: Objek barang tidak boleh null.");
            return false;
        }
        // Memeriksa apakah inventaris sudah mencapai kapasitas maksimum
        if (jumlahBarangSaatIni >= daftarBarang.length) {
            System.out.println("Error: Inventaris sudah penuh (kapasitas " + daftarBarang.length + ").");
            return false;
        }
        // Menambahkan barang ke posisi yang tersedia dan memperbarui jumlah barang
        daftarBarang[jumlahBarangSaatIni++] = barang;
        return true;
    }

    /**
     * Menampilkan semua barang yang ada di inventaris.
     * Jika inventaris kosong, akan mencetak pesan yang sesuai.
     */
    public void tampilkanInventaris() {
        if (jumlahBarangSaatIni == 0) {
            System.out.println("(Inventaris kosong. Silakan tambahkan barang.)");
            return;
        }
        // Melakukan iterasi dan menampilkan detail setiap barang
        for (int i = 0; i < jumlahBarangSaatIni; i++) {
            // Menggunakan (i + 1) untuk nomor urut yang dimulai dari 1
            System.out.println((i + 1) + ". " + daftarBarang[i].toString());
        }
    }

    /**
     * Mengembalikan jumlah barang yang saat ini ada di inventaris.
     */
    public int getUkuranSaatIni() {
        return jumlahBarangSaatIni;
    }

    /**
     * Mengembalikan objek Barang pada indeks tertentu.
     */
    public Barang getBarangAt(int index0Based) {
        if (index0Based < 0 || index0Based >= jumlahBarangSaatIni) {
            throw new IndexOutOfBoundsException("Indeks barang tidak valid: " + index0Based);
        }
        return daftarBarang[index0Based];
    }

    /**
     * Mengupdate objek Barang pada indeks tertentu dengan objek Barang baru.
     */
    public boolean updateBarang(int index0Based, Barang barangBaru) {
        // Memeriksa validitas indeks dan objek barangBaru
        if (index0Based < 0 || index0Based >= jumlahBarangSaatIni) {
            System.out.println("Error: Indeks update tidak valid.");
            return false;
        }
        if (barangBaru == null) {
            System.out.println("Error: Objek barang baru tidak boleh null.");
            return false;
        }
        // Mengganti barang lama dengan barang baru di indeks yang ditentukan
        daftarBarang[index0Based] = barangBaru;
        return true;
    }

    /**
     * Menghapus objek Barang pada indeks tertentu.
     * Setelah penghapusan, elemen-elemen selanjutnya akan digeser untuk
     * menghindari "lubang" (null-pointer) dalam array.
     */
    public boolean hapusBarang(int index0Based) {
        // Memeriksa validitas indeks
        if (index0Based < 0 || index0Based >= jumlahBarangSaatIni) {
            System.out.println("Error: Indeks penghapusan tidak valid.");
            return false;
        }
        // Menggeser elemen-elemen setelah indeks yang dihapus ke kiri
        for (int i = index0Based; i < jumlahBarangSaatIni - 1; i++) {
            daftarBarang[i] = daftarBarang[i + 1];
        }
        // Mengurangi jumlah barang dan 'mengosongkan' elemen terakhir yang digeser
        daftarBarang[jumlahBarangSaatIni - 1] = null; // Menghapus referensi objek terakhir
        jumlahBarangSaatIni--;
        return true;
    }

    // === Metode untuk SOAL 2 ===

    /**
     * Mengupdate jumlah stok barang berdasarkan namanya (case-insensitive).
     */
    public boolean updateStokByNama(String nama, int stokBaru) {
        int index = cariIndexByNama(nama); // Mencari indeks barang berdasarkan nama
        if (index == -1) { // Jika barang tidak ditemukan
            System.out.println("Barang dengan nama '" + nama + "' tidak ditemukan.");
            return false;
        }
        // Mengupdate stok barang menggunakan setter yang ada di kelas Barang
        daftarBarang[index].setJumlahStok(stokBaru);
        return true;
    }

    /**
     * Mencari objek Barang berdasarkan namanya (case-insensitive).
     */
    public Barang cariBarangByNama(String nama) {
        int index = cariIndexByNama(nama); // Mencari indeks barang
        return (index == -1) ? null : daftarBarang[index]; // Mengembalikan objek atau null
    }

    /**
     * Metode helper privat untuk mencari indeks barang berdasarkan namanya.
     * Pencarian dilakukan secara case-insensitive.
     */
    private int cariIndexByNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            return -1; // Nama tidak valid
        }
        // Iterasi melalui daftar barang untuk mencari nama yang cocok
        for (int i = 0; i < jumlahBarangSaatIni; i++) {
            // Membandingkan nama barang secara case-insensitive setelah menghilangkan spasi di awal/akhir
            if (daftarBarang[i].getNama().equalsIgnoreCase(nama.trim())) {
                return i; // Mengembalikan indeks jika nama ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika barang tidak ditemukan
    }
}
