package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConverterTest {

    @Test
    void stringToInteger(){
        //given
        StringToIntegerConverter converter = new StringToIntegerConverter();

        //when
        Integer result = converter.convert("10");
        Integer expected = 10;

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void integerToSpring(){
        //given
        IntegerToStringConverter converter = new IntegerToStringConverter();

        //when
        String result = converter.convert(10);
        String expected = "10";

        //then
        Assertions.assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort(){
        //given
        StringToIpPortConverter converter = new StringToIpPortConverter();

        //when
        IpPort result = converter.convert("127.0.0.1:8080");
        IpPort expected = new IpPort("127.0.0.1", 8080);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void ipPortToString(){
        //given
        IpPortToStringConverter converter = new IpPortToStringConverter();

        //when
        String result =  converter.convert(new IpPort("127.0.0.1", 8080));
        String expected = "127.0.0.1:8080";

        //then
        Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}
