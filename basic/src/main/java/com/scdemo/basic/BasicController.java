package com.scdemo.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auth weile
 * @Time 2019/12/20 12:53
 * @Description TODO
 **/

@RestController
public class BasicController {

    @RequestMapping("/echo")
    public BasicResp<String> echo(@RequestParam String echo) {

        return new BasicResp<String>("err", 11L, null);
    }

}

@Data
@AllArgsConstructor
class BasicResp<T> {

    private String errMsg;
    private Long errCode;
    private T data;

}
