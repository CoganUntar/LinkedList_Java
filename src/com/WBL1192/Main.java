package com.WBL1192;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList thelist = new LinkedList();

        int pilihan = 0;

        do {
            String menu = "Menu: \n" +
                    "0. Keluar\n" +
                    "1. Masukan data baru\n" +
                    "2. Hapus data\n" +
                    "3. Tampilkan isi linkedlist\n" +
                    "Pilihan Anda = ";
            System.out.print(menu);

            Scanner scan = new Scanner(System.in);
            pilihan = Integer.parseInt(scan.nextLine());

            switch (pilihan) {
                case 1 :
                    String inputmenu = "\nMasukan data baru:\n" +
                            "1. Di awal list\n" +
                            "2. Di posisi tertentu\n" +
                            "3. Di akhir\n" +
                            "Pilihan Anda = ";
                    System.out.print(inputmenu);
                    int pilInput = Integer.parseInt(scan.nextLine());

                    inputmenu = "Masukan string = ";
                    System.out.print(inputmenu);
                    String data = scan.nextLine();

                    switch (pilInput) {
                        case 1 :
                            thelist.insertHead(data);
                            break;

                        case 2 :
                            System.out.print("Posisi = ");
                            int pos = scan.nextInt();
                            thelist.insertMiddle(data, pos);
                            break;

                        case 3 :
                            thelist.insertTail(data);
                            break;

                        default :
                            System.out.println("Input salah");
                            return;
                    }
                    break;

                case 2 :
                    System.out.print("Posisi yang akan dihapus = ");
                    int pos = scan.nextInt();
                    if (thelist.removeNode(pos))
                        System.out.println("Berhasil!");
                    else
                        System.out.println("Gagal");
                    break;

                case 3 :
                    System.out.println(thelist.toString());
                    break;

                case 0 : break;

                default :
                    System.out.println("Input salah");
                    break;
            }
        } while (pilihan != 0);
    }
}
