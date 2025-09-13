import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.AlexLion;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlexLionTest {
    @Mock
    Feline felineTest;

    @Test
    public void getFriendListReturnListOfHisFriend() throws Exception {
        AlexLion alexLionTest = new AlexLion(felineTest);
        List<String> expected = List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
        assertEquals(expected, alexLionTest.getFriendList());
    }

    @Test
    public void getPlaceOfLivingMustReturnLivingPlace() throws Exception {
        AlexLion alexLionTest = new AlexLion(felineTest);
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, alexLionTest.getPlaceOfLiving());
    }

    @Test
    public void getKittensMustBeZero() throws Exception {
        AlexLion alexLionTest = new AlexLion(felineTest);
        int expected = 0;
        assertEquals(expected, alexLionTest.getKittens());
    }
}