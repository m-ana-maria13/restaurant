package repository;



import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T> implements IRepository<T> {
    protected final List<T> entities = new ArrayList<T>();

    public abstract String getId(T entity);

    @Override
    public T save(T entity) {

        if (entity != null) {
            String id = getId(entity);
            if (id != null) {
                delete(entity); // daca entitiy e deja, sterg datele vechi si il salvez din nou (update)
                entities.add(entity);
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public T findById(String id) {
        if (id == null) {
            return null;
        }
        for (T entity : entities) {
            if (id.equals(getId(entity))) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(T entity) {
        if (entity == null) {
            return false;
        }
        String id = getId(entity);
        if (id == null) {
            return false;
        }

        return entities.removeIf(item-> id.equals(getId(item)));
        //for item in entities, if id=id , remove
    }
}
