import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        EventQueue.invokeAndWait(new Runnable() {
            public void run() {
                Frame frame = new Frame();
            }
        });
    }
}
