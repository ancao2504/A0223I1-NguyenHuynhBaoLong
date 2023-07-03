package ss7_Abstract_Class_Interface.Thuc_hanh.animal;

import ss7_Abstract_Class_Interface.Thuc_hanh.animal.Animal;
import ss7_Abstract_Class_Interface.Thuc_hanh.animal.Chicken;
import ss7_Abstract_Class_Interface.Thuc_hanh.animal.IEdible;
import ss7_Abstract_Class_Interface.Thuc_hanh.animal.Tiger;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                IEdible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
