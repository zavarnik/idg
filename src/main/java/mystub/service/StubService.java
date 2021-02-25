package mystub.service;

import mystub.dao.StubRepository;
import mystub.dto.Entity;
import mystub.entity.DbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Sergey Shilov
 */
@Service
public class StubService {

    @Autowired
    private StubRepository repository;
//    private JdbcTemplate jdbcTemplate;

    public Entity save(Entity entity) {
        DbEntity save = new DbEntity();
        save.setId(entity.getId());
        save.setName(entity.getName());
        save = repository.save(save);
//        jdbcTemplate.update("INSERT INTO stub VALUES (?, ?)", entity.getId(), entity.getName());
        return get(save.getId());
    }

    public Entity update(String id, Entity entity) {
        DbEntity dbEntity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No item with id: " + id));
        dbEntity.setName(entity.getName());
        repository.save(dbEntity);
        return get(id);
    }

    public Entity get(String id) {
        DbEntity dbEntity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No item with id: " + id));
        Entity entity = new Entity(dbEntity.getId(), dbEntity.getName());
        System.out.println(entity);
        return entity;
    }

    public void delete(String id) {
        DbEntity dbEntity = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No item with id: " + id));
        repository.delete(dbEntity);
    }
}
