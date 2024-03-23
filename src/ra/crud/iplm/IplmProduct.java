package ra.crud.iplm;

import ra.crud.config.InputMethods;
import ra.crud.design.DesignProducts;
import ra.crud.entity.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ra.crud.entity.Product;

public class IplmProduct implements DesignProducts {
    public static final Scanner sc = new Scanner(System.in);
    private static List<Product> lists = new ArrayList<Product>();

    static {
        lists.add(new Product("S001","Caphe hương chồn","nothing",10,new Date(),(byte)0));
        lists.add(new Product("S002","Caphe hương mèo","nothing",20,new Date(),(byte)0));
        lists.add(new Product("S003","Caphe hương chó","nothing",5,new Date(),(byte)0));
    }



    @Override
    public void add() {
        System.out.println("Nhập số lượng sp muốn thêm: ");
        byte quantity = sc.nextByte();
        if(quantity <= 0) {
            System.err.println("Nhập sai!");
        } else {
            for (int i = 0; i < quantity; i++) {
                System.out.println("Nhập thông tin sp thứ "+ (i + 1));
                Product newProduct = new Product();
                newProduct.inputData(lists, true);
                lists.add(newProduct);
            }
            System.out.println("Thêm mới hoàn tất");
        }

    }

    @Override
    public void display() {
        System.out.println("Danh sách sp:");
        if(lists.isEmpty()) {
            System.out.println("trống");
        } else {
            for(Product p : lists) {
                p.displayData();
            }
        }
    }


    @Override
    public void delete() {
        System.out.print("Nhập mã sp muốn xoá: ");
        String checkId = InputMethods.getString();
        for(Product p: lists) {
            if(p.getId().equals(checkId)) {
                lists.remove(p);
                System.out.println("Xoá thành công");
                break;
            }
        }
    }

    @Override
    public void update() {
        System.out.print("Nhập mã sp muốn cập nhật: ");
        String checkId = InputMethods.getString();
        for(Product p: lists) {
            if(p.getId().equals(checkId)) {
                p.inputData(lists, false);
                System.out.println("Cập nhật thành công");
                break;
            }
        }
    }

    @Override
    public void search() {
        System.out.print("Nhập tên sp cần tìm: ");
        String checkName = InputMethods.getString();
        for(Product p: lists) {
            if(p.getName().contains(checkName)) {
                p.displayData();
            }
        }
    }

    @Override
    public void searchRange() {
        System.out.println("Nhập vào giá bắt đầu");
        float start = InputMethods.getFloat();
        System.out.println("Nhập vào giá kết thúc");
        float end = InputMethods.getFloat();
        for(Product p: lists) {
            if(start >= p.getPrice() && end <= p.getPrice()) {
                p.displayData();
            }
        }
    }

    @Override
    public void sort() {
        System.out.println("Sắp xếp theo giá");
        int quantity = lists.size();
        for (int i = 0; i < quantity; i++) {// lặp qua các obj product của lists
            for (int j = 0; j < quantity - i - 1; j++) {
                Product p1 = lists.get(j); // lấy ra 2 giá trị liên tiếp để so sánh
                Product p2 = lists.get(j + 1);
                if(p1.getPrice() > p2.getPrice()) { // nếu p1 > p2 thì set (đổi) vị trí 2 phần tử cho nhau
                    lists.set(j, p2); // set(index, element)
                    lists.set(j + 1, p1);
                }
            }
        }
    }
}
