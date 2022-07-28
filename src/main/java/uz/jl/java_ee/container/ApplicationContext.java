package uz.jl.java_ee.container;

import uz.jl.java_ee.dao.BookDao;
import uz.jl.java_ee.dao.FileStorageDao;
import uz.jl.java_ee.service.BookService;
import uz.jl.java_ee.service.FileStorageService;

public class ApplicationContext {
    private static BookDao bookDao = new BookDao();
    private static BookService bookService = new BookService(bookDao);
    private static FileStorageDao fileStorageDao = new FileStorageDao();
    private static FileStorageService fileStorageService = new FileStorageService(fileStorageDao);

    @SuppressWarnings("raw_types")
    public static <T> T getBean(Class<T> clazz) {
        return switch (clazz.getSimpleName()) {
            case "BookDao" -> (T) bookDao;
            case "BookService" -> (T) bookService;
            case "FileStorageService" -> (T) fileStorageService;
            case "FileStorageDao" -> (T) fileStorageDao;
            default -> throw new RuntimeException("Bean not found");
        };
    }
}
