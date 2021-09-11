package me.sungbin.photoapp.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final FileWriter fileWriter;

    public ImageFile upload(MultipartFile sourceFile) {
        String fileId = UUID.randomUUID().toString();
        String filePath = fileWriter.getFilePath(fileId, sourceFile);
        LOG.info("filePath:: {}", filePath );
        fileWriter.writeFile(sourceFile, filePath);

        return ImageFile.builder()
                .fileName(sourceFile.getName())
                .filePath(filePath)
                .fileId(fileId)
                .fileSize(sourceFile.getSize())
                .build();
    }
}
