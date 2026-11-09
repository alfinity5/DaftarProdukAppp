package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

public class DataPembelian {
    private static final ObservableList<Produk> daftarProduk = FXCollections.observableArrayList();

    public static void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public static ObservableList<Produk> getDaftarProduk() {
        return daftarProduk;
    }

    public static ObservableList<Produk> cariBerdasarkanNama(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return daftarProduk;
        }
        ObservableList<Produk> hasil = FXCollections.observableArrayList();
        String cari = keyword.trim().toLowerCase();
        for (Produk p : daftarProduk) {
            boolean cocokNama = p.getNama() != null && p.getNama().toLowerCase().contains(cari);
            boolean cocokKode = p.getKode() != null && p.getKode().toLowerCase().contains(cari);
            if (cocokNama || cocokKode) {
                hasil.add(p);
            }
        }
        return hasil;
    }
}