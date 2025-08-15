import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
        assertEquals(expected, felineTest.eatMeat());
    }

    @Test
    public void getFamilyReturnCatsFamily() throws Exception {
        String expected = "Кошачий";
        Mockito.when(felineTest.getFamily()).thenReturn(expected);
        assertEquals(expected, felineTest.getFamily());
    }

    @Test
    public void getKittensReturnBasicArghument() throws Exception {
        int expected = 1;
        Mockito.when(felineTest.getKittens()).thenReturn(expected);
        assertEquals(expected, felineTest.getKittens());
    }

    @Test
    public void getKittensIsUsed() throws Exception {
        felineTest.getKittens(20);
        Mockito.verify(felineTest).getKittens(20);
    }

    @Test
    public void getKittensWithArghumentsReturnCorrectNumbers() throws Exception {
        int expected = 10;
        Mockito.when(felineTest.getKittens()).thenReturn(expected);
        felineTest.getKittens(10);
        assertEquals(expected, felineTest.getKittens());
    }
}
