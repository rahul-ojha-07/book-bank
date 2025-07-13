package in.rahulojha.bookbank.entity;

import in.rahulojha.bookbank.model.FormatEnum;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String author;
    private String genre;
    @Column
    private FormatEnum format;
    private Long fileSize;
    private Integer year;
    @Column(length = 2000)
    private String description;
    private String fileName;
    private String filePath;
    private LocalDateTime uploadDate;

    @ElementCollection
    private List<String> tags;
}
