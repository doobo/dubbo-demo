package vip.ipav.dubbo.service.impl;

import vip.ipav.dubbo.service.ConfigService;

public class ConfigServiceImpl implements ConfigService {
    @Override
    public String baseConfig() {
        return "This is base config test!";
    }
}
