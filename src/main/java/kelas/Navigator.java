package kelas;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kelas.controller.DetailController;
import kelas.model.Produk;

public class Navigator {
    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    private static void gantiHalaman(Parent root, String judul) {
        Scene scene = new Scene(root);
        URL cssUrl = Navigator.class.getResource("/kelas/styles/app.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }
        stage.setTitle(judul);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();
    }

    public static void showDaftar() {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/kelas/daftar.fxml"));
            Parent root = loader.load();
            gantiHalaman(root, "Daftar Produk Toko");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showForm() {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/kelas/form.fxml"));
            Parent root = loader.load();
            gantiHalaman(root, "Form Tambah Produk Toko");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showDetail(Produk produk) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/kelas/detail.fxml"));
            Parent root = loader.load();
            DetailController controller = loader.getController();
            controller.setProduk(produk);
            gantiHalaman(root, "Detail Produk Toko");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}