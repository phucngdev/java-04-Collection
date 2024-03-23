package ra.crud.run;
import java.util.Scanner;
import ra.crud.iplm.IplmProduct;
import java.util.Date;

public class Collection {
    private static IplmProduct products = new IplmProduct();

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("Chọn chức năng: ");
            byte value = new Scanner(System.in).nextByte();
            switch (value) {
                case 1:
                    products.add();
                    break;
                case 2:
                    products.display();
                    break;
                case 3:
                    products.sort();
                    break;
                case 4:
                    products.update();
                    break;
                case 5:
                    products.delete();
                    break;
                case 6:
                    products.search();
                    break;
                case 7:
                    products.searchRange();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Chọn chức năng sai!");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("*******************PRODUCT MANAGEMENT*****************\n" +
                "1.\tNhập thông tin các sản phẩm\n" +
                "2.\tHiển thị thông tin các sản phẩm\n" +
                "3.\tSắp xếp các sản phẩm theo giá\n" +
                "4.\tCập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                "5.\tXóa sản phẩm theo mã sản phẩm\n" +
                "6.\tTìm kiếm các sản phẩm theo tên sản phẩm\n" +
                "7.\tTìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)\n" +
                "8.\tThoát\n");
    }
}
