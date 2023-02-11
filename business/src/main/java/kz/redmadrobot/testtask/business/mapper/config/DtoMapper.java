package kz.redmadrobot.testtask.business.mapper.config;

import java.util.List;
import java.util.Set;

/**
 * The interface that defines basic methods for mapping entity to dto. Object types are generic and
 * must be specified in parameters of class
 *
 * @param <S> dto class to map
 * @param <T> entity class from which to map
 */
public interface DtoMapper<T, S> {

    /**
     * This method maps passed as argument entity object to a dto.
     *
     * @param entity must not be null
     * @return mapped dto
     */
    S toDto(T entity);

    /**
     * This method maps passed as argument {@link Set} of entities to {@link Set} of dtos.
     *
     * @param entityList must not be null
     * @return mapped {@link Set} of dtos
     */
    List<S> toDtoList(List<T> entityList);
}