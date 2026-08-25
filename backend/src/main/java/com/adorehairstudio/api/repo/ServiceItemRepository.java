package com.adorehairstudio.api.repo;
import com.adorehairstudio.api.model.ServiceItem; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ServiceItemRepository extends JpaRepository<ServiceItem,Long>{ List<ServiceItem> findByActiveTrueOrderByDisplayOrderAscIdAsc(); }
