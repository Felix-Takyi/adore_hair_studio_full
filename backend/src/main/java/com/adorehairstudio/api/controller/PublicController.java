package com.adorehairstudio.api.controller;
import com.adorehairstudio.api.model.*; import com.adorehairstudio.api.repo.*; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/public")
public class PublicController {
 private final ProductRepository products; private final ServiceItemRepository services; private final TestimonialRepository testimonials; private final ContactMessageRepository messages; private final SiteSettingsRepository settings; private final ReviewRepository reviews; private final HairCategoryRepository hairCategories;
 public PublicController(ProductRepository p,ServiceItemRepository s,TestimonialRepository t,ContactMessageRepository m,SiteSettingsRepository st,ReviewRepository r,HairCategoryRepository hc){products=p;services=s;testimonials=t;messages=m;settings=st;reviews=r;hairCategories=hc;}
 @GetMapping("/products") public List<Product> products(){return products.findByActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/featured") public List<Product> featured(){return products.findByFeaturedTrueAndActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/services") public List<ServiceItem> services(){return services.findByActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/testimonials") public List<Testimonial> testimonials(){return testimonials.findByActiveTrueOrderByDisplayOrderAscIdAsc();}
 @GetMapping("/settings") public SiteSettings settings(){return settings.findById(1L).orElseGet(SiteSettings::new);}
 @GetMapping("/hair-categories") public List<HairCategory> hairCategories(){return hairCategories.findAllByOrderByDisplayOrderAscIdAsc();}
 @PostMapping("/messages") public ResponseEntity<?> message(@Valid @RequestBody ContactMessage m){m.setId(null);m.setCreatedAt(java.time.Instant.now());m.setReadMessage(false);messages.save(m);return ResponseEntity.status(201).body(Map.of("message","Message received"));}

 @GetMapping("/products/{id}/reviews") public ResponseEntity<?> productReviews(@PathVariable Long id){
   if(!products.existsById(id)) return ResponseEntity.notFound().build();
   return ResponseEntity.ok(reviews.findByProductIdOrderByCreatedAtDesc(id));
 }

 @PostMapping("/products/{id}/reviews") public ResponseEntity<?> addProductReview(@PathVariable Long id,@Valid @RequestBody Review r){
   if(!products.existsById(id)) return ResponseEntity.notFound().build();
   r.setId(null);
   r.setProductId(id);
   r.setCreatedAt(java.time.Instant.now());
   Review saved=reviews.save(r);
   return ResponseEntity.status(201).body(saved);
 }
}
