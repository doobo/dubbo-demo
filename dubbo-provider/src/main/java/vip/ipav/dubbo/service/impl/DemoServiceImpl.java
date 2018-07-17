package vip.ipav.dubbo.service.impl;

import vip.ipav.dubbo.service.DemoService;
import java.util.ArrayList;
import java.util.List;


public class DemoServiceImpl implements DemoService {
    public List<String> getPermissions(Long id) {
        List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d", id - 1));
        demo.add(String.format("Permission_%d", id));
        demo.add(String.format("Permission_%d", id + 1));
        return demo;
    }
}
