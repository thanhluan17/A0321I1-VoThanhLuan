package b7_abstract_class_interface.thuc_hanh.animal_edible;

import b7_abstract_class_interface.thuc_hanh.animal_edible.animal.Animal;
import b7_abstract_class_interface.thuc_hanh.animal_edible.animal.Chicken;
import b7_abstract_class_interface.thuc_hanh.animal_edible.animal.Tiger;
import b7_abstract_class_interface.thuc_hanh.animal_edible.edible.Edible;
import b7_abstract_class_interface.thuc_hanh.animal_edible.fruit.Apple;
import b7_abstract_class_interface.thuc_hanh.animal_edible.fruit.Fruit;
import b7_abstract_class_interface.thuc_hanh.animal_edible.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        Fruit[] fruits = new Fruit[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
