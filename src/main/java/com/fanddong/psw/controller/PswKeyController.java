package com.fanddong.psw.controller;

import com.fanddong.psw.entity.PublicKey;
import com.fanddong.psw.entity.Pswkey;
import com.fanddong.psw.repository.PswkeyRespository;
import com.fanddong.psw.repository.StyleRespoitory;
import com.fanddong.psw.util.QuickSDKDesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/pswkey")
public class PswKeyController {
    @Autowired
    private PswkeyRespository pswkeyRespository;
    @Autowired
    private StyleRespoitory styleRespoitory;

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(Pswkey pswkey) {
        System.out.println(pswkey.toString());

        try {
            //加密存储密码
            String encodePsw = QuickSDKDesUtil.encode(pswkey.getPsw(), PublicKey.getPswKey());
            pswkey.setPsw(encodePsw);
            if(pswkey != null) {
                pswkeyRespository.save(pswkey);
                return "保存成功！";
            }
            return "保存失败！";
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！";
        }

    }

    /**
     * 展示密码本列表
     */
    @GetMapping(value = "/list")
    public String list(Model model) {
        List<Pswkey> pswkeys = pswkeyRespository.findAll();
        for(Pswkey pswkey : pswkeys) {
            pswkey.setPsw(QuickSDKDesUtil.decode(pswkey.getPsw(), PublicKey.getPswKey()));
        }
        model.addAttribute("pswkeys", pswkeys);
        return "/pswkeys";
    }

    /**
     * 搜索密码本
     * @param cont 搜索关键词
     */
    @GetMapping(value = "/search/{cont}")
    @ResponseBody
    public List<Pswkey> search(@PathVariable String cont) {
        List<Pswkey> pswkeys = pswkeyRespository.findByKeyword(cont);
        for(Pswkey pswkey : pswkeys) {
            pswkey.setPsw(QuickSDKDesUtil.decode(pswkey.getPsw(), PublicKey.getPswKey()));
        }
        return pswkeys;
    }
}
