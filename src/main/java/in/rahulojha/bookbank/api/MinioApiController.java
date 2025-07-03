package in.rahulojha.bookbank.api;



import in.rahulojha.bookbank.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.14.0")
@Controller
@RequestMapping("${openapi.bookBank.base-path:}")
public class MinioApiController implements MinioApi {

    private final NativeWebRequest request;
    private final MinioService minioService;

    @Autowired
    public MinioApiController(NativeWebRequest request, MinioService minioService) {
        this.request = request;
        this.minioService = minioService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<String> minioUploadPost(MultipartFile file) {
        try {
            minioService.uploadFile(file.getOriginalFilename(), file);
            return ResponseEntity.ok("Uploaded Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Resource> minioDownloadFilenameGet(String filename) throws Exception {
        InputStream inputStream = minioService.getFile(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(inputStream));
    }

    @Override
    public ResponseEntity<String> minioDeleteFilenameDelete(String filename) throws Exception {
        minioService.deleteFile(filename);
        return ResponseEntity.ok("Deleted");
    }

    @Override
    public ResponseEntity<List<String>> minioListGet() throws Exception {
        return ResponseEntity.ok(minioService.listFiles());
    }

    @Override
    public ResponseEntity<String> minioPresignedDownloadFilenameGet(String filename) {
        try {
            String url = minioService.generateDownloadUrl(filename, 60 * 10); // 10 minutes
            return ResponseEntity.ok(url);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> minioPresignedUploadFilenameGet(String filename) {
        try {
            String url = minioService.generateUploadUrl(filename, 60 * 10); // 10 minutes
            return ResponseEntity.ok(url);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
