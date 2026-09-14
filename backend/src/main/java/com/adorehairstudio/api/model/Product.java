package com.adorehairstudio.api.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Set;
@Entity
public class Product {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank private String name;
  @Column(length=2000) private String description;
  @NotNull @DecimalMin("0.0") private BigDecimal price;
  private BigDecimal oldPrice;
  private String tag;
  private String imageUrl;
  private String category;
  private String productType;
  @Min(0) @Max(5) private int stars=5;
  private boolean featured;
  private boolean active=true;
  private Integer displayOrder=0;
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String v){name=v;}
  public String getDescription(){return description;} public void setDescription(String v){description=v;}
  public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
  public BigDecimal getOldPrice(){return oldPrice;} public void setOldPrice(BigDecimal v){oldPrice=v;}
  public String getTag(){return tag;} public void setTag(String v){tag=v;}
  public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
  public String getCategory(){return category;} public void setCategory(String v){category=v;}
  public String getProductType(){
    if(productType!=null&&!productType.isBlank())return "WIG".equalsIgnoreCase(productType)?"WIG":"OTHER";
    if(category==null||category.isBlank())return "WIG";
    return Set.of("lace","body-wave","curly","colored","closure").contains(category)?"WIG":"OTHER";
  }
  public void setProductType(String v){
    if(v==null||v.isBlank()){productType=null;return;}
    productType="WIG".equalsIgnoreCase(v.trim())?"WIG":"OTHER";
  }
  public int getStars(){return stars;} public void setStars(int v){stars=v;}
  public boolean isFeatured(){return featured;} public void setFeatured(boolean v){featured=v;}
  public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
  public Integer getDisplayOrder(){return displayOrder;} public void setDisplayOrder(Integer v){displayOrder=v;}
}
