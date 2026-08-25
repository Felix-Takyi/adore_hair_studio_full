package com.adorehairstudio.api.controller;

import com.adorehairstudio.api.model.*;
import com.adorehairstudio.api.repo.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ProductRepository productRepository;
    private final ServiceItemRepository serviceRepository;
    private final TestimonialRepository testimonialRepository;
    private final ContactMessageRepository messageRepository;
    private final SiteSettingsRepository settingsRepository;

    public AdminController(
            ProductRepository productRepository,
            ServiceItemRepository serviceRepository,
            TestimonialRepository testimonialRepository,
            ContactMessageRepository messageRepository,
            SiteSettingsRepository settingsRepository
    ) {
        this.productRepository = productRepository;
        this.serviceRepository = serviceRepository;
        this.testimonialRepository = testimonialRepository;
        this.messageRepository = messageRepository;
        this.settingsRepository = settingsRepository;
    }


    // =========================================================
    // PRODUCTS
    // =========================================================

    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }


    @PostMapping("/products")
    public Product addProduct(
            @Valid @RequestBody Product product
    ) {
        product.setId(null);
        return productRepository.save(product);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody Product product
    ) {

        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        product.setId(id);

        return ResponseEntity.ok(
                productRepository.save(product)
        );
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id
    ) {

        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    // =========================================================
    // SERVICES
    // =========================================================

    @GetMapping("/services")
    public List<ServiceItem> services() {
        return serviceRepository.findAll();
    }


    @PostMapping("/services")
    public ServiceItem addService(
            @Valid @RequestBody ServiceItem service
    ) {
        service.setId(null);
        return serviceRepository.save(service);
    }


    @PutMapping("/services/{id}")
    public ResponseEntity<ServiceItem> updateService(
            @PathVariable Long id,
            @Valid @RequestBody ServiceItem service
    ) {

        if (!serviceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.setId(id);

        return ResponseEntity.ok(
                serviceRepository.save(service)
        );
    }


    @DeleteMapping("/services/{id}")
    public ResponseEntity<Void> deleteService(
            @PathVariable Long id
    ) {

        if (!serviceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        serviceRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    // =========================================================
    // TESTIMONIALS
    // =========================================================

    @GetMapping("/testimonials")
    public List<Testimonial> testimonials() {
        return testimonialRepository.findAll();
    }


    @PostMapping("/testimonials")
    public Testimonial addTestimonial(
            @Valid @RequestBody Testimonial testimonial
    ) {
        testimonial.setId(null);
        return testimonialRepository.save(testimonial);
    }


    @PutMapping("/testimonials/{id}")
    public ResponseEntity<Testimonial> updateTestimonial(
            @PathVariable Long id,
            @Valid @RequestBody Testimonial testimonial
    ) {

        if (!testimonialRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        testimonial.setId(id);

        return ResponseEntity.ok(
                testimonialRepository.save(testimonial)
        );
    }


    @DeleteMapping("/testimonials/{id}")
    public ResponseEntity<Void> deleteTestimonial(
            @PathVariable Long id
    ) {

        if (!testimonialRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        testimonialRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    // =========================================================
    // CONTACT MESSAGES
    // =========================================================

    @GetMapping("/messages")
    public List<ContactMessage> messages() {

        return messageRepository
                .findAll()
                .stream()
                .sorted(
                        Comparator
                                .comparing(ContactMessage::getCreatedAt)
                                .reversed()
                )
                .toList();
    }


    @PutMapping("/messages/{id}/read")
    public ResponseEntity<ContactMessage> markMessageRead(
            @PathVariable Long id
    ) {

        var found =
                messageRepository.findById(id);

        if (found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ContactMessage message =
                found.get();

        message.setReadMessage(true);

        return ResponseEntity.ok(
                messageRepository.save(message)
        );
    }


    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(
            @PathVariable Long id
    ) {

        if (!messageRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        messageRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    // =========================================================
    // SITE SETTINGS
    // =========================================================

    @GetMapping("/settings")
    public SiteSettings settings() {

        return settingsRepository
                .findById(1L)
                .orElseGet(SiteSettings::new);
    }


    @PutMapping("/settings")
    public SiteSettings updateSettings(
            @RequestBody SiteSettings settings
    ) {

        settings.setId(1L);

        return settingsRepository.save(settings);
    }
}package com.adorehairstudio.api.controller;
import com.adorehairstudio.api.model.*; import com.adorehairstudio.api.repo.*; import jakarta.validation.Valid; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/admin")
public class AdminController {
 private final ProductRepository p; private final ServiceItemRepository s; private final TestimonialRepository t; private final ContactMessageRepository m; private final SiteSettingsRepository st;
 public AdminController(ProductRepository p,ServiceItemRepository s,TestimonialRepository t,ContactMessageRepository m,SiteSettingsRepository st){this.p=p;this.s=s;this.t=t;this.m=m;this.st=st;}
 @GetMapping("/products") public List<Product> products(){return p.findAll();} @PostMapping("/products") public Product add(@Valid @RequestBody Product x){x.setId(null);return p.save(x);} @PutMapping("/products/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody Product x){x.setId(id);return p.save(x);} @DeleteMapping("/products/{id}") public void del(@PathVariable Long id){p.deleteById(id);}
 @GetMapping("/services") public List<ServiceItem> services(){return s.findAll();} @PostMapping("/services") public ServiceItem addS(@Valid @RequestBody ServiceItem x){x.setId(null);return s.save(x);} @PutMapping("/services/{id}") public ServiceItem updateS(@PathVariable Long id,@Valid @RequestBody ServiceItem x){x.setId(id);return s.save(x);} @DeleteMapping("/services/{id}") public void delS(@PathVariable Long id){s.deleteById(id);}
 @GetMapping("/testimonials") public List<Testimonial> testimonials(){return t.findAll();} @PostMapping("/testimonials") public Testimonial addT(@Valid @RequestBody Testimonial x){x.setId(null);return t.save(x);} @PutMapping("/testimonials/{id}") public Testimonial updateT(@PathVariable Long id,@Valid @RequestBody Testimonial x){x.setId(id);return t.save(x);} @DeleteMapping("/testimonials/{id}") public void delT(@PathVariable Long id){t.deleteById(id);}
 @GetMapping("/messages") public List<ContactMessage> messages(){return m.findAll().stream().sorted(Comparator.comparing(ContactMessage::getCreatedAt).reversed()).toList();} @PutMapping("/messages/{id}/read") public ResponseEntity<?> read(@PathVariable Long id){var found=m.findById(id); if(found.isEmpty()) return ResponseEntity.notFound().build(); var x=found.get(); x.setReadMessage(true); m.save(x); return ResponseEntity.ok(x);} @DeleteMapping("/messages/{id}") public void delM(@PathVariable Long id){m.deleteById(id);}
 @GetMapping("/settings") public SiteSettings settings(){return st.findById(1L).orElseGet(SiteSettings::new);} @PutMapping("/settings") public SiteSettings settings(@RequestBody SiteSettings x){x.setId(1L);return st.save(x);}
}
