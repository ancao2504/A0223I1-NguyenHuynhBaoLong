package ss12_Map_Tree.exercise.repository;

import ss12_Map_Tree.exercise.model.Product;

import java.util.List;

public interface IRepository {
    void add(Product product);


    List displayList();

    Product editById(int idcheck);

    Product deleteByid(int inputIdCheck);

    Product findByName(String nameOfProduct);
}
