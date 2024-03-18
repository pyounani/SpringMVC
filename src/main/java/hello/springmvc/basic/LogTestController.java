package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {
    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        log.info("name = {}", name);
        return "ok";
    }
}
