package java1;


import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static HashMap<String, Book> books = new HashMap<>();

    private static void initBook(){
        Book wither = new Book("Ведьмак", "А.Сабковский", "Фэнтези", "1986");
        Book prestup = new Book("Преступление и наказание", "Ф.Достоевский", "Роман", "1866");
        Book master = new Book("Мастер и маргарита", "М.Булгаков", "Роман", "1966");
        books.put("Ведьмак", wither);
        books.put("Преступление и наказание", prestup);
        books.put("Мастер и маргарита", master);
    }

    private static Integer isAut = 0;

    public static void main(String[] args) {
        initBook();
        boolean flag = false;
        while (!flag) {
                Scanner in = new Scanner(new InputStreamReader(System.in));
                System.out.println("Что вы хотите сделать:");
                System.out.println("1.Найти книгу");
                System.out.println("2.Авторизация");
                Integer variant = Integer.valueOf(in.nextLine());
                if (variant.equals(1)) {
                    try {
                        seachBook();
                    }catch (NullPointerException e){
                        System.out.println("Книга не найдена");
                    }
                } else {
                    if(isAut == 0){
                        if (autorezation()) {
                            System.out.println("Вы успешно авторизировались!");
                            isAut = 1;
                            while (!flag) {
                                System.out.println("Что вы хотите сделать:");
                                System.out.println("1.Найти книгу");
                                System.out.println("2.Добавить книгу");
                                Integer variant2 = Integer.valueOf(in.next());
                                if (variant2.equals(1)) {
                                    try {
                                        seachBook();
                                    }catch (NullPointerException e){
                                        System.out.println("Книга не найдена");
                                    }
                                } else {
                                    saveBook();
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Что вы хотите сделать:");
                        System.out.println("2.Добавить книгу");
                        System.out.println("1.Найти книгу");
                        Integer variant2 = Integer.valueOf(in.next());
                        if (variant2.equals(1)){
                           try {
                               seachBook();
                           }catch (NullPointerException e){
                               System.out.println("Книга не найдена");
                           }
                        }
                        else {
                            saveBook();
                        }
                }
            }
        }
    }

    private static void seachBook() {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        System.out.println("Найти книгу:");
        String name1 = in.nextLine();
        Book book1 = books.get(name1);
        System.out.println("Название книги: " + book1.getName() + " || " + "Автор книги: " + book1.getAuthor() + " || " + "Жанр книги: " + book1.getGenre() + " || " + "Год выпуска: " + book1.getEarsRealest());
    }

    private static void saveBook(){
        Scanner in = new Scanner(new InputStreamReader(System.in));
        System.out.println("Введите название книги:");
        String name = in.next();
        System.out.println("Введите автора книги:");
        String author = in.next();
        System.out.println("Введите жанр книги:");
        String genre = in.next();
        System.out.println("Введите год выпуска:");
        String earOfIssue = in.next();
        Book book = new Book(name, author, genre, earOfIssue);
        books.put(book.getName(), book);
    }

    private static boolean autorezation(){
        Scanner in = new Scanner(new InputStreamReader(System.in));
        System.out.println("Авторизация!");
        System.out.println("Введите логин:");
        String login = in.next();
        System.out.println("Введите пароль:");
        String password = in.next();
        return login.equals("Maxim") & password.equals("1234");
    }
}

