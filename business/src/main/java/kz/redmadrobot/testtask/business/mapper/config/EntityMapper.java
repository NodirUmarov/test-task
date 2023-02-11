package kz.redmadrobot.testtask.business.mapper.config;

import java.util.List;
import java.util.Set;

/**
 * The interface that defines basic methods for mapping dto to entity. Object types are generic and
 * must be specified in parameters of class
 *
 *  @param <T> entity class to map
 *  @param <S> dto class from which to map
 */
public interface EntityMapper<T, S> {

    /**
     * This method maps passed as argument dto object to an entity.
     *
     * @param dto must not be null
     * @return mapped entity
     */
    T toEntity(S dto);

}