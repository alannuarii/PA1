import java.text.NumberFormat; // Diperlukan untuk memformat angka menjadi format mata uang
import java.util.Locale; // Diperlukan untuk menentukan lokalisasi (negara, bahasa)

/**
 * Kelas utilitas FormatUtil menyediakan metode statis untuk memformat nilai numerik
 * menjadi representasi mata uang Rupiah Indonesia (IDR).
 * Kelas ini dirancang sebagai utilitas dan tidak dapat diinstansiasi (private constructor).
 */
public class FormatUtil {

    // Objek NumberFormat statis yang dikonfigurasi untuk format mata uang Rupiah Indonesia.
    // Dibuat sekali saat kelas dimuat untuk efisiensi.
    // Locale.forLanguageTag("id-ID") adalah cara modern untuk membuat Locale untuk Indonesia,
    // mengatasi peringatan deprecated pada konstruktor Locale(String, String).
    private static final NumberFormat IDR_FORMATTER = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));

    /**
     * Konstruktor privat untuk mencegah instansiasi kelas utilitas ini.
     * Semua metode yang disediakan adalah statis.
     */
    private FormatUtil() {
        // Konstruktor kosong dan privat
    }

    /**
     * Memformat nilai double menjadi representasi string dalam format mata uang Rupiah Indonesia.
     * Contoh: 15000.0 akan diformat menjadi "Rp15.000,00" atau "$ 15,000.00" tergantung default locale
     */
    public static String rupiah(double value) {
        return IDR_FORMATTER.format(value);
    }
}
