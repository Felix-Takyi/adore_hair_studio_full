package com.adorehairstudio.api.controller;

import com.adorehairstudio.api.model.ContactMessage;
import com.adorehairstudio.api.model.HairCategory;
import com.adorehairstudio.api.model.Product;
import com.adorehairstudio.api.model.Review;
import com.adorehairstudio.api.model.ServiceItem;
import com.adorehairstudio.api.model.SiteSettings;
import com.adorehairstudio.api.model.Testimonial;

import com.adorehairstudio.api.repo.ContactMessageRepository;
import com.adorehairstudio.api.repo.HairCategoryRepository;
import com.adorehairstudio.api.repo.ProductRepository;
import com.adorehairstudio.api.repo.ReviewRepository;
import com.adorehairstudio.api.repo.ServiceItemRepository;
import com.adorehairstudio.api.repo.SiteSettingsRepository;
import com.adorehairstudio.api.repo.TestimonialRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ProductRepository productRepository;
    private final ServiceItemRepository serviceRepository;
    private final TestimonialRepository testimonialRepository;
    private final ContactMessageRepository messageRepository;
    private final SiteSettingsRepository settingsRepository;
    private final ReviewRepository reviewRepository;
    private final HairCategoryRepository hairCategoryRepository;


    public AdminController(
            ProductRepository productRepository,
            ServiceItemRepository serviceRepository,
            TestimonialRepository testimonialRepository,
            ContactMessageRepository messageRepository,
            SiteSettingsRepository settingsRepository,
            ReviewRepository reviewRepository,
            HairCategoryRepository hairCategoryRepository
    ) {
        this.productRepository = productRepository;
        this.serviceRepository = serviceRepository;
        this.testimonialRepository = testimonialRepository;
        this.messageRepository = messageRepository;
        this.settingsRepository = settingsRepository;
        this.reviewRepository = reviewRepository;
        this.hairCategoryRepository = hairCategoryRepository;
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

        Product savedProduct =
                productRepository.save(product);

        return ResponseEntity.ok(savedProduct);
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

        ServiceItem savedService =
                serviceRepository.save(service);

        return ResponseEntity.ok(savedService);
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

        Testimonial savedTestimonial =
                testimonialRepository.save(testimonial);

        return ResponseEntity.ok(savedTestimonial);
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

        ContactMessage savedMessage =
                messageRepository.save(message);

        return ResponseEntity.ok(savedMessage);
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
    // PRODUCT REVIEWS
    // =========================================================

    @GetMapping("/reviews")
    public List<Review> reviews() {
        return reviewRepository.findAllByOrderByCreatedAtDesc();
    }


    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Void> deleteReview(
            @PathVariable Long id
    ) {

        if (!reviewRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        reviewRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    // =========================================================
    // HAIR CATEGORIES (wig categories)
    // =========================================================

    @GetMapping("/hair-categories")
    public List<HairCategory> hairCategories() {
        return hairCategoryRepository.findAllByOrderByDisplayOrderAscIdAsc();
    }


    @PostMapping("/hair-categories")
    public ResponseEntity<?> addHairCategory(@RequestBody Map<String, String> body) {

        String name = body.get("name") == null ? "" : body.get("name").trim();

        if (name.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Category name is required."));
        }

        String baseSlug = name.toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-+|-+$)", "");

        if (baseSlug.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Please use a valid category name."));
        }

        String slug = baseSlug;
        int suffix = 2;
        while (hairCategoryRepository.existsBySlug(slug)) {
            slug = baseSlug + "-" + suffix;
            suffix++;
        }

        int nextOrder = hairCategoryRepository.findAllByOrderByDisplayOrderAscIdAsc().size();

        HairCategory category = new HairCategory();
        category.setName(name);
        category.setSlug(slug);
        category.setDisplayOrder(nextOrder);

        HairCategory saved = hairCategoryRepository.save(category);

        return ResponseEntity.status(201).body(saved);
    }


    @DeleteMapping("/hair-categories/{id}")
    public ResponseEntity<?> deleteHairCategory(
            @PathVariable Long id,
            @RequestParam(name = "moveToUnassigned", required = false, defaultValue = "false") boolean moveToUnassigned
    ) {

        HairCategory category = hairCategoryRepository.findById(id).orElse(null);

        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        long inUse = productRepository.countByCategory(category.getSlug());

        if (inUse > 0 && !moveToUnassigned) {
            return ResponseEntity.status(409).body(Map.of(
                    "message",
                    "\"" + category.getName() + "\" is still used by " + inUse +
                            " product" + (inUse == 1 ? "" : "s") + ".",
                    "productCount", inUse
            ));
        }

        if (inUse > 0) {
            List<Product> affected = productRepository.findByCategory(category.getSlug());
            for (Product product : affected) {
                product.setCategory(null);
                product.setActive(false);
                productRepository.save(product);
            }
        }

        hairCategoryRepository.deleteById(id);

        return ResponseEntity.ok(Map.of(
                "message", inUse > 0
                        ? inUse + " product" + (inUse == 1 ? "" : "s") + " moved to Unassigned and hidden from the site."
                        : "Category removed.",
                "movedCount", inUse
        ));
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
}
