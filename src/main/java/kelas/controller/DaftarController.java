package kelas.controller;

import java.io.InputStream;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import kelas.data.DataPembelian;
import kelas.model.Produk;

public class DaftarController {

    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgSparkles;

    @FXML
    private ImageView imgBanner;

    @FXML
    private TextField txtCari;

    @FXML
    private TableView<Produk> tblProduk;

    @FXML
    private TableColumn<Produk, String> colKode;

    @FXML
    private TableColumn<Produk, String> colNama;

    @FXML
    private TableColumn<Produk, String> colKategori;

    @FXML
    private TableColumn<Produk, String> colHarga;

    @FXML
    public void initialize() {
        // Memastikan ketiga gambar dimuat langsung dari classpath resources
        pasangGambar(imgLogo, "/kelas/images/images-removebg-preview.png");
        pasangGambar(imgSparkles, "/kelas/images/sparkles_blue-removebg-preview.png");
        pasangGambar(imgBanner, "/kelas/images/Gemini_Generated_Image_dgqyavdgqyavdgqy-removebg-preview.png");

        // Konfigurasi kolom tabel
        colKode.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getKode()));
        colNama.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNama()));
        colKategori.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getKategori()));
        colHarga.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getHargaFormatted()));

        // Menampilkan data produk
        tblProduk.setItems(DataPembelian.getDaftarProduk());
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
    private void handleCari() {
        String kataKunci = txtCari.getText();
        tblProduk.setItems(DataPembelian.cariBerdasarkanNama(kataKunci));
    }

    @FXML
    private void handleTambah() {
        Navigator.showForm();
    }

    @FXML
    private void handleLihatDetail() {
        Produk dipilih = tblProduk.getSelectionModel().getSelectedItem();
        if (dipilih == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Pilih salah satu produk pada tabel terlebih dahulu!");
            alert.showAndWait();
            return;
        }
        Navigator.showDetail(dipilih);
    }
}