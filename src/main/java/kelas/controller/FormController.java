package kelas.controller;

import java.io.InputStream;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.data.DataPembelian;
import kelas.model.Produk;

public class FormController {

    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgSparkles;

    @FXML
    private ImageView imgBanner;

    @FXML
    private TextField txtKode;

    @FXML
    private TextField txtNama;

    @FXML
    private ComboBox<String> cbKategori;

    @FXML
    private TextField txtHarga;

    @FXML
    private Label lblPesanError;

    @FXML
    public void initialize() {
        pasangGambar(imgLogo, "/kelas/images/images-removebg-preview.png");
        pasangGambar(imgSparkles, "/kelas/images/sparkles_blue-removebg-preview.png");
        pasangGambar(imgBanner, "/kelas/images/Gemini_Generated_Image_dgqyavdgqyavdgqy-removebg-preview.png");

        cbKategori.setItems(FXCollections.observableArrayList("Makanan", "Minuman"));
        cbKategori.getSelectionModel().selectFirst();
        if (lblPesanError != null) {
            lblPesanError.setText("");
        }
    }

    private void pasangGambar(ImageView view, String resourcePath) {
        if (view == null) return;
        try {
            InputStream is = getClass().getResourceAsStream(resourcePath);
            if (is != null) {
                view.setImage(new Image(is));
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat gambar: " + resourcePath);
        }
    }

    @FXML
    private void handleSimpan() {
        String kode = txtKode.getText() != null ? txtKode.getText().trim() : "";
        String nama = txtNama.getText() != null ? txtNama.getText().trim() : "";
        String kategori = cbKategori.getValue();
        String hargaText = txtHarga.getText() != null ? txtHarga.getText().trim() : "";

        if (kode.isEmpty()) {
            tampilkanError("Kode produk tidak boleh kosong!");
            return;
        }

        if (nama.isEmpty()) {
            tampilkanError("Nama produk tidak boleh kosong!");
            return;
        }

        double harga;
        try {
            harga = Double.parseDouble(hargaText);
            if (harga <= 0) {
                tampilkanError("Harga produk harus lebih dari nol!");
                return;
            }
        } catch (NumberFormatException e) {
            tampilkanError("Harga tidak valid! Masukkan angka lebih dari 0.");
            return;
        }

        Produk produkBaru = new Produk(kode, nama, kategori, harga);
        DataPembelian.tambahProduk(produkBaru);
        Navigator.showDaftar();
    }

    @FXML
    private void handleKembali() {
        Navigator.showDaftar();
    }

    private void tampilkanError(String pesan) {
        if (lblPesanError != null) {
            lblPesanError.setText(pesan);
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Tidak Valid");
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}