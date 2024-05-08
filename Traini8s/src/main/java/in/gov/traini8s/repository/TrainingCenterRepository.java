package in.gov.traini8s.repository;

import in.gov.traini8s.entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    @Query("SELECT c FROM TrainingCenter c " +
            "WHERE LOWER(c.centerName) LIKE LOWER(:searchTerm) OR " +
            "LOWER(c.centerCode) LIKE LOWER(:searchTerm) OR " +
            "LOWER(c.address.city) LIKE LOWER(:searchTerm) OR " +
            "LOWER(c.address.state) LIKE LOWER(:searchTerm) OR " +
            "LOWER(c.address.detailedAddress) LIKE LOWER(:searchTerm) OR " +
            "EXISTS (SELECT 1 FROM c.coursesOffered course WHERE LOWER(course) LIKE LOWER(:searchTerm))")
    List<TrainingCenter> findByQuery(String searchTerm);

}
