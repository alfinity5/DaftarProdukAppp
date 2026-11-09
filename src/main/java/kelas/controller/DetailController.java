package kelas.controller;

import java.io.InputStream;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {

    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgSparkles;

    @FXML
    private ImageView imgBanner;

    @FXML
    private Label lblKode;

    @FXML
    private Label lblNama;

    @FXML
    private Label lblKategori;

    @FXML
    private Label lblHarga;

    @FXML
    public void initialize() {
        pasangGambar(imgLogo, "/kelas/images/images-removebg-preview.png");
        pasangGambar(imgSparkles, "/kelas/images/sparkles_blue-removebg-preview.png");
        pasangGambar(imgBanner, "/kelas/images/Gemini_Generated_Image_dgqyavdgqyavdgqy-removebg-preview.png");
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

    public void setProduk(Produk produk) {
        if (produk != null) {
            lblKode.setText(produk.getKode());
            lblNama.setText(produk.getNama());
            lblKategori.setText(produk.getKategori());
            lblHarga.setText(produk.getHargaFormatted());
        }
    }

    @FXML
    private void handleKembali() {
        Navigator.showDaftar();
    }
}