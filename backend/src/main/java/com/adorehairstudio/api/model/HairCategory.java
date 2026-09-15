package com.adorehairstudio.api.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="hair_category", uniqueConstraints=@UniqueConstraint(columnNames="slug"))
public class HairCategory {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank @Column(length=80) private String name;
  @NotBlank @Column(length=90, nullable=false) private String slug;
  private Integer displayOrder=0;

  public Long getId(){return id;} public void setId(Long v){id=v;}
  public String getName(){return name;} public void setName(String v){name=v;}
  public String getSlug(){return slug;} public void setSlug(String v){slug=v;}
  public Integer getDisplayOrder(){return displayOrder;} public void setDisplayOrder(Integer v){displayOrder=v;}
}
