package uz.jl.java_ee.service;

import uz.jl.java_ee.configs.ThreadPoolExecutorConfig;
import uz.jl.java_ee.dao.FileStorageDao;
import uz.jl.java_ee.domains.Uploads;
import uz.jl.java_ee.dto.UploadsDTO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.Function;

public class FileStorageService extends Service<FileStorageDao> {
    public static final Path rootPath = Paths.get("/app/libgen/uploads");

    public FileStorageService(FileStorageDao dao) {
        super(dao);
        createUploadingFolders(rootPath);
    }


    public void create(InputStream is, String filename) {
        ThreadPoolExecutorConfig.execute(() -> {
            try {
                Files.copy(is, rootPath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Uploads create(UploadsDTO uploadsDTO) {
        Uploads uploads = toDomain.apply(uploadsDTO);
        dao.create(uploads);
        return uploads;
    }


    private final Function<UploadsDTO, Uploads> toDomain = Uploads::toDomain;

    private void createUploadingFolders(Path rootPath) {
        if (!Files.exists(rootPath)) {
            try {
                Files.createDirectories(rootPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
