package git.snippets.vt;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/9/21
 * @since
 */
public class CreateVirtualThreadTest {
    public static void main(String[] args) {
        Thread.startVirtualThread(() -> {
            // code to run in thread
        });

        Thread.ofVirtual().start(() -> {
            // code to run in thread
        });

        Thread.ofPlatform().start(() -> {

        });
    }
}
