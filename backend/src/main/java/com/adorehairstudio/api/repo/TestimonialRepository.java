package com.adorehairstudio.api.repo;
import com.adorehairstudio.api.model.Testimonial; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface TestimonialRepository extends JpaRepository<Testimonial,Long>{ List<Testimonial> findByActiveTrueOrderByDisplayOrderAscIdAsc(); }
