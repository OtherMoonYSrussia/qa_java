import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Feline;


@ExtendWith(MockitoExtension.class)
public class FelineTest {
    

    @Test
    public void eatMeetReturnMeetFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expected, actualResult);
    }

    @Test
    public void getFamilyReturnCatsFamily() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily());
    }

   @Test
    public void getKittensReturnBasicParam() {
        Feline feline = new Feline();
        int expected = 1;
        assertEquals(expected, feline.getKittens());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "5, 5",
        "10, 10"
    })
    public void getKittensWithParams(int input, int expected) {
        Feline feline = new Feline();
        int actual = feline.getKittens(input);
        assertEquals(expected, actual);
    }
}
