package in.rahulojha.bookbank.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Stats
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.14.0")
public class Stats {

  private @Nullable Integer totalBooks;

  private @Nullable Long pdfCount;

  private @Nullable Long epubCount;

  private @Nullable Long mobiCount;

  private @Nullable Long azw3Count;

  private @Nullable Long authorCount;

  private @Nullable Long totalFileSize;

  public Stats totalBooks(@Nullable Integer totalBooks) {
    this.totalBooks = totalBooks;
    return this;
  }

  /**
   * Get totalBooks
   * @return totalBooks
   */
  
  @Schema(name = "totalBooks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalBooks")
  public @Nullable Integer getTotalBooks() {
    return totalBooks;
  }

  public void setTotalBooks(@Nullable Integer totalBooks) {
    this.totalBooks = totalBooks;
  }

  public Stats pdfCount(@Nullable Long pdfCount) {
    this.pdfCount = pdfCount;
    return this;
  }

  /**
   * Get pdfCount
   * @return pdfCount
   */
  
  @Schema(name = "pdfCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pdfCount")
  public @Nullable Long getPdfCount() {
    return pdfCount;
  }

  public void setPdfCount(@Nullable Long pdfCount) {
    this.pdfCount = pdfCount;
  }

  public Stats epubCount(@Nullable Long epubCount) {
    this.epubCount = epubCount;
    return this;
  }

  /**
   * Get epubCount
   * @return epubCount
   */
  
  @Schema(name = "epubCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("epubCount")
  public @Nullable Long getEpubCount() {
    return epubCount;
  }

  public void setEpubCount(@Nullable Long epubCount) {
    this.epubCount = epubCount;
  }

  public Stats mobiCount(@Nullable Long mobiCount) {
    this.mobiCount = mobiCount;
    return this;
  }

  /**
   * Get mobiCount
   * @return mobiCount
   */
  
  @Schema(name = "mobiCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mobiCount")
  public @Nullable Long getMobiCount() {
    return mobiCount;
  }

  public void setMobiCount(@Nullable Long mobiCount) {
    this.mobiCount = mobiCount;
  }

  public Stats azw3Count(@Nullable Long azw3Count) {
    this.azw3Count = azw3Count;
    return this;
  }

  /**
   * Get azw3Count
   * @return azw3Count
   */
  
  @Schema(name = "azw3Count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("azw3Count")
  public @Nullable Long getAzw3Count() {
    return azw3Count;
  }

  public void setAzw3Count(@Nullable Long azw3Count) {
    this.azw3Count = azw3Count;
  }

  public Stats authorCount(@Nullable Long authorCount) {
    this.authorCount = authorCount;
    return this;
  }

  /**
   * Get authorCount
   * @return authorCount
   */
  
  @Schema(name = "authorCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authorCount")
  public @Nullable Long getAuthorCount() {
    return authorCount;
  }

  public void setAuthorCount(@Nullable Long authorCount) {
    this.authorCount = authorCount;
  }

  public Stats totalFileSize(@Nullable Long totalFileSize) {
    this.totalFileSize = totalFileSize;
    return this;
  }

  /**
   * Get totalFileSize
   * @return totalFileSize
   */
  
  @Schema(name = "totalFileSize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalFileSize")
  public @Nullable Long getTotalFileSize() {
    return totalFileSize;
  }

  public void setTotalFileSize(@Nullable Long totalFileSize) {
    this.totalFileSize = totalFileSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stats stats = (Stats) o;
    return Objects.equals(this.totalBooks, stats.totalBooks) &&
        Objects.equals(this.pdfCount, stats.pdfCount) &&
        Objects.equals(this.epubCount, stats.epubCount) &&
        Objects.equals(this.mobiCount, stats.mobiCount) &&
        Objects.equals(this.azw3Count, stats.azw3Count) &&
        Objects.equals(this.authorCount, stats.authorCount) &&
        Objects.equals(this.totalFileSize, stats.totalFileSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalBooks, pdfCount, epubCount, mobiCount, azw3Count, authorCount, totalFileSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stats {\n");
    sb.append("    totalBooks: ").append(toIndentedString(totalBooks)).append("\n");
    sb.append("    pdfCount: ").append(toIndentedString(pdfCount)).append("\n");
    sb.append("    epubCount: ").append(toIndentedString(epubCount)).append("\n");
    sb.append("    mobiCount: ").append(toIndentedString(mobiCount)).append("\n");
    sb.append("    azw3Count: ").append(toIndentedString(azw3Count)).append("\n");
    sb.append("    authorCount: ").append(toIndentedString(authorCount)).append("\n");
    sb.append("    totalFileSize: ").append(toIndentedString(totalFileSize)).append("\n");
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

