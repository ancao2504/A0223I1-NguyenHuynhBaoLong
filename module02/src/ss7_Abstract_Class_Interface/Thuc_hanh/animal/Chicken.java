package ss7_Abstract_Class_Interface.Thuc_hanh.animal;

public class Chicken extends Animal implements IEdible {

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried!";
    }
}
