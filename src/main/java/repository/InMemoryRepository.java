package repository;



import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T> implements IRepository<T> {
    protected final List<T> entities = new ArrayList<T>();

    protected abstract String getId(T entity);

    @Override
    public T save(T entity) {

        if (entity != null) {
            String id = getId(entity);
            if (id != null) {
                delete(entity);
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
        //fot item in entities, if id=id , remove
    }
}
