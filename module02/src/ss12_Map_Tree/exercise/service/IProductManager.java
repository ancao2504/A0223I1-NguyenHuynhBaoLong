package ss12_Map_Tree.exercise.service;

import ss12_Map_Tree.exercise.model.Product;

public interface IProductManager {

    void add();

    Product edit();

    void displayList();

    void delete();

    void findProduct();

    void sortProduct();
}
