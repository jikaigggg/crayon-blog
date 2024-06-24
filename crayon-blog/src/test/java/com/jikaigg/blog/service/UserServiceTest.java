package com.jikaigg.blog.service;

import cn.hutool.core.date.DateUtil;
import com.jikaigg.blog.utils.CyRandomUtils;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testRandomName() {
        String name = null;
        long start = DateUtil.current();
        int i = 0;
        while (!"张三".equals(name)) {
            name = CyRandomUtils.randomChineseName();
            i++;
            System.out.println(name);
        }
        long end = DateUtil.current();
        System.out.println("共执行 " + (end - start) + " 毫秒，第" + i + "个名字是‘张三’");
    }

}
