package me.sungbin.photoapp.storage.gcp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GCPStorageServiceTest {

    @Autowired
    private GCPStorageComponent gcpUploadService;

    private String projectId = "biniprojects";
    private String bucketName =  "photoapp-sample1";
    private String filePath = "src/main/resources/test.jpg";

    @Test
    public void gcpUpload() {
        gcpUploadService.uploadGcpStorage(bucketName, "ysj-test2.jpg", filePath);
    }

    @Test
    public void gcpDownload() {
        gcpUploadService.downloadGcpStroage(bucketName, "test.jpg", "src/main/resources/test-down2.jpg");
    }

    @Test
    public void getFiletPath() throws Exception {
        Files.readAllBytes(Paths.get("src/main/resources/test.jpg"));
    }
}