package com.adorehairstudio.api.model;
import jakarta.persistence.*;
@Entity
public class AdminUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(unique=true,nullable=false) private String email; @Column(nullable=false) private String passwordHash;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
}
