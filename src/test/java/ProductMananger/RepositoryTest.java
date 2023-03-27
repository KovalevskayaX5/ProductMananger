package ProductMananger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Book book1 = new Book(1, "Война и Мир",455, "Толстой" );
    Book book2 = new Book(2, "Гордость и Предубеждение",4545, "Остин" );
    Book book3 = new Book(3, "Гарри Поттер",9865, "Роулинг" );
    Smartphone smartphone1 = new Smartphone(4,"IPhone 13", 120_000,"Apple");
    Smartphone smartphone2 = new Smartphone(5,"IPhone 8", 30_000,"Apple");

    @Test
    public void shouldSaveAllProducts(){
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);

        Product[] expected = {book1,book2,book3,smartphone1,smartphone2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void save0product(){
        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void saveOneProduct() {
        repository.add(smartphone2);

        Product[] expected = {smartphone2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }

    // Удаление
    @Test
    public void deleteOneProduct(){
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);

        repository.deleteBuId(book2.id);

        Product[] expected = {book1,book3,smartphone1,smartphone2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void deleteAllProducts(){
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.deleteBuId(book1.id);
        repository.deleteBuId(book2.id);
        repository.deleteBuId(book3.id);
        repository.deleteBuId(smartphone1.id);
        repository.deleteBuId(smartphone2.id);

        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);

    }
    @Test
    public void deleteAllBooks(){
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.deleteBuId(book1.id);
        repository.deleteBuId(book2.id);
        repository.deleteBuId(book3.id);

        Product[] expected = {smartphone1,smartphone2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected,actual);

    }
}
