package b7_abstract_class_interface.thuc_hanh.animal_edible.animal;

import b7_abstract_class_interface.thuc_hanh.animal_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String howToEat() {
        return "Chicken: Go to KFC!";
    }

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
}
