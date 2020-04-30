package gupt.cjh.noteblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class NoteblogApplicationTests {

    @Test
    void contextLoads() {
        for (int i=1;i<=10;i++){
            BCryptPasswordEncoder b  = new BCryptPasswordEncoder();
            System.out.println(b.encode("123"));
        }
    }

}
