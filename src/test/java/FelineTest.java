import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Feline;


@ExtendWith(MockitoExtension.class)
public class FelineTest {
    
    @Mock
    Feline felineTest;

    @Test
    public void eatMeetReturnMeetFoodList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineTest.eatMeat()).thenReturn(expected);
        List<String> actualResult = felineTest.eatMeat();
        assertEquals(expected, actualResult);
    }

    @Test
    public void getFamilyReturnCatsFamily() {
        String expected = "Кошачий";
        Mockito.when(felineTest.getFamily()).thenReturn(expected);
        assertEquals(expected, felineTest.getFamily());
    }

    @Test
    public void getKittensReturnBasicParam() {
        int expected = 1;
        Mockito.when(felineTest.getKittens()).thenReturn(expected);
        assertEquals(expected, felineTest.getKittens());
    }


    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "7, 7",
        "25, 25"
    })
    public void getKittensIsUsed(int inputedNumber, int expected) {
        Mockito.when(felineTest.getKittens(inputedNumber)).thenReturn(expected);
        int actual = felineTest.getKittens(inputedNumber);
        assertEquals(expected, actual);
        Mockito.verify(felineTest).getKittens(inputedNumber);
    }
}
