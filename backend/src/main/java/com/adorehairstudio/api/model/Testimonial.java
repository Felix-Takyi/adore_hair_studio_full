package com.adorehairstudio.api.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity
public class Testimonial {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @NotBlank @Column(length=2000) private String text; @NotBlank private String name; private String title; @Min(1) @Max(5) private int stars=5; private boolean active=true; private Integer displayOrder=0;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getText(){return text;} public void setText(String v){text=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getTitle(){return title;} public void setTitle(String v){title=v;} public int getStars(){return stars;} public void setStars(int v){stars=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;} public Integer getDisplayOrder(){return displayOrder;} public void setDisplayOrder(Integer v){displayOrder=v;}
}
