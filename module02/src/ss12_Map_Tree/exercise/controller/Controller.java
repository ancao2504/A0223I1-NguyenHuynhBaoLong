package ss12_Map_Tree.exercise.controller;

import ss12_Map_Tree.exercise.service.IProductManager;
import ss12_Map_Tree.exercise.service.impl.ProductManager;

import java.util.Scanner;

public class Controller {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        IProductManager productManager = new ProductManager();
        Boolean check = true;

        while (check) {
            System.out.println("1.Thêm sản phẩm");
            System.out.println("2.Sửa thông tin theo id");
            System.out.println("3.Xóa sản phẩm theo id");
            System.out.println("4.Hiển thị danh sách sản phẩm");
            System.out.println("5.Tìm kiếm sản phẩm theo tên");
            System.out.println("6.Sắp xếp sản phẩm ");
            System.out.println("7.kết thúc");

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.edit();
                    break;
                case 3:
                    productManager.delete();
                    break;
                case 4:
                    productManager.displayList();
                    break;
                case 5:
                    productManager.findProduct();
                    break;
                case 6:
                    productManager.sortProduct();
                    break;
                case 7:
                    check = false;
                    break;
            }
        }
    }
}
