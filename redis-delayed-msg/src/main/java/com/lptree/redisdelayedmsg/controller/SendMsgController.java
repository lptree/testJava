package com.lptree.redisdelayedmsg.controller;

import com.lptree.redisdelayedmsg.service.SendMsgService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2019/3/17 22:31
 */
@RestController("send")
@Api(description = "值机服务api")
class SendMsgController {

    @Autowired
    private SendMsgService sendMsgService;

    /**
     * @Description: 获取当前旅客的所有行程
     * @Param: [request, validResult]
     * @return: com.juneyaoair.common.dto.base.BaseOpenApiResultDTO<com.juneyaoair.cuss.dto.booking.response.checkin.DetrResponseDTO>
     * @Author: lp
     * @Date: 2018/12/3 13:10
     */
    @PostMapping(value = "/one")
    public String one(@RequestBody String msg) {
        return sendMsgService.one(msg);
    }
}
