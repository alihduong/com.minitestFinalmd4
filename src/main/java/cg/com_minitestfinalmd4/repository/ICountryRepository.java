package cg.com_minitestfinalmd4.repository;

import cg.com_minitestfinalmd4.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends CrudRepository<Country, Long> {
}
