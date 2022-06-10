import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Nereden Gideceğinizi Girin :");
        String where = scanner.nextLine();

        System.out.println("Gidecğiniz Yeri Girin :");
        String toWhere = scanner.nextLine();

       /* System.out.println("Gitmek İstediğiniz Yılı Girin :");
        String date = scanner.nextLine();

        System.out.println("Gitmek İstediğiniz Ayı Girin :");
        String month = scanner.nextLine();
        System.out.println("Gitmek İstediğiniz Günü Girin :");
        String day = scanner.nextLine();*/


        EnuygunApp app = new EnuygunApp();
        app.moveToPlaneTicket();
        app.where(where);
        app.toWhere(toWhere);
        app.date();

    }

}
