import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mahasiswa[] daftarMahasiswa = new Mahasiswa[3];
        MataKuliah[] daftarMatkul = new MataKuliah[3];
        Penilaian[] daftarNilai = new Penilaian[5];   
        
        daftarMahasiswa[0] = new Mahasiswa("22001", "Ali Rahman", "Informatika");
        daftarMahasiswa[1] = new Mahasiswa("22002", "Budi Santoso", "Informatika");
        daftarMahasiswa[2] = new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");

        daftarMatkul[0] = new MataKuliah("MK001", "Struktur Data", 3);
        daftarMatkul[1] = new MataKuliah("MK002", "Basis Data", 3);
        daftarMatkul[2] = new MataKuliah("MK003", "Desain Web", 3);

        daftarNilai[0] = new Penilaian(daftarMahasiswa[0], daftarMatkul[0], 80, 85, 90);
        daftarNilai[1] = new Penilaian(daftarMahasiswa[0], daftarMatkul[1], 60, 75, 70);
        daftarNilai[2] = new Penilaian(daftarMahasiswa[1], daftarMatkul[0], 75, 70, 80);
        daftarNilai[3] = new Penilaian(daftarMahasiswa[2], daftarMatkul[1], 85, 90, 95);
        daftarNilai[4] = new Penilaian(daftarMahasiswa[2], daftarMatkul[2], 80, 90, 65);

        int pilihan;
        do {
            System.out.println("\n===== MENU SISTEM AKADEMIK =====");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    for (Mahasiswa m : daftarMahasiswa) {
                        m.tampilMahasiswa();
                    }
                    break;

                case 2:
                    System.out.println("\nDaftar Mata Kuliah:");
                    for (MataKuliah mk : daftarMatkul) {
                        mk.tampilMataKuliah();
                    }
                    break;

                case 3:
                    System.out.println("\nData Penilaian:");
                    for (Penilaian p : daftarNilai) {
                        p.tampilPenilaian();
                    }
                    break;

                case 4:
                    System.out.println("\nNilai Diurutkan (Tertinggi ke Terendah):");
                
                    for (int i = 0; i < daftarNilai.length - 1; i++) {
                        for (int j = 0; j < daftarNilai.length - i - 1; j++) {
                            if (daftarNilai[j].nilaiAkhir < daftarNilai[j + 1].nilaiAkhir) {
                                Penilaian temp = daftarNilai[j];
                                daftarNilai[j] = daftarNilai[j + 1];
                                daftarNilai[j + 1] = temp;
                            }
                        }
                    }
                
                    for (Penilaian p : daftarNilai) {
                        p.tampilPenilaian();
                    }
                    break;
            
                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimDicari = scanner.nextLine();
                    boolean ketemu = false;
                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.NIM.equals(nimDicari)) {
                            System.out.println("Mahasiswa ditemukan:");
                            m.tampilMahasiswa();
                            ketemu = true;
                        }
                    }
                    if (!ketemu) {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}