package ss12_Map_Tree.exercise.service.impl;

import ss12_Map_Tree.exercise.model.Product;
import ss12_Map_Tree.exercise.repository.IRepository;
import ss12_Map_Tree.exercise.repository.impl.Repository;
import ss12_Map_Tree.exercise.service.IProductManager;

import java.util.*;

public class ProductManager implements IProductManager {
    private Scanner scanner = new Scanner(System.in);
    private IRepository iRepository = new Repository();
    private Map<Integer, Product> map = new HashMap<>();
    private List<Product> list = new ArrayList();

    @Override
    public void add() {
        Product product = addProduct();
        iRepository.add(product);

    }

    @Override
    public Product edit() {
        System.out.print("Nhập id sản phẩm bạn muốn sửa");
        int inputIdCheck= Integer.parseInt(scanner.nextLine());
        Product product =iRepository.editById(inputIdCheck);
        return product;
    }

    @Override
    public void displayList() {
        List listProduct = iRepository.displayList();
        if(listProduct.isEmpty()) {
            System.out.println("----------danh sách rỗng------------");
        }else {
            for (Object p : listProduct) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void delete() {
        System.out.print("Nhập id của sản phẩm bạn muốn xóa: ");
        int inputIdCheck = Integer.parseInt(scanner.nextLine());
        Product product = iRepository.deleteByid(inputIdCheck);
    }

    @Override
    public void findProduct() {
        System.out.print("Nhập tên sản phẩm bạn muốn kiếm: ");
        String nameOfProduct = scanner.nextLine();
        Product product = iRepository.findByName(nameOfProduct);
        if (product != null) {
            System.out.println(product.toString());
        } else {
            System.out.println("--------Không tìm thấy tên sản phẩm -------");
        }
    }

    @Override
    public void sortProduct() {
        List<Product> list = iRepository.displayList();
        Collections.sort(list);
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    public Product addProduct() {
        Product product = new Product();
        if(list.isEmpty()) {
            product.setId(0);
        } else {
            product.setId(list.get(list.size() - 1).getId() + 1);
        }
        System.out.print("1.Nhập tên sản phẩm");
        product.setName(scanner.nextLine());
        System.out.print("2.Nhập giá sản phẩm");
        product.setCost(Double.parseDouble(scanner.nextLine()));
        System.out.println("------Thêm mới thành công------------" + "\n");
        return product;
    }
}
