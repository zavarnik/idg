package mystub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author Sergey Shilov
 */
@Entity
@Table(name = "stub")
public class DbEntity {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DbEntity)) return false;
        DbEntity dbEntity = (DbEntity) o;
        return Objects.equals(id, dbEntity.id) &&
                Objects.equals(name, dbEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
