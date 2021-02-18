package com.learning.springcloud.websocket.controller;

import com.learning.springcloud.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lifang
 * @since 2021/2/18
 */
@RestController
public class WebSocketController {

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        System.out.println("--------------------------------------------------------------------------------");
        WebSocketServer.sendInfo(message,toUserId);
        sendMsg(toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

    private void sendMsg(String toUserId) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int index = 1;
                    do {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("index: " + index);
                        index++;
                    }while (index < 10);

                    WebSocketServer.sendInfo("hello web-socket!!!", toUserId);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
