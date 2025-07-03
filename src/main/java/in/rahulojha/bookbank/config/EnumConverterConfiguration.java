package in.rahulojha.bookbank.config;

import in.rahulojha.bookbank.model.FormatEnum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration(value = "in.rahulojha.bookbank.config.enumConverterConfiguration")
public class EnumConverterConfiguration {

    @Bean(name = "in.rahulojha.bookbank.config.EnumConverterConfiguration.formatEnumConverter")
    Converter<String, FormatEnum> formatEnumConverter() {
        return new Converter<String, FormatEnum>() {
            @Override
            public FormatEnum convert(String source) {
                return FormatEnum.fromValue(source);
            }
        };
    }

}
