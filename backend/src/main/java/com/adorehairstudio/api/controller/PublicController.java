package com.adorehairstudio.api.controller;
import com.adorehairstudio.api.model.*; import com.adorehairstudio.api.repo.*; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/public")
public class PublicController {
 private final ProductRepository products; private final ServiceItemRepository services; private final TestimonialRepository testimonials; private final ContactMessageRepository messages; private final SiteSettingsRepository settings;
 public PublicController(ProductRepository p,ServiceItemRepository s,TestimonialRepository t,ContactMessageRepository m,SiteSettingsRepository st){products=p;services=s;testimonials=t;messages=m;settings=st;}
 @GetMapping("/products") public List<Product> products(){return products.findByActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/featured") public List<Product> featured(){return products.findByFeaturedTrueAndActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/services") public List<ServiceItem> services(){return services.findByActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/testimonials") public List<Testimonial> testimonials(){return testimonials.findByActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/settings") public SiteSettings settings(){return settings.findById(1L).orElseGet(SiteSettings::new);}
 @PostMapping("/messages") public ResponseEntity<?> message(@Valid @RequestBody ContactMessage m){m.setId(null);m.setCreatedAt(java.time.Instant.now());m.setReadMessage(false);messages.save(m);return ResponseEntity.status(201).body(Map.of("message","Message received"));}
}
