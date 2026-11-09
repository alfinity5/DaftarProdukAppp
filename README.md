
[readme.md](https://github.com/user-attachments/files/34581353/readme.md)
# Aplikasi Daftar Produk Toko (JavaFX Maven)

Aplikasi desktop berbasis JavaFX dan Maven yang dikembangkan untuk memodifikasi sistem pencatatan tiket praktikum menjadi sistem manajemen dan pencatatan produk toko (Makanan & Minuman). Aplikasi ini dibangun dengan arsitektur **MVC (Model-View-Controller)** dan memanfaatkan antarmuka FXML serta kustomisasi CSS.

## Fitur Utama

1. **Form Tambah Produk:** Input data produk baru yang mencakup:
   * Kode Produk
   * Nama Produk
   * Kategori (`Makanan` atau `Minuman` via `ComboBox`)
   * Harga Produk (> 0)
2. **Validasi Input:** Sistem menolak penyimpanan data jika kolom nama produk kosong atau harga bernilai negatif/nol.
3. **Tabel Daftar Produk (`TableView`):** Menampilkan seluruh produk yang tersimpan secara *in-memory* lengkap dengan pemformatan harga otomatis (Rupiah).
4. **Pencarian Produk:** Fitur pencarian interaktif untuk memfilter daftar produk berdasarkan nama atau kode produk.
5. **Halaman Detail Produk:** Meninjau rincian lengkap dari produk yang dipilih melalui tabel.

## Tangkapan Layar Aplikasi (Screenshots)

| Halaman Daftar Produk | Halaman Form Tambah Produk |
| :---: | :---: |
|<img width="638" height="547" alt="Screenshot 2026-11-09 204258" src="https://github.com/user-attachments/assets/d814df4f-6f4e-4a77-bc2b-38eb532dff87" /> | 
 | <img width="460" height="530" alt="Screenshot 2026-11-09 204231" src="https://github.com/user-attachments/assets/3fb84095-1ebb-4f2e-b484-15442a8f6006" />
 |
| *Tampilan utama tabel daftar produk dan fitur pencarian* | *Form input produk baru dengan pilihan kategori* |

| Halaman Detail Produk |
| :---: | :---: |
|  <img width="425" height="448" alt="Screenshot 2026-11-09 204311" src="https://github.com/user-attachments/assets/2ce06e4e-9a22-4966-883f-916485970562" />|
| *Menampilkan informasi lengkap dari produk yang dipilih* | *Peringatan saat nama kosong atau harga tidak valid* |

> **Catatan:** Simpan gambar hasil tangkapan layar aplikasi Anda di dalam folder `screenshots/` pada direktori utama proyek dengan nama file yang sesuai (`daftar-produk.png`, `form-tambah.png`, `detail-produk.png`, dan `validasi-error.png`).

## Struktur Proyek

```text
TiketAppAdvanced/
├── screenshots/                 # Folder dokumentasi tangkapan layar aplikasi
│   ├── daftar-produk.png
│   ├── form-tambah.png
│   ├── detail-produk.png
│   └── validasi-error.png
├── src/main/java/kelas/
│   ├── MainApp.java             # Entry point aplikasi JavaFX
│   ├── Navigator.java           # Pengelola perpindahan antar scene FXML
│   ├── controller/
│   │   ├── DaftarController.java# Logika tabel, pencarian, dan navigasi utama
│   │   ├── FormController.java  # Validasi dan penyimpanan data produk baru
│   │   └── DetailController.java# Penampil rincian data produk terpilih
│   ├── data/
│   │   └── DataPembelian.java   # Penyimpanan sementara (ObservableList)
│   └── model/
│       └── Produk.java          # Class objek produk (private attributes, getter)
└── src/main/resources/kelas/
    ├── daftar.fxml              # UI Halaman Utama & Tabel
    ├── form.fxml                # UI Form Tambah Produk
    ├── detail.fxml              # UI Detail Produk
    ├── images/                  # Aset gambar, logo, dan banner aplikasi
    └── styles/
        └── app.css              # Kustomisasi stylesheet aplikasi
```

## ⚙️ Cara Menjalankan Proyek

1. **Clone repositori ini:**
   ```bash
   git clone https://github.com/username/repository-name.git
   ```
2. Buka proyek melalui **NetBeans** (atau IDE pilihan Anda yang mendukung Maven dan JavaFX).
3. Lakukan **Clean and Build** (`Shift + F11`) untuk memastikan seluruh resource asset dan dependensi terkompilasi dengan baik.
4. Jalankan aplikasi melalui file `MainApp.java` (`F6`).
