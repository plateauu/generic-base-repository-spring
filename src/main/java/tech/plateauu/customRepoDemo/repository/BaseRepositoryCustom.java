package tech.plateauu.customRepoDemo.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

@NoRepositoryBean
public interface BaseRepositoryCustom<E> {

    void saveAllPersonFromCollection(Collection<E> collection);

}
