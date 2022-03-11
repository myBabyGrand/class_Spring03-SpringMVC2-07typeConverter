package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService(){
        //given
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //when
        Integer StringToIntegerResult = conversionService.convert("10", Integer.class);
        String IntegerToStringResult = conversionService.convert(10, String.class);

        IpPort StringToIpPortResult = conversionService.convert("127.0.0.1:8080", IpPort.class);
        String IpPortToStringResult = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);

        //then
        assertThat(StringToIntegerResult).isEqualTo(10);
        assertThat(IntegerToStringResult).isEqualTo("10");
        assertThat(StringToIpPortResult).isEqualTo(new IpPort("127.0.0.1", 8080));
        assertThat(IpPortToStringResult).isEqualTo("127.0.0.1:8080");
    }
}
