package com.adorehairstudio.api.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.Instant;

@Entity
public class Review {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotNull private Long productId;
  @NotBlank @Column(length=120) private String customerName;
  @Min(1) @Max(5) private int rating=5;
  @NotBlank @Column(length=2000) private String comment;
  private Instant createdAt=Instant.now();

  public Long getId(){return id;} public void setId(Long v){id=v;}
  public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;}
  public String getCustomerName(){return customerName;} public void setCustomerName(String v){customerName=v;}
  public int getRating(){return rating;} public void setRating(int v){rating=v;}
  public String getComment(){return comment;} public void setComment(String v){comment=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){createdAt=v;}
}
