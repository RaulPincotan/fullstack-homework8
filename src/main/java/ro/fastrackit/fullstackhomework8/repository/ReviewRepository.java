package ro.fastrackit.fullstackhomework8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fastrackit.fullstackhomework8.model.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
