package vip.ipav.dubbo.service;

import java.util.List;

public interface DemoService {
    List<String> getPermissions(Long id);
}
