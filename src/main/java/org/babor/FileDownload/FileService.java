package org.babor.FileDownload;


import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class FileService {
//    public InputStream getFile() throws IOException {
//        RestTemplate restTemplate = new RestTemplate();
//        String uri = "http://localhost:8080/download-file?id=102";
//        Resource resource = restTemplate.getForObject(uri, Resource.class)
//    }
}
