package ru.akvine.tabill.configs;

import org.apache.poi.ss.usermodel.CellType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.managers.CellTypeConvertersManager;
import ru.akvine.tabill.managers.ConvertersManager;
import ru.akvine.tabill.services.converters.FileConverter;
import ru.akvine.tabill.services.excel.CellTypeConverter;

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

    @Bean
    public CellTypeConvertersManager cellTypeConvertersManager(List<CellTypeConverter> converters) {
        Map<CellType, CellTypeConverter> cellTypeCellTypeConverterMap = converters.stream()
                .collect(toMap(CellTypeConverter::getType, identity()));
        return new CellTypeConvertersManager(cellTypeCellTypeConverterMap);
    }
}
