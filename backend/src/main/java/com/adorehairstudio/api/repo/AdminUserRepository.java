package com.adorehairstudio.api.repo;
import com.adorehairstudio.api.model.AdminUser; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface AdminUserRepository extends JpaRepository<AdminUser,Long>{ Optional<AdminUser> findByEmailIgnoreCase(String email); }
