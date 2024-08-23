
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ToanNM_PC09504
 */
public class DienThoai {

    private String tenDienThoai;
    private float giaTien;

    private String mauDT = "[a-zA-Z0-9 ]{10,50}";

    public DienThoai() {
    }

    public DienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public DienThoai(String tenDienThoai, float giaTien) {
        this.tenDienThoai = tenDienThoai;
        this.giaTien = giaTien;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    Scanner sc = new Scanner(System.in);
    ArrayList<DienThoai> list = new ArrayList<>();
    DienThoai dt;

    public void nhap() {
        while (true) {
            while (true) {
                System.out.print("Nhập tên Điện Thoại: ");
                tenDienThoai = sc.nextLine();
                if (tenDienThoai.matches(mauDT)) {
                    break;
                } else {
                    continue;
                }
            }
            while (true) {
                try {
                    System.out.print("Nhập Giá Tiền: ");
                    giaTien = sc.nextInt();
                    if (giaTien < 0) {
                        System.out.println("Vui long khong nhap so am");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập số !!!");
                    sc.nextLine();
                    continue;
                }
                break;
            }
            dt = new DienThoai(tenDienThoai, giaTien);
            list.add(dt);
            System.out.print("Bạn muốn nhập tiếp không (Y/N): ");
            sc.nextLine();
            if (sc.nextLine().equalsIgnoreCase("y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public void xuat() {
        for (DienThoai x : list) {
            System.out.println("Tên Điện Thoại: " + x.tenDienThoai + ", Giá Tiền: " + x.giaTien);
        }
    }

    public void khoangGia() {
        while (true) {
            double min, max;
            while (true) {
                try {
                    System.out.print("Nhập giá từ khoảng: ");
                    min = sc.nextDouble();
                    System.out.print("Đến: ");
                    max = sc.nextDouble();
                    if (min < 0 || max < 0) {
                        System.out.println("Gia phải lớn hơn 0");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập số !!!");
                    sc.nextLine();
                    continue;
                }
                break;
            }
            boolean check = false;
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i).giaTien >= min && list.get(i).giaTien <= max) || (list.get(i).giaTien <= min && list.get(i).giaTien >= max)) {
                    check = true;
                }
            }
            if (check == false) {
                System.out.println("Không tìm thấy");
            } else {
                System.out.println("Danh Sách trong khoảng giá bạn cần tìm:");
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).giaTien >= min && list.get(i).giaTien <= max) || (list.get(i).giaTien <= min && list.get(i).giaTien >= max)) {
                        System.out.println("Tên Điện Thoại: " + list.get(i).tenDienThoai);
                        System.out.println("Giá Tiền: " + list.get(i).giaTien);
                    }
                }
            }
            System.out.print("Bạn muốn tìm tiếp không(Y/N): ");
            sc.nextLine();
            String tiep = sc.nextLine();
            if (tiep.equalsIgnoreCase("y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public void xoaDienThoai() {
        while (true) {
            String xoa;
            while (true) {
                System.out.print("Nhập tên Điện Thoại cần xoá: ");
                xoa = sc.nextLine();
                if (xoa.matches(mauDT)) {
                    break;
                } else {
                    continue;
                }
            }
            boolean check = false;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (xoa.equalsIgnoreCase(list.get(i).tenDienThoai)) {
                    check = true;
                    index = i;
                }
            }

            if (check == true) {
                System.out.println("Tìm thấy!!!!");
                System.out.print("Bạn muốn xoá không(Y/N): ");
                if (sc.nextLine().equalsIgnoreCase("y")) {
                    list.remove(index);
                    System.out.println("Đã xoá !: " + xoa);
                }
                System.out.println("Danh Sách Điện Thoại Mới:");
                xuat();
            } else {
                System.out.println("Không tìm thấy");
            }

            System.out.print("Bạn muốn xoá tiếp không(Y/N): ");
            String tiep = sc.nextLine();
            if (tiep.equalsIgnoreCase("y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public void menu() {
        System.out.println("\t++------------------------------------------------------++");
        System.out.println("\t|\t\tQUẢN LÝ Điện Thoại                       |");
        System.out.println("\t|\t0. Thoát.                                        |");
        System.out.println("\t|\t1. Nhập danh sách Điện Thoại                     |");
        System.out.println("\t|\t2. Xuất danh sách Điện Thoại                     |");
        System.out.println("\t|\t3. Tìm và hiện thị Điện Thoại theo khoảng giá    |");
        System.out.println("\t|\t4. Xoá Điện Thoại theo tên                       |");
        System.out.println("\t++------------------------------------------------------++");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DienThoai p = new DienThoai();
        while (true) {
            try {
                p.menu();
                int n;
                System.out.print("Chọn chức năng: ");
                n = sc.nextInt();

                switch (n) {
                    case 1:
                        System.out.println("1. Nhập danh sách Điện Thoại");
                        p.nhap();
                        break;
                    case 2:
                        System.out.println("2. Xuất danh sách Điện Thoại ");
                        p.xuat();
                        break;
                    case 3:
                        System.out.println("3. Tìm và hiện thị Điện Thoại theo khoảng giá.");
                        p.khoangGia();
                        break;
                    case 4:
                        System.out.println("4. Xoá Điện Thoại theo tên ");
                        p.xoaDienThoai();
                        break;
                    case 0:
                        System.out.println("====== Hẹn gặp lại. ======");
                        System.exit(0);
                    default:
                        System.out.println("Bạn chọn không đúng chức năng.");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số chức năng, không Nhập ký tự !!!");
                sc.nextLine();
            }
        }
    }
}
