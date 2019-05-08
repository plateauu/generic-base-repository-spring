package tech.plateauu.customRepoDemo.repository;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Collection;

public class BaseRepositoryCustomImpl<E> implements BaseRepositoryCustom<E> {

    private final MongoTemplate template;

    public BaseRepositoryCustomImpl(MongoTemplate template) {
        this.template = template;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void saveAllPersonFromCollection(Collection<E> collection) {
        if (collection.size() == 1) {
            E o = (E) collection.toArray()[0];
            template.save(o, "person_input");
        }
    }
}
