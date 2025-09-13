import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Cat;
import com.example.Feline;



@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline felineTest;


    @Test
    public void getSoundReturnCorrectSound() {
        Cat catTest = new Cat(felineTest);
        String expected = "Мяу";
        assertEquals(expected, catTest.getSound());
    }

    @Test
    public void getFoodReturnListOfMeet() throws Exception {
        Cat catTest = new Cat(felineTest);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineTest.eatMeat()).thenReturn(expected);
        assertEquals(expected, catTest.getFood());
    }
}
