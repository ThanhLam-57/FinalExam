import Service.ScoreService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Viết menu
        //1. Thêm nhân viên
        ScoreService scoreService = new ScoreService();
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println("1. Them sinh vien.");
            System.out.println("2. Hien thi sinh vien theo ma.");
            System.out.println("3. Cap nhat sinh vien theo ma.");
            System.out.println("4. Xoa sinh vien theo ma.");
            System.out.println("5. Hien thi tat ca sinh vien.");
            System.out.println("6. Hien thi sinh vien theo ten.");
            System.out.println("7. Sap xep sinh vien theo GPA.");
            System.out.println("8. Hien thi sinh vien co GPA > 8 va lop D01.");
            System.out.println("9. Hien thi sinh vien co CPA >8");
            System.out.println("10. Hien thi danh sach sinh vien xap xep theo ten");
            System.out.println("11. Thoat.");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    scoreService.insert();
                    break;
                case 2:
                    scoreService.showById();
                    break;
                case 3:
                    scoreService.update();
                    break;
                case 4:
                    scoreService.delete();
                    break;
                case 5:
                    scoreService.showAll();
                    break;
                case 6:
                    scoreService.showByName();
                    break;
                case 7:
                    scoreService.sortScoreByGPA();
                    break;
                case 8:
                    scoreService.getScoreByCPAHigherThan8AndClassD01();
                    break;
                case 9:
                    scoreService.getScoreByCPAHigherThan8();
                    break;
                    case 10:
                    scoreService.sortScoreByName();
                    break;
                case 11:
                    check = false;
                    break;
                default:
                    System.out.println("Nhap sai lua chon.");
                    break;
            }
        }while (check == true);
    }
}