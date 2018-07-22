package guru.spring5webapp.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by shifengyuan.
 * Date: 2018/6/23
 * Time: 12:22
 */

@Service
@Profile({"zh","default"})
public class GreetingServiceImpl implements GreetingService {
    @Override
    public void greeting() {
        System.out.println("=========== 你好 ---- GreetingServiceImpl ============");
    }
}
