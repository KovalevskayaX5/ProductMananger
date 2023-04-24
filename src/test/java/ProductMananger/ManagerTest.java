package ProductMananger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Book book1 = new Book(1, "Война и Мир", 455, "Толстой");
    Book book2 = new Book(2, "Гордость и Предубеждение", 4545, "Остин");
    Book book3 = new Book(3, "Гарри Поттер", 9865, "Роулинг");
    Smartphone smartphone1 = new Smartphone(4, "IPhone 13", 120_000, "Apple");
    Smartphone smartphone2 = new Smartphone(5, "IPhone 8", 30_000, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void findOneProduct(){
        Product[] actual = manager.searchBy("IPhone 13");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByNumber(){
        Product[] actual = manager.searchBy("8");
        Product[] expected = {smartphone2};
        Assertions.assertArrayEquals( expected, actual);



    }

    @Test
    public void findByOneSymbol(){
        Product[] actual = manager.searchBy("о");
        Product[] expected = {book1,book2,book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByFewSymbols(){
        Product[] actual = manager.searchBy( "бежд");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFewSymbols(){
        Product[] actual = manager.searchBy( "one");
        Product[] expected = {smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findZeroSymbols(){
        Product[] actual = manager.searchBy( "28");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


}
