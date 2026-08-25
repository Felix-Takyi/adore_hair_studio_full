package com.adorehairstudio.api.model;
import jakarta.persistence.*;
@Entity
public class SiteSettings {
 @Id private Long id=1L; private String phone; private String whatsapp; private String email; private String instagram; private String address; private String heroEyebrow; private String heroTitle; @Column(length=1000) private String heroTagline;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;} public String getWhatsapp(){return whatsapp;} public void setWhatsapp(String v){whatsapp=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getInstagram(){return instagram;} public void setInstagram(String v){instagram=v;} public String getAddress(){return address;} public void setAddress(String v){address=v;} public String getHeroEyebrow(){return heroEyebrow;} public void setHeroEyebrow(String v){heroEyebrow=v;} public String getHeroTitle(){return heroTitle;} public void setHeroTitle(String v){heroTitle=v;} public String getHeroTagline(){return heroTagline;} public void setHeroTagline(String v){heroTagline=v;}
}
