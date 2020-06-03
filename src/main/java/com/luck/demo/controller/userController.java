package com.luck.demo.controller;

import com.luck.demo.entity.UserInfo;
import com.luck.demo.utils.*;
import com.luck.demo.entity.user;
import com.luck.demo.service.UserServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Api(tags = "userController", description = "关于用户的controller")
@Controller
public class userController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private userUtils userUtils;
    @Autowired
    private RabbitMQsend rabbitMQsend;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MQSender mqSender;


    /**
     * @Description: 登录成功跳转到主页面
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/11
     */
    @ApiOperation("登录成功跳转到主页面")
    @RequestMapping("/index")
    public ModelAndView Index(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //主体名，即登录用户名
        mv.addObject("username", name);
        mv.setViewName("index");
        return mv;

    }

    @ApiOperation("不登录跳转到主界面")
    @RequestMapping("/")
    public ModelAndView unLogin(HttpSession session) {
        ModelAndView mv = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //主体名，即登录用户名
//        mv.addObject("username", name);
        mv.setViewName("index");
        return mv;

    }


    /**
     * @Description: 跳转到登录界面
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/11
     */
    @ApiOperation("跳转到登录界面")
    @RequestMapping("/login")
    public String login() {

        return "login";

    }


    /**
     * @Description: 跳转到注册界面
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/16
     */
    @ApiOperation("跳转到注册界面")
    @RequestMapping("/register")
    public String register() {

        return "register";
    }


    /**
     * @Description: 跳转到member-list
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/16
     */
    @ApiOperation("跳转到member-list")
    @RequestMapping("/member-list")
    public String memberlist() {

        return "member-list";
    }

    /**
     * @Description: 跳转到member-list1
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/16
     */
    @ApiOperation("跳转到member-list1")
    @RequestMapping("/member-list1")
    public String memberlist1() {

        return "member-list1";
    }


    /**
     * @Description: 用户注册逻辑
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/16
     */
    @ApiOperation("用户注册")
    @RequestMapping("/userRegister")
    public ModelAndView userRegister(user user) throws Exception {
        ModelAndView mv = new ModelAndView();
        try {
            Integer i = userServices.userRegister(user);
            if (i == 1) {
                mv.setViewName("login");
            } else {
                mv.setViewName("register");
            }
        } catch (Exception e) {
            mv.setViewName("register");
        }


        return mv;


    }

    /**
     * @Description: 根据输入的用户名判断用户是否已存在
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/16
     */
    @ApiOperation("根据输入的用户名判断用户是否已存在")
    @ResponseBody
    @PostMapping("/checkUsername")
    public CommonResult<String> checkUsername(@RequestParam("username") String username) {

        user user = userServices.checkUsername(username);
        if (user == null) {
            return CommonResult.success("用户不存在，可以注册");
        } else {
            return CommonResult.failed("用户已存在");
        }

    }


    /**
     * @Description: 跳转到登录失败界面
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/13
     */
    @ApiOperation("跳转到登录失败界面")
    @RequestMapping("/login-error")
    public ModelAndView loginerror() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("loginStatus", true);
        mv.setViewName("login");
        return mv;

    }


    /**
     * @Description: 跳转到欢迎界面
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/13
     */
    @ApiOperation("跳转到欢迎界面")
    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;

    }

    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/26
     */
    @ResponseBody
    @RequestMapping("/queryInfo")
    public CommonResult<List<user>> queryUser(user user) {

        List<com.luck.demo.entity.user> list = userServices.queryUser(user);
        if (!list.isEmpty()) {
            return CommonResult.success(list);
        } else {
            return CommonResult.failed("未查询到相关用户");
        }
    }
//
//    /**
//     * @Description: 登录逻辑
//     * @Param:
//     * @return:
//     * @Author: bo.yan
//     * @date: 2019/12/11
//     */
//
//    @RequestMapping("/loginByUser")
//    public String loginByUser(user user) {
//
//        int i = userServices.login(user);
//        if (i == 1) {
//            return "index";
//        } else {
//
//            return "login";
//        }
//
//
//    }

    /**
     * @Description: 测试接口
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/24
     */
    @ResponseBody
    @ApiOperation("测试接口")
    @GetMapping("/test")
    public String test() {

//        kafkaProducer.send("晏波");
//        rabbitMQsend.send("direct");
        String msg = "hello spring boot";
        try {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //mqSender.send(msg + ":" + i, null);
                mqSender.send("123", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        user user = new user();
//        user.setUsername("123");
//        user.setPassword("123");
//        user.setAge("123");
//        ArrayList<user> list = new ArrayList<user>();
//        long l = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//
//            list.add(user);
//        }
//        userServices.testInsert(list);
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1 - l);
//        userServices.test(ids);
        return null;
    }


    /**
     * @Description: 测试RabbitMQ
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/26
     */

    @ResponseBody
    @RequestMapping("/testRabbitMq")
    public CommonResult<String> testRabbitMq() {


        try {
            rabbitMQsend.send("luck_one");
            return CommonResult.success("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("发送失败");
        }

    }

//    @Scheduled(fixedRate = 2000)
//    public void testScheduled() {
//        System.out.println("测试定时任务"+System.currentTimeMillis());
//    }


//    @RequestMapping("/testone")
//    @ResponseBody
//    public HashMap<Object, Object> testone(HttpServletRequest request, @RequestBody() String userinfo) {
//        String[] split = userinfo.split("&userid=");
//        String userid = split[1];
////        2122383730839795
//        String apiSecret = "luckone.";
//        Long ts = Long.valueOf(getHeadersInfo().get("x-ddpaas-signature-timestamp"));
//        String signature = getHeadersInfo().get("x-ddpaas-signature");
//        String access_token = null;
//        JSONObject jsonObject = new JSONObject();
////        signature="79fa58087fd43aeb93b99794480fc8ca";
////        获取access_token;
//        try {
//            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
//            OapiGettokenRequest req = new OapiGettokenRequest();
//            req.setAppkey("ding6gfaqv0danb8zwvl");
//            req.setAppsecret("3UuzbyFEDj5WMf4N1mlCvnXs4JzMJwKRtIT7b3j5kLvyGtyBt1a_lQV4F3QvbkCg");
//            req.setHttpMethod("GET");
//            OapiGettokenResponse rsp = client.execute(req);
//            String body = rsp.getBody();
//            JSONObject bodyJson = jsonObject.parseObject(body);
//            access_token = bodyJson.get("access_token").toString();
//
//            System.out.println(rsp.getBody());
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
////        String access_token = calcSignature(signature, ts);
////        获取待办任务
//        try {
//            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/workrecord/getbyuserid");
//            OapiWorkrecordGetbyuseridRequest req = new OapiWorkrecordGetbyuseridRequest();
//            req.setUserid(userid);
//            req.setOffset(1L);
//            req.setLimit(1L);
//            req.setStatus(1L);
//            OapiWorkrecordGetbyuseridResponse rsp = client.execute(req, access_token);
//            String body = rsp.getBody();
//            JSONObject jsonBody = jsonObject.parseObject(body);
//            JSONObject listJsonObject = (JSONObject) jsonBody.getJSONObject("records").getJSONArray("list").get(0);
//            JSONObject contentobject = (JSONObject) ((JSONObject) jsonBody.getJSONObject("records").getJSONArray("list").get(0)).getJSONArray("forms").get(0);
//            String content = contentobject.getString("content");
//            String title = listJsonObject.get("title").toString();
//            String url = listJsonObject.get("url").toString();
//            String create_time = listJsonObject.get("create_time").toString();
//            HashMap<Object, Object> map = new HashMap<>();
//            map.put("content", content);
//            map.put("title", title);
//            map.put("url", url);
//            map.put("create_time", create_time);
//            return map;
//
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
//
//        HashMap<Object, Object> errorMap = new HashMap<>();
//        errorMap.put("status", "接口调用失败");
//        return errorMap;
//    }


    public static String calcSignature(String apiSecret, long ts) {
        try {
            Mac mac = null;
            try {
                mac = Mac.getInstance("HmacSHA256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            SecretKeySpec key = new SecretKeySpec(apiSecret.getBytes(), "HmacSHA256");
            try {
                mac.init(key);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            return Base64.getEncoder().encodeToString(mac.doFinal(Long.toString(ts).getBytes()));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Map<String, String> getHeadersInfo() {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}