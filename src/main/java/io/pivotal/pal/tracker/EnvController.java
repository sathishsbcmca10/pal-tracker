package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {


    private final String port;
    private final String memorylimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddr;

    public EnvController(
            @Value("${port:NOT SET}")String port, @Value("${memory.limit:NOT SET}") String memoryLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex, @Value("${cf.instance.addr:NOT SET}")
                    String instAddr) {

        this.port=port;
        this.memorylimit =memoryLimit;
        this.cfInstanceIndex=cfInstanceIndex;
        this.cfInstanceAddr = instAddr;

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {


        Map<String, String> env = new HashMap<>();
        env.put("PORT",port);
        env.put("MEMORY_LIMIT",memorylimit);
        env.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR",cfInstanceAddr);
        return env;
    }
}
