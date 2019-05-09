package tech.plateauu.customRepoDemo.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.List;

public class BaseRepositoryImpl<E, ID> extends SimpleMongoRepository<E, ID> implements BaseRepository<E, ID> {

    private final MongoTemplate template;

    public BaseRepositoryImpl(MongoEntityInformation<E, ID> entityInformation, MongoTemplate template) {
        super(entityInformation, template);
        this.template = template;
    }

    @Override
    public List<E> findAllByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return (List<E>) template.find(query, PersonInput.class);
    }
}
