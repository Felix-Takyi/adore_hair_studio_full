package com.adorehairstudio.api.repo;
import com.adorehairstudio.api.model.HairCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HairCategoryRepository extends JpaRepository<HairCategory,Long>{
  List<HairCategory> findAllByOrderByDisplayOrderAscIdAsc();
  boolean existsBySlug(String slug);
}
