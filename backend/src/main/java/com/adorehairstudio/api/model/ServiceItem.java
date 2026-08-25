package com.adorehairstudio.api.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="service_items")
public class ServiceItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; @Column(length=2000) private String description; private String priceLabel; private String icon; private boolean active=true; private Integer displayOrder=0;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getPriceLabel(){return priceLabel;} public void setPriceLabel(String v){priceLabel=v;} public String getIcon(){return icon;} public void setIcon(String v){icon=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;} public Integer getDisplayOrder(){return displayOrder;} public void setDisplayOrder(Integer v){displayOrder=v;}
}
