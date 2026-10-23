package prakash.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import prakash.model.Student;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Student student){
        entityManager.persist(student);
    }
    @EntityGraph(attributePaths ="department" )

    public Student findById(Long id){
      return   entityManager.find(Student.class,id);
    }

}
