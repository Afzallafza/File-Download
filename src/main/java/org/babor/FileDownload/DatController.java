package org.babor.FileDownload;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
public class DatController {
    private final FileService fileService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("testd", HttpStatus.OK);
    }

    @GetMapping("/download-file")
    public ResponseEntity<StreamingResponseBody> downloadFile() throws IOException {
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment").filename("notun-file").build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        headers.setContentType(MediaType.APPLICATION_PDF);
        StreamingResponseBody stream = outputStream -> {
            String uri = "http://localhost:8080/download-file?id=202";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.execute(uri, HttpMethod.GET, null, response -> response.getBody().transferTo(outputStream));
            outputStream.flush();
        };
        return new ResponseEntity<>(stream, headers, HttpStatus.OK);
    }

}
