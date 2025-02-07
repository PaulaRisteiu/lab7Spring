package ro.ubb.lab7Spring.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ro.ubb.lab7Spring.core.model.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID> {
}
