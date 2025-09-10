import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Feline;
import com.example.Lion;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline felineTest;

    @Test
    public void hasManeMustBeTrue() throws Exception {
        Lion lionTest = new Lion("Самец", felineTest);
        assertTrue(lionTest.doesHaveMane());
    }

    @Test
    public void hasManeMustBeFalse() throws Exception {
        Lion lionTest = new Lion("Самка", felineTest);
        assertFalse(lionTest.doesHaveMane());
    }
    
    @Test
    public void hasManeMustBeException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("НеведомаяСущность", felineTest));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnBasicParam() throws Exception {
        Mockito.when(felineTest.getKittens()).thenReturn(1);
        Lion lionTest = new Lion("Самец", felineTest);
        int expected = 1;
        assertEquals(expected, lionTest.getKittens());
    }

    @Test
    public void getFoodReturnListOfMeet() throws Exception {
        Lion lionTest = new Lion("Самец", felineTest);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineTest.getFood("Хищник")).thenReturn(expected);
        assertEquals(expected, lionTest.getFood());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "самец", "САМЕЦ", "самка", " ", "000"})
    void constructor_shouldThrowException_forInvalidInputs(String invalidInput) {
        assertThrows(Exception.class, () -> new Lion(invalidInput, felineTest),
                "Должно выбрасываться исключение для значения: " + invalidInput);
    }
}