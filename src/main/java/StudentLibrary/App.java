package StudentLibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Student[] students  = new Student[Constants.NUMBER_OF_STUDENTS];
        Book[] books = new Book[Constants.NUMBER_OF_BOOKS];
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);

        try{
            for (int i = 0; i < Constants.NUMBER_OF_BOOKS; i++) {
                books[i] = new Book(i);
            }

            for (int i = 0; i < Constants.NUMBER_OF_STUDENTS; i++) {
                students[i] = new Student(i, books);
                executorService.execute(students[i]);
            }

        } catch (Exception e){
            e.printStackTrace();
            executorService.shutdown();
        }finally {
            executorService.shutdown();
        }

    }
}
