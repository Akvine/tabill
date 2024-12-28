package ru.akvine.tabill.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.managers.ConvertersManager;
import ru.akvine.tabill.services.converters.FileConverter;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Configuration
public class ManagerBeansConfig {

    @Bean
    public ConvertersManager convertersManager(List<FileConverter> fileConverters) {
        Map<Extension, FileConverter> fileConverterMap = fileConverters.stream()
                .collect(toMap(FileConverter::getType, identity()));
        return new ConvertersManager(fileConverterMap);
    }
}
