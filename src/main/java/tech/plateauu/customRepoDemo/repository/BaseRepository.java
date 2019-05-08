package tech.plateauu.customRepoDemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<ENTITY, ID> extends MongoRepository<ENTITY, ID> {

    List<ENTITY> findAllByName(String name);

}



