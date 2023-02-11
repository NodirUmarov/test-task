package kz.redmadrobot.testtask.business.mapper.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * The interface that defines two basic configs for all application mappers:
 * <ul>
 *     <li>Value {@code "spring"} passed to {@link MapperConfig#componentModel()} to let Spring treat the mapper like bean</li>
 *     <li>{@link ReportingPolicy#IGNORE} passed to {@link MapperConfig#unmappedTargetPolicy()}
 *     to let mapper ignore missing attributes</li>
 * </ul>
 *
 */

@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AutowireMapper {
}
