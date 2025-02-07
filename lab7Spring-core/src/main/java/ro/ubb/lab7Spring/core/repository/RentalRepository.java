package ro.ubb.lab7Spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ro.ubb.lab7Spring.core.model.BaseEntity;
import ro.ubb.lab7Spring.core.model.RentalBook;

import java.io.Serializable;


public interface RentalRepository extends BaseRepository<RentalBook, Long> {


}
