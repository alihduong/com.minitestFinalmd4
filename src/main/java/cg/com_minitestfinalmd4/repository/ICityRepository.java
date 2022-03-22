package cg.com_minitestfinalmd4.repository;

import cg.com_minitestfinalmd4.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends CrudRepository<City, Long> {
}
