package blogapp.com.services.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import blogapp.com.services.FileService;
@Service
public class FileServiceImp implements FileService {

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }

    @Override
public String uploadImage(String path, MultipartFile file) throws IOException {

    // Original file name
    String originalName = file.getOriginalFilename();

    // Random file name
    String randomId = java.util.UUID.randomUUID().toString();
    String fileName = randomId + originalName.substring(originalName.lastIndexOf("."));

    // Full path
    String filePath = path + File.separator + fileName;

    // Create directory if not exists
    File dir = new File(path);
    if (!dir.exists()) {
        dir.mkdirs();
    }

    // Save file (ONLY ONCE)
    Files.copy(file.getInputStream(), Paths.get(filePath));

    return fileName;
}
     

}
