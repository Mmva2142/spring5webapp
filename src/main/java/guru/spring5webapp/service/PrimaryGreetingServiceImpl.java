package guru.spring5webapp.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by shifengyuan.
 * Date: 2018/6/23
 * Time: 12:25
 */

// 多个Impl实现同一接口时，MyController中的GreetingService会报错，解决方法：
// 1. @Service("xxx")然后在引用的时候private GreetingService xxx;
// 2. @Autowired @qualifier("") 或者@Resource(name = "")
// 3. 用@Profile("")，在application.properties中去选择用哪个，来避免冲突
// 4. 尽量不要用@primary

@Service
@Profile("en")
public class PrimaryGreetingServiceImpl implements GreetingService {
    @Override
    public void greeting() {
        System.out.println("=========== hello ----- PrimaryGreetingServiceImpl =============");
    }
}
