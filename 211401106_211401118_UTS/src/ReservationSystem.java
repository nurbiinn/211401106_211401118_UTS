import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {
    private List<Transaction> transactions;
    private List<Room> rooms;

    public ReservationSystem() {
        transactions = new ArrayList<>();
        rooms = new ArrayList<>();
        rooms.add(new EconomyRoom("E1", 5));
        rooms.add(new BusinessRoom("B1", 4));
        rooms.add(new SuiteRoom("S1", 3));
    }

    public void handleReservation(Scanner scanner) {
        displayRoomMenu();
        System.out.print("Pilih jenis kamar: ");
        int roomType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan jumlah kamar yang dipesan: ");
        int roomCount = scanner.nextInt();
        scanner.nextLine();

        Room room = getRoomByType(roomType);
        if (room != null) {
            System.out.print("Masukkan nama pemesan: ");
            String customerName = scanner.nextLine();
            if (room.reserveRoom(roomCount)) {
                Transaction transaction = new Transaction(customerName, room, roomCount);
                transactions.add(transaction);
                System.out.println("Reservasi kamar berhasil!");
            } else {
                System.out.println("Maaf, kamar tidak tersedia.");
            }
        } else {
            System.out.println("Jenis kamar tidak valid.");
        }
    }

    private Room getRoomByType(int roomType) {
        switch (roomType) {
            case 1:
                return rooms.get(0); // Economy Room
            case 2:
                return rooms.get(1); // Business Room
            case 3:
                return rooms.get(2); // Suite Room
            default:
                return null;
        }
    }

    public void calculateDailyIncome() {
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
            totalIncome += transaction.getTotalPrice();
        }
        System.out.println("Total pemasukan hari ini: Rp " + totalIncome);
    }
    
    public void calculateProfit() {
        double totalIncome = 0;
        double totalProductionCost = 0;
        double totalServiceCost = 0;
    
        for (Transaction transaction : transactions) {
            totalIncome += transaction.getTotalPrice();
            totalProductionCost += transaction.getRoom().getProductionCost();
            totalServiceCost += transaction.getRoom().getServiceCost();
        }
    
        double totalCost = totalProductionCost + totalServiceCost;
        double profit = totalIncome - totalCost;
        double tax = 0.1 * (totalIncome + totalProductionCost);
    
        System.out.println("Total omset penjualan: Rp " + totalIncome);
        System.out.println("Total biaya produksi: Rp " + totalProductionCost);
        System.out.println("Total biaya layanan: Rp " + totalServiceCost);
        System.out.println("Total biaya: Rp " + totalCost);
        System.out.println("Total pajak: Rp " + tax);
        System.out.println("Keuntungan bersih: Rp " + profit);
    }
    
    public void displayTransactionHistory() {
        System.out.println("+=====================================+");
        System.out.println("|         HISTORI TRANSAKSI           |");
        System.out.println("+=====================================+");
        System.out.println("| Nama Pemesan |   Jenis Kamar  | Qty |");
        System.out.println("+=====================================+");
    
        for (Transaction transaction : transactions) {
            System.out.printf("| %s | %s | %d |\n",
                    transaction.getCustomerName(), transaction.getRoom().getType(), transaction.getRoomCount());
        }
    
        System.out.println("+=====================================+");
    }
    
    private void displayRoomMenu() {
        System.out.println("+=====================================+");
        System.out.println("|                                     |");
        System.out.println("|           PILIH JENIS KAMAR         |");
        System.out.println("|                                     |");
        System.out.println("+=====================================+");
        System.out.println("|                                     |");
        System.out.println("|    1. Economy Room (Rp 250,000)     |");
        System.out.println("|    2. Business Room (Rp 750,000)    |");
        System.out.println("|    3. Suite Room (Rp 1,500,000)     |");
        System.out.println("|                                     |");
        System.out.println("+=====================================+");
    }
}
