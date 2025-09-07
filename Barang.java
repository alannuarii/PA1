/**
 * Kelas abstrak Barang merepresentasikan item dasar dalam inventaris.
 * Kelas ini mencakup atribut umum seperti nama, jumlah stok, dan harga.
 * Menerapkan prinsip enkapsulasi dengan getter dan setter yang memiliki validasi.
 * Juga mendefinisikan metode abstrak atau hook untuk polymorphism.
 */
public class Barang {
    private String nama;       // Nama barang (tidak boleh kosong)
    private int jumlahStok;    // Jumlah stok barang (tidak boleh negatif)
    private double harga;      // Harga barang (tidak boleh negatif)

    /**
     * Konstruktor untuk membuat objek Barang.
     * Menginisialisasi nama, jumlah stok, dan harga barang.
     * Melakukan validasi melalui metode setter yang dipanggil.
     */
    public Barang(String nama, int jumlahStok, double harga) {
        setNama(nama);           // Memanggil setter untuk validasi nama
        setJumlahStok(jumlahStok); // Memanggil setter untuk validasi stok
        setHarga(harga);         // Memanggil setter untuk validasi harga
    }

    // === ENKAPSULASI: GETTER DAN SETTER DENGAN VALIDASI ===
    /**
     * Mengembalikan nama barang.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengatur nama barang.
     * Melakukan validasi: nama tidak boleh null atau kosong.
     */
    public void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong.");
        }
        this.nama = nama.trim(); // Menghilangkan spasi di awal/akhir nama
    }

    /**
     * Mengembalikan jumlah stok barang.
     */
    public int getJumlahStok() {
        return jumlahStok;
    }

    /**
     * Mengatur jumlah stok barang.
     * Melakukan validasi: jumlah stok tidak boleh negatif.
     */
    public void setJumlahStok(int jumlahStok) {
        if (jumlahStok < 0) {
            throw new IllegalArgumentException("Jumlah stok tidak boleh negatif.");
        }
        this.jumlahStok = jumlahStok;
    }

    /**
     * Mengembalikan harga barang.
     */
    public double getHarga() {
        return harga;
    }

    /**
     * Mengatur harga barang.
     * Melakukan validasi: harga tidak boleh negatif.
     */
    public void setHarga(double harga) {
        if (harga < 0) {
            throw new IllegalArgumentException("Harga barang tidak boleh negatif.");
        }
        this.harga = harga;
    }

    // === ABSTRAKSI DAN POLYMORPHISM ===

    /**
     * Mengembalikan representasi string dari objek Barang.
     * Menggunakan FormatUtil untuk memformat harga menjadi mata uang Rupiah.
     */
    @Override
    public String toString() {
        return "Nama: " + nama +
               ", Stok: " + jumlahStok +
               ", Harga: " + FormatUtil.rupiah(harga);
    }

    /**
     * Metode hook untuk polymorphism yang mengembalikan kategori barang.
     * Metode ini dapat di-override oleh subclass untuk mendefinisikan kategori spesifik.
     * Secara default, kategori adalah "Umum".
     */
    public String getKategori() {
        return "Umum";
    }
}
