package uz.jl.java_ee.container;

import uz.jl.java_ee.dao.BookDao;
import uz.jl.java_ee.dao.FileStorageDao;
import uz.jl.java_ee.service.BookService;
import uz.jl.java_ee.service.FileStorageService;

public class ApplicationContext {
    private static BookDao bookDao() {
        return new BookDao();
    }

    private static BookService bookService() {
        return new BookService(bookDao());
    }

    private static FileStorageDao fileStorageDao() {
        return new FileStorageDao();
    }

    private static FileStorageService fileStorageService() {
        return new FileStorageService(fileStorageDao());
    }

    @SuppressWarnings("raw_types")
    public static <T> T getBean(Class<T> clazz) {
        return switch (clazz.getSimpleName()) {
            case "BookDao" -> (T) bookDao();
            case "BookService" -> (T) bookService();
            case "FileStorageService" -> (T) fileStorageService();
            case "FileStorageDao" -> (T) fileStorageDao();
            default -> throw new RuntimeException("Bean not found");
        };
    }
}
