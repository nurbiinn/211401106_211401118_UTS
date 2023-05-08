import java.util.Scanner;

public class Main{
    
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        int choice;
        do {
            clearScreen();
            displayMainMenu();
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reservationSystem.handleReservation(scanner);
                    break;
                case 2:
                    reservationSystem.calculateDailyIncome();
                    break;
                case 3:
                    reservationSystem.calculateProfit();
                    break;
                case 4:
                    reservationSystem.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
            System.out.println();
        } while (choice != 5);
    }

    private static void displayMainMenu() {
        System.out.println("+=====================================+");
        System.out.println("|                                     |");
        System.out.println("|              HOTEL MENU             |");
        System.out.println("|                                     |");
        System.out.println("+=====================================+");
        System.out.println("|                                     |");
        System.out.println("|       1. Reservasi Kamar            |");
        System.out.println("|       2. Perhitungan Hari Ini       |");
        System.out.println("|       3. Keuntungan Hari Ini        |");
        System.out.println("|       4. Daftar Transaksi           |");
        System.out.println("|       5. Keluar                     |");
        System.out.println("|                                     |");
        System.out.println("+=====================================+");
    }
}