package cn.day1.utils;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SubjectUtil {

    @Autowired
    private TokenUtil tokenUtil;

    public Integer getSubjectId() {

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("该用户未登录");
        }
        return 1;
    }

}
