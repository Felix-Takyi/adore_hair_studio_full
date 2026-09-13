package com.adorehairstudio.api.repo;
import com.adorehairstudio.api.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long>{
  List<Review> findByProductIdOrderByCreatedAtDesc(Long productId);
  List<Review> findAllByOrderByCreatedAtDesc();
}
