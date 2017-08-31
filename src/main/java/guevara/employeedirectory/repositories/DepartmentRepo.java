package guevara.employeedirectory.repositories;

import guevara.employeedirectory.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department, Long> {

    Iterable<Department>findDepartmentById(long Long);
    Iterable<Department>findAllByDepartname(String String);


}
