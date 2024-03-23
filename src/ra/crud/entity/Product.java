package ra.crud.entity;
import java.text.SimpleDateFormat;
import java.util.Date;
import ra.crud.config.InputMethods;
import java.util.List;
import java.text.ParseException;

public class Product {
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private String id, name, description;
    private int status;
    private float price;
    private Date created;

    public Product(String id, String name, String description, float price, Date created, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
        this.created = created;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void displayData() {
        System.out.printf("| id: %-5s | name: %-20s | description: %-10s | status: %-10s | price: %-10s | created: %-10s\n", id, name, description, status == 0 ? "Đang bán" : status == 1 ? "Hết hàng" : "Không bán", price, FORMAT.format(created));
    }

    public boolean checkOnly(String id, List<Product> products) {
        for (Object p: products) {
            if (id.equals(((Product) p).getId())) {
                System.err.println("Mã sp đã tồn tại");
                return false;
            }
        }
        return true;
    }



    public void inputId(List<Product> products) {
        String regex = "^[CSA]\\w{3}$";
        while(true) {
            System.out.print("Nhập id: ");
            String checkId = InputMethods.getString();
            if (checkId.matches(regex) && checkOnly(checkId, products)) {
                this.id = checkId;
                break;
            } else {
                System.err.println("Không đúng định dạng! (CSA + 3s)");
            }
        }
    }

    public void inputName(List<Product> products) {
        while(true) {
            System.out.print("Nhập tên sp: ");
            String checkName = InputMethods.getString();
            if (checkOnly(checkName, products) && checkName.length() >= 10 && checkName.length() <= 50) {
                this.name = checkName;
                break;
            } else {
                System.err.println("Không đúng định dạng! (10<= name <= 50)");
            }
        }
    }

    public void inputPrice() {
        while(true) {
            System.out.print("Nhập giá sp: ");
            float checkPrice = InputMethods.getFloat();
            if (checkPrice > 0) {
                this.price = checkPrice;
                break;
            } else {
                System.err.println("Không đúng định dạng! (>0)");
            }
        }
    }

    public void inputDate(List<Product> products) {
        while (true){
            System.out.println("Nhập ngày tạo");
            String input = InputMethods.getString();
            try {
                this.created = FORMAT.parse(input);
                break;
            } catch (ParseException e) {
                System.err.println("Ko đúng định dạng dd/MM/yyyy");
            }
        }
    }

    public void inputData(List<Product> products, boolean isAdd) {
        if(isAdd) {
            inputId(products);
        }
        inputName(products);
        inputPrice();
        System.out.println("Nhập vào mô tả sp: ");
        this.description = InputMethods.getString();
        inputDate(products);
        this.status = 0;
    }
}
