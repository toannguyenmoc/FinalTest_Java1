
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
public class ThucUong {

    Scanner sc = new Scanner(System.in);

    private String tenThucUong;
    private int giaTien;
    private String loai;

    private String mauLoai = "[LMSlms]{1}";

    public String getTenThucUong() {
        return tenThucUong;
    }

    public void setTenThucUong(String tenThucUong) {
        this.tenThucUong = tenThucUong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public ThucUong() {
    }

    public ThucUong(String tenThucUong) {
        this.tenThucUong = tenThucUong;
    }

    public ThucUong(String tenThucUong, int giaTien) {
        this.tenThucUong = tenThucUong;
        this.giaTien = giaTien;
    }

    public ThucUong(String tenThucUong, int giaTien, String loai) {
        this.tenThucUong = tenThucUong;
        this.giaTien = giaTien;
        this.loai = loai;
    }

    public void nhap() {

        System.out.print("Nhập vào tên Thức Uống: ");
        tenThucUong = sc.nextLine();

        while (true) {
            try {
                System.out.print("Nhập Giá Tiền: ");
                giaTien = sc.nextInt();
                if (giaTien < 0) {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số !!!");
                sc.nextLine();
                continue;
            }
            break;
        }
        sc.nextLine();
        while (true) {
            System.out.print("Nhập loại: ");
            loai = sc.nextLine();
            if (loai.matches(mauLoai)) {
                break;
            } else {
                System.out.println("Loại Thức Uống phải chọn (L,M,S)");
                continue;
            }
        }
    }

    public int loaisize() {
        if (loai.equalsIgnoreCase("L")) {
            return 10000;
        } else if (loai.equalsIgnoreCase("M")) {
            return 5000;
        } else {
            return 0;
        }
    }

    public void thanhTien() {
        System.out.println("Thành Tiền: " + (giaTien + loaisize()));
    }

    public void kiemTra() {
        boolean kq = tenThucUong.contains("sinh to");        
        if(kq == true){
            System.out.println("Thức uống có chữ Sinh Tố");
        }else
            System.out.println("Thức uống không có chữ Sinh Tố");
    }

    public void chuyenChuHoa() {
        System.out.println("Chuyển chữ hoa: " + tenThucUong.toUpperCase());
    }

    public void catKhoangTrang() {
        int khoangTrangDau = tenThucUong.indexOf(" ");
        int khoangTrangCuoi = tenThucUong.lastIndexOf(" ");
        System.out.println("khoảng trắng đầu: " + khoangTrangDau);
        System.out.println("khoảng trắng cuối: " + khoangTrangCuoi);
    }

    public void xuat() {
        System.out.println("Tên thức uống: " + tenThucUong);
        System.out.println("Giá tiền: " + giaTien);
        System.out.println("Loại: " + loai);
        System.out.println("Tiền Loại size: " + loaisize());
        thanhTien();
        kiemTra();
        catKhoangTrang();
        chuyenChuHoa();
    }

    public static void main(String[] args) {
        ThucUong tu = new ThucUong();
        tu.nhap();
        tu.xuat();
    }
}
