import java.util.ArrayList;
import java.util.List;

public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> alive = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            byte[] garbage = new byte[1024 * 1024];// 1 мб сразу в помойку
            if (i % 10 == 0) {
                alive.add(new byte[1024 * 1024]);// 1 мб живой
            }
            Thread.sleep(100);//чтобы успеть посмотреть на график
        }
    }
}
