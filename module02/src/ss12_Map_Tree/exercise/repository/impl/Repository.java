package ss12_Map_Tree.exercise.repository.impl;


import com.sun.org.apache.bcel.internal.generic.ATHROW;
import ss12_Map_Tree.exercise.model.Product;
import ss12_Map_Tree.exercise.repository.IRepository;

import java.util.*;

public class Repository implements IRepository {
    private Scanner scanner = new Scanner(System.in);
    private static List<Product> list = new ArrayList();
    private static Product product = new Product();
    private static Map<Integer, Product> map = new HashMap<>();



    @Override
    public void add(Product product) {
        if (list.isEmpty()) {
            product.setId(0);
        } else {
            product.setId(list.get(list.size() - 1).getId() + 1);
        }
        list.add(product);
        map.put(product.getId(), product);
    }

    @Override
    public List displayList() {
        return list;
    }

    public Product editById(int idCheck) {
        for (Product product : list) {
            if (idCheck == product.getId()) {
                System.out.println(product.toString());
                System.out.print("Nhập lại tên sản phẩm: ");
                product.setName(scanner.nextLine());
                System.out.print("Nhập lại giá: ");
                product.setCost(Double.parseDouble(scanner.nextLine()));
                System.out.println("-------------sửa đổi thành công!!------------");
                return product;
            }
        }
        System.out.println("-----------ID không tồn tại -----------");
        return null;
    }

    @Override
    public Product deleteByid(int inputIdCheck) {
        for (Product product : list) {
            if (inputIdCheck == product.getId()) {
                list.remove(product);
                System.out.println("----------xóa thành công!!----------");
                return product;
            }
        }
        System.out.println("-----------ID không tồn tại -----------");
        return null;
    }

    @Override
    public Product findByName(String nameOfProduct) {
        for (Product product : list) {
            if (nameOfProduct.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

}
