/**
 * Kelas BarangTulisan adalah subclass dari Barang,
 * merepresentasikan jenis barang alat tulis dengan atribut tambahan 'jenis'.
 * Contoh jenis: "HB", "Buku Tulis", dll.
 */
public class BarangTulisan extends Barang {
    private String jenis; // Atribut khusus untuk barang tulisan, e.g., "HB", "Buku Tulis"

    /**
     * Konstruktor untuk membuat objek BarangTulisan.
     * Memanggil konstruktor superclass (Barang) dan menginisialisasi atribut 'jenis'.
     */
    public BarangTulisan(String nama, int stok, double harga, String jenis) {
        super(nama, stok, harga); // Memanggil konstruktor yang sesuai di kelas Barang
        setJenis(jenis);         // Memanggil setter untuk validasi dan inisialisasi jenis
    }

    /**
     * Mengembalikan jenis barang tulisan.
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * Mengatur jenis barang tulisan.
     * Melakukan validasi: jenis tidak boleh null atau kosong.
     */
    public void setJenis(String jenis) {
        if (jenis == null || jenis.isBlank()) {
            throw new IllegalArgumentException("Jenis barang tulisan tidak boleh kosong.");
        }
        this.jenis = jenis.trim(); // Menghilangkan spasi di awal/akhir jenis
    }

    /**
     * Meng-override metode getKategori() dari kelas Barang.
     * Mengembalikan kategori spesifik untuk barang alat tulis.
     */
    @Override
    public String getKategori() {
        return "Alat Tulis";
    }

    /**
     * Meng-override metode toString() dari kelas Barang.
     * Menambahkan informasi kategori dan jenis ke representasi string standar.
     */
    @Override
    public String toString() {
        // Memanggil toString() dari superclass untuk mendapatkan detail dasar,
        // lalu menambahkan detail spesifik BarangTulisan.
        return super.toString() +
               " (Kategori: " + getKategori() +
               ", Jenis: " + jenis + ")";
    }
}
