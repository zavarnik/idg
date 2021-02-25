package mystub.dao;

import mystub.entity.DbEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sergey Shilov
 */
public interface StubRepository extends CrudRepository<DbEntity, String> {

}
