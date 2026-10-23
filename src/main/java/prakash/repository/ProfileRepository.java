package prakash.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import prakash.model.Profile;

@Repository
public class ProfileRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public  void save(Profile profile){
        entityManager.persist(profile);
    }

}
