import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    List<T> fruitBox = new ArrayList<T>();

    public void add(T fruit) {
        fruitBox.add(fruit);
    }

    public double getWeight() {
        double weight = 0;
        for (T fruit : fruitBox){
            weight +=fruit.getWeight();
        }
        return weight;
    }

    public void moveTo(Box<? super T> anotherBox) {
        for (T fruit : fruitBox) {
            anotherBox.add(fruit);
        }
        fruitBox = new ArrayList<T>();

    }

}
