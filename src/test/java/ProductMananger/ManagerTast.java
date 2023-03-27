package ProductMananger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class ManagerTast {
    @Test
    public void findfewProducts(){
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Война и Мир",455, "Толстой" );
        Book book2 = new Book(2, "Гордость и Предубеждение",4545, "Остин" );
        Book book3 = new Book(3, "Гарри Поттер",9865, "Роулинг" );
        Smartphone smartphone1 = new Smartphone(4,"IPhone 13", 120_000,"Apple");
        Smartphone smartphone2 = new Smartphone(5,"IPhone 8", 30_000,"Apple");

        manager.add (book1);
        manager.add (book2);
        manager.add (book3);
        manager.add (smartphone1);
        manager.add (smartphone2);



        Product[] actual = manager.searchBy("IPhone 13");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFirstProducts(){
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Война и Мир",455, "Толстой" );
        Book book2 = new Book(2, "Гордость и Предубеждение",4545, "Остин" );
        Book book3 = new Book(3, "Гарри Поттер",9865, "Роулинг" );
        Smartphone smartphone1 = new Smartphone(4,"IPhone 13", 120_000,"Apple");
        Smartphone smartphone2 = new Smartphone(5,"IPhone 8", 30_000,"Apple");

        repository.add (book1);
        repository.add (book2);
        repository.add (book3);
        repository.add (smartphone1);
        repository.add (smartphone2);
        ;



        Product[] actual = manager.searchBy("Роулинг");
        Product[] expected = {book3};
        Assertions.assertArrayEquals(expected, actual);
    }

}