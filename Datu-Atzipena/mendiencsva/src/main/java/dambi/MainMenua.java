package dambi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.-Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Mendirik baxuena bistaratu");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    met1();
                    break;
                case 2:
                    met2();
                    break;
                case 3:
                    met3();
                    break;
                case 4:
                    met4();
                    break;

                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    public static void met1() {

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("Mendiak.csv"))) {

            System.out.println("|------------|---------|------------|");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 3) {
                    String mendia = values[0];
                    String altuera = values[1];
                    String probintzia = values[2];

                    System.out.printf("| %-10s | %-7s | %-10s |\n", mendia, altuera, probintzia);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ez da aurkitu: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void met2() {
        String line;
        int max = 0;
        String biggest = "null";
        String provin = "";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("Mendiak.csv"))) {

            while ((line = br.readLine()) != null) {
                i++;
                String[] values = line.split(";");
                if (values.length == 3) {
                    String mendia = values[0];
                    String altuera = values[1];
                    String probintzia = values[2];

                    if (i > 1) {
                        int numero = Integer.parseInt(altuera);
                        if (numero > max) {
                            max = numero;
                            biggest = mendia;
                            provin = probintzia;
                        }
                    }

                }
            }
            System.out.println(biggest + ", " + max + ", " + provin);
        } catch (FileNotFoundException e) {
            System.err.println("Ez da aurkitu: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void met3() {
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("Mendiak.csv"));

            String line;

            while ((line = inputStream.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 3) {
                    String province = values[2];
                    String mendia = values[0];
                    String altuera = values[1];

                    // Write the original line to characteroutput.txt

                    // Write the data to the corresponding CSV file
                    try (FileWriter provinceWriter = new FileWriter(province + ".csv", true)) {
                        provinceWriter.write(mendia + ";" + altuera + ";" + province + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Close the input and output streams
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void met4() {
        String line;
        int min = Integer.MAX_VALUE;
        String smallest = "null";
        String provin = "";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("Mendiak.csv"))) {

            while ((line = br.readLine()) != null) {
                i++;
                String[] values = line.split(";");
                if (values.length == 3) {
                    String mendia = values[0];
                    String altuera = values[1];
                    String probintzia = values[2];

                    if (i > 1) {
                        int numero = Integer.parseInt(altuera);
                        if (numero < min) {
                            min = numero;
                            smallest = mendia;
                            provin = probintzia;
                        }
                    }

                }
            }
            System.out.println(smallest + ", " + min + ", " + provin);
        } catch (FileNotFoundException e) {
            System.err.println("Ez da aurkitu: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
