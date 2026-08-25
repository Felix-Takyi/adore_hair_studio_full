package com.adorehairstudio.api.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.time.Instant;
@Entity
public class ContactMessage {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @NotBlank private String name; @NotBlank @Email private String email; private String phone; private String service; @NotBlank @Column(length=4000) private String message; private Instant createdAt=Instant.now(); private boolean readMessage=false;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;} public String getService(){return service;} public void setService(String v){service=v;} public String getMessage(){return message;} public void setMessage(String v){message=v;} public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){createdAt=v;} public boolean isReadMessage(){return readMessage;} public void setReadMessage(boolean v){readMessage=v;}
}
