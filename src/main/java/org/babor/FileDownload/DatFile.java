package org.babor.FileDownload;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private byte[] data;
    public DatFile(byte[] data) {
        this.data = data;
    }
}
