package in.rahulojha.bookbank.model;

import java.net.URI;
import java.time.ZoneOffset;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import in.rahulojha.bookbank.model.FormatEnum;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Book
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.14.0")
public class Book {

  private @Nullable UUID id;

  private @Nullable String title;

  private @Nullable String author;

  private @Nullable String genre;

  private @Nullable FormatEnum format;

  private @Nullable Long fileSize;

  private @Nullable Integer year;

  private @Nullable String description;

  private @Nullable String fileName;

  private @Nullable String filePath;





  @Valid
  private List<String> tags = new ArrayList<>();

  private @Nullable String coverUrl;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime uploadDate;

  public static Book fromBookEntity(in.rahulojha.bookbank.entity.Book book) {
    return new Book()
            .id(book.getId())
            .title(book.getTitle())
            .author(book.getAuthor())
            .genre(book.getGenre())
            .format(book.getFormat())
            .fileSize(book.getFileSize())
            .year(book.getYear())
            .description(book.getDescription())
            .fileName(book.getFileName())
            .filePath(book.getFilePath())
            .tags(book.getTags())
            .uploadDate(book.getUploadDate().atOffset(ZoneOffset.UTC));
  }

  public Book id(@Nullable UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable UUID getId() {
    return id;
  }

  public void setId(@Nullable UUID id) {
    this.id = id;
  }

  public Book title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public Book author(@Nullable String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
   */
  
  @Schema(name = "author", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("author")
  public @Nullable String getAuthor() {
    return author;
  }

  public void setAuthor(@Nullable String author) {
    this.author = author;
  }

  public Book genre(@Nullable String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * Get genre
   * @return genre
   */
  
  @Schema(name = "genre", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("genre")
  public @Nullable String getGenre() {
    return genre;
  }

  public void setGenre(@Nullable String genre) {
    this.genre = genre;
  }

  public Book format(@Nullable FormatEnum format) {
    this.format = format;
    return this;
  }

  /**
   * Get format
   * @return format
   */
  @Valid 
  @Schema(name = "format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("format")
  public @Nullable FormatEnum getFormat() {
    return format;
  }

  public void setFormat(@Nullable FormatEnum format) {
    this.format = format;
  }

  public Book fileSize(@Nullable Long fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  /**
   * Get fileSize
   * @return fileSize
   */
  
  @Schema(name = "fileSize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileSize")
  public @Nullable Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(@Nullable Long fileSize) {
    this.fileSize = fileSize;
  }

  public Book year(@Nullable Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
   */
  
  @Schema(name = "year", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("year")
  public @Nullable Integer getYear() {
    return year;
  }

  public void setYear(@Nullable Integer year) {
    this.year = year;
  }

  public Book description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public Book fileName(@Nullable String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * Get fileName
   * @return fileName
   */
  
  @Schema(name = "fileName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileName")
  public @Nullable String getFileName() {
    return fileName;
  }

  public void setFileName(@Nullable String fileName) {
    this.fileName = fileName;
  }

  public Book filePath(@Nullable String filePath) {
    this.filePath = filePath;
    return this;
  }

  /**
   * Get filePath
   * @return filePath
   */
  
  @Schema(name = "filePath", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filePath")
  public @Nullable String getFilePath() {
    return filePath;
  }

  public void setFilePath(@Nullable String filePath) {
    this.filePath = filePath;
  }

  public Book tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Book addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
   */
  
  @Schema(name = "tags", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tags")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Book coverUrl(@Nullable String coverUrl) {
    this.coverUrl = coverUrl;
    return this;
  }

  /**
   * Get coverUrl
   * @return coverUrl
   */
  
  @Schema(name = "coverUrl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("coverUrl")
  public @Nullable String getCoverUrl() {
    return coverUrl;
  }

  public void setCoverUrl(@Nullable String coverUrl) {
    this.coverUrl = coverUrl;
  }

  public Book uploadDate(@Nullable OffsetDateTime uploadDate) {
    this.uploadDate = uploadDate;
    return this;
  }

  /**
   * Get uploadDate
   * @return uploadDate
   */
  @Valid 
  @Schema(name = "uploadDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uploadDate")
  public @Nullable OffsetDateTime getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(@Nullable OffsetDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.id, book.id) &&
        Objects.equals(this.title, book.title) &&
        Objects.equals(this.author, book.author) &&
        Objects.equals(this.genre, book.genre) &&
        Objects.equals(this.format, book.format) &&
        Objects.equals(this.fileSize, book.fileSize) &&
        Objects.equals(this.year, book.year) &&
        Objects.equals(this.description, book.description) &&
        Objects.equals(this.fileName, book.fileName) &&
        Objects.equals(this.filePath, book.filePath) &&
        Objects.equals(this.tags, book.tags) &&
        Objects.equals(this.coverUrl, book.coverUrl) &&
        Objects.equals(this.uploadDate, book.uploadDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, genre, format, fileSize, year, description, fileName, filePath, tags, coverUrl, uploadDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    coverUrl: ").append(toIndentedString(coverUrl)).append("\n");
    sb.append("    uploadDate: ").append(toIndentedString(uploadDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

