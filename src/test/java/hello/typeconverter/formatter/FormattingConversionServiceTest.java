package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        //컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        //converter 사용
        IpPort ipPort = conversionService.convert("127.11.22.33:8090", IpPort.class);
        Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.11.22.33",8090));

        //포맷터 사용
        String convert1 = conversionService.convert(12345678, String.class);
        Assertions.assertThat(convert1).isEqualTo("12,345,678");

        Long convert2 = conversionService.convert("12,345,678", Long.class);
        Assertions.assertThat(convert2).isEqualTo(12345678L);
    }
}
