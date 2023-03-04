import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparators {
    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();

        notebooks.add(new Notebook(54999.99, 512));
        notebooks.add(new Notebook(41999.99, 512));
        notebooks.add(new Notebook(48599.99, 256));
        notebooks.add(new Notebook(104599.99, 1024));
        notebooks.add(new Notebook(39799.99, 256));

        System.out.println(notebooks);

        for(Notebook notebook : notebooks){
            System.out.println(notebook.price);

        }
        //Сортирует по увеличению ram
        Comparator<Notebook> ramComparator = Comparator.comparingInt(Notebook::getRam);
        Collections.sort(notebooks, ramComparator);
        System.out.println("Отсортировано по увеличению RAM:");
        System.out.println(notebooks);

        System.out.println("--------------------------------");

        //Сортирует по увеличению price
        Comparator<Notebook> priceComparator = (o1, o2) -> (int)(o1.getPrice() - o2.getPrice());
        notebooks.sort(priceComparator);
        System.out.println("Отсортировано по увеличению цены:");
        System.out.println(notebooks);

        System.out.println("--------------------------------");


        notebooks.sort(Comparator.comparing(Notebook::getRam)
                .thenComparing(Notebook::getPrice));
        System.out.println("Отсортировано по увеличению памяти и цены:");
        System.out.println(notebooks);

    }

}
