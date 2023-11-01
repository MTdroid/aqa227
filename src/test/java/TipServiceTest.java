import academy.kata.TipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TipServiceTest {
    TipService tipService =new TipService();


    @ParameterizedTest
    @MethodSource("argsTenPercent")
    /*@ValueSource(ints = { 1200, 1000})*/
    public void FivePercent(BigDecimal amount) { // <1000 = 10 % >1000 = 5%
        assertEquals(amount.multiply(BigDecimal.valueOf(1.1)), tipService.roundTips(amount));
    }
    static Stream<BigDecimal> argsTenPercent() {
        return Stream.of(BigDecimal.valueOf(1), BigDecimal.valueOf(999));
    }

    @ParameterizedTest
    @MethodSource("argsFivePercent")
    public void TenPercent(BigDecimal amount) {
        assertEquals(amount.multiply(BigDecimal.valueOf(1.05)), tipService.roundTips(amount));
    }
    static Stream<BigDecimal> argsFivePercent() {
        return Stream.of(BigDecimal.valueOf(1000), BigDecimal.valueOf(1100));
    }

   @ParameterizedTest
   @MethodSource("argsZero")
    public void lessThanOneValues(BigDecimal amount) {
       assertEquals(amount.multiply(BigDecimal.valueOf(1.1)), tipService.roundTips(amount));

    }
    static Stream<BigDecimal> argsZero() {
        return Stream.of(BigDecimal.valueOf(0),BigDecimal.valueOf(-100),BigDecimal.valueOf(-1000));
    }










}
