/**
 * Kelas BarangElektronik adalah subclass dari Barang,
 * merepresentasikan jenis barang elektronik dengan atribut tambahan 'garansiBulan'.
 * Nilai garansi diukur dalam bulan.
 */
public class BarangElektronik extends Barang {
    private int garansiBulan; // Atribut khusus untuk barang elektronik: Durasi garansi dalam bulan

    /**
     * Konstruktor untuk membuat objek BarangElektronik.
     * Memanggil konstruktor superclass (Barang) dan menginisialisasi atribut 'garansiBulan'.
     */
    public BarangElektronik(String nama, int stok, double harga, int garansiBulan) {
        super(nama, stok, harga); // Memanggil konstruktor yang sesuai di kelas Barang
        setGaransiBulan(garansiBulan); // Memanggil setter untuk validasi dan inisialisasi garansi
    }

    /**
     * Mengembalikan durasi garansi barang elektronik dalam bulan.
     */
    public int getGaransiBulan() {
        return garansiBulan;
    }

    /**
     * Mengatur durasi garansi barang elektronik dalam bulan.
     * Melakukan validasi: garansi tidak boleh negatif.
     */
    public void setGaransiBulan(int garansiBulan) {
        if (garansiBulan < 0) {
            throw new IllegalArgumentException("Garansi tidak boleh negatif.");
        }
        this.garansiBulan = garansiBulan;
    }

    /**
     * Meng-override metode getKategori() dari kelas Barang.
     * Mengembalikan kategori spesifik untuk barang elektronik.
     */
    @Override
    public String getKategori() {
        return "Elektronik";
    }

    /**
     * Meng-override metode toString() dari kelas Barang.
     * Menambahkan informasi kategori dan garansi ke representasi string standar.
     */
    @Override
    public String toString() {
        // Memanggil toString() dari superclass untuk mendapatkan detail dasar,
        // lalu menambahkan detail spesifik BarangElektronik.
        return super.toString() +
               " (Kategori: " + getKategori() +
               ", Garansi: " + garansiBulan + " bln)";
    }
}
