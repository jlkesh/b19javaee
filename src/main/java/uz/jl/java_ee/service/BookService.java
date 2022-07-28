package uz.jl.java_ee.service;

import uz.jl.java_ee.container.ApplicationContext;
import uz.jl.java_ee.dao.BookDao;
import uz.jl.java_ee.domains.Book;
import uz.jl.java_ee.domains.Uploads;
import uz.jl.java_ee.dto.BookCreateDTO;
import uz.jl.java_ee.dto.UploadsDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

public class BookService extends Service<BookDao> {

    private final static FileStorageService fileStorageService = ApplicationContext.getBean(FileStorageService.class);

    public BookService(BookDao dao) {
        super(dao);
    }


    public void create(HttpServletRequest req) throws IOException, ServletException {
        Part file = req.getPart("file");
        BookCreateDTO bookDTO = toDTO.apply(req);
        UploadsDTO uploadsDTO = toUploadsDTO.apply(file);
        Book book = toBookDomain.apply(bookDTO);
        String generatedName = uploadsDTO.getGeneratedName();
        InputStream is = file.getInputStream();

        Uploads uploadedFile = fileStorageService.create(uploadsDTO);

        book.setFile(uploadedFile);
        dao.create(book);
        fileStorageService.create(is, generatedName);
    }

    private static final Function<HttpServletRequest, BookCreateDTO> toDTO = BookCreateDTO::toDTO;
    private static final Function<BookCreateDTO, Book> toBookDomain = Book::toDomain;
    private static final Function<Part, UploadsDTO> toUploadsDTO = UploadsDTO::toDTO;


}
