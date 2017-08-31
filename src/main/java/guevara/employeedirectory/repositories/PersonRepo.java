package guevara.employeedirectory.repositories;

import guevara.employeedirectory.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {




}
