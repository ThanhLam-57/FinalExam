package Service;

import DAO.ScoreManagementDAO;
import Modal.Score;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ScoreService {
    public ScoreManagementDAO scoreManagementDAO;
    public static Scanner sc = new Scanner(System.in);
    public ScoreService() {
        scoreManagementDAO = new ScoreManagementDAO();
    }

    //Todo 1: Viết hàm insertScore
    public void insert(){
        System.out.println("Nhap ten sinh vien: ");
        String stdName = sc.nextLine();
        System.out.println("Nhap tuoi sinh vien: ");
        Integer stdAge = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap lop sinh vien: ");
        String stdClass = sc.nextLine();
        System.out.println("Nhap diem trung binh sinh vien: ");
        Double stdGPA = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap gioi tinh sinh vien: ");
        String stdGender = sc.nextLine();
        Score s = new Score(stdName,stdAge,stdClass,stdGPA,stdGender);
        scoreManagementDAO.insertScore(s);
    }

    //Todo 2: Viết hàm showByIDScore
    public void showById(){
        System.out.println("Nhap ma sinh vien: ");
        Integer stdId = Integer.parseInt(sc.nextLine());
        Score s = scoreManagementDAO.showById(stdId);
        if (s == null){
            System.out.println("Khong tim thay sinh vien.");
        }else {
            System.out.println(s.toString());
        }
    }
    //Todo 2: Viết hàm updateScore
    public void update(){
        System.out.println("Nhap ma sinh vien: ");
        Integer stdId = Integer.parseInt(sc.nextLine());
        Score s = scoreManagementDAO.showById(stdId);
        System.out.println(s.toString());
        System.out.println("Nhap lua chon: ");
        boolean cond = true;
        do {
            System.out.println("1. Ten sinh vien.");
            System.out.println("2. Tuoi sinh vien.");
            System.out.println("3. Lop sinh vien.");
            System.out.println("4. Diem trung binh sinh vien.");
            System.out.println("5. Gioi tinh sinh vien.");
            System.out.println("6. Exit.");
            int choice;
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Ten sinh vien: ");
                    String stdName = sc.nextLine();
                    s.setStdName(stdName);
                    break;
                case 2:
                    System.out.println("Tuoi sinh vien: ");
                    Integer stdAge = Integer.parseInt(sc.nextLine());
                    s.setStdAge(stdAge);
                    break;
                case 3:
                    System.out.println("Lop sinh vien: ");
                    String stdClass = sc.nextLine();
                    s.setStdClass(stdClass);
                    break;
                case 4:
                    System.out.println("Diem trung binh sinh vien: ");
                    Double stdGPA = Double.parseDouble(sc.nextLine());
                    s.setStdGPA(stdGPA);
                    break;
                case 5:
                    System.out.println("Gioi tinh sinh vien: ");
                    String stdGender = sc.nextLine();
                    s.setStdGender(stdGender);
                    break;
                case 6:
                    cond = false;
                    break;
                default:
                    System.out.println("Nhap sai, vui long nhap lai!");
                    break;
            }
        }while (cond == true);
        Score sc = scoreManagementDAO.updateScore(stdId,s);
        System.out.println(sc.toString());
        System.out.println("Cap nhat thanh cong!");
    }

    //Todo 3: Viết hàm deleteScore
    public void delete(){
        System.out.println("Nhap ma sinh vien: ");
        Integer stdId = Integer.parseInt(sc.nextLine());
        scoreManagementDAO.deleteScore(stdId);
    }

    //Todo 4: Viết hàm showAllScore
    public void showAll(){
        scoreManagementDAO.getAllScore();
        for (int i = 0; i < scoreManagementDAO.getAllScore().size(); i++) {
            System.out.println(scoreManagementDAO.getAllScore().get(i).toString());
        }
    }
    //Todo 5: Viết hàm showScoreByName
    public void showByName(){
        int count = 0;
        System.out.println("Nhap ten sinh vien: ");
        String stdName = sc.nextLine();
        scoreManagementDAO.getScoreByName(stdName);
        for (int i = 0; i < scoreManagementDAO.getScoreByName(stdName).size(); i++) {
            System.out.println(scoreManagementDAO.getScoreByName(stdName).get(i).toString());
            count++;
        }
        if (count == 0){
            System.out.println("Khong tim thay sinh vien!");
        }
    }

    //Todo 6: Viết hàm sortScoreByGPA
    public void sortScoreByGPA(){
        List<Score> list = scoreManagementDAO.getAllScore();
        Collections.sort(list, (o1, o2) -> {
            if (o1.getStdGPA() > o2.getStdGPA()) {
                return 1;
            } else if (o1.getStdGPA() == o2.getStdGPA()) {
                return 0;
            } else {
                return -1;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    //Todo7: Viết hàm getScoreByCPAhigherthan8
    public void getScoreByCPAHigherThan8(){
        List<Score> list = scoreManagementDAO.getAllScore();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStdGPA() > 8) {
                System.out.println(list.get(i).toString());
                count ++;
            }
        }
        if (count == 0) {
            System.out.println("Khong co sinh vien nao co diem trung binh cao hon 8!");
        }
    }
    //Todo8: Viết hàm getScoreByCPAhigherthan8andClasscl3
    public void getScoreByCPAHigherThan8AndClassD01(){
        List<Score> list = scoreManagementDAO.getAllScore();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStdGPA() > 8 && list.get(i).getStdClass().equals("D01")) {
                System.out.println(list.get(i).toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong co sinh vien nao co diem trung binh cao hon 8 va hoc lop D01!");
        }
    }
    //Todo9: Viet ham sortScoreByName
    public void sortScoreByName(){
        List<Score> list = scoreManagementDAO.getAllScore();
        Collections.sort(list, (o1, o2) -> {
            if (o1.getStdName().compareTo(o2.getStdName()) > 0) {
                return 1;
            } else if (o1.getStdName().compareTo(o2.getStdName()) == 0) {
                return 0;
            } else {
                return -1;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
