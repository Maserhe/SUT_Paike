package cn.day1.service.impl;

import cn.day1.entity.WeixinUser;
import cn.day1.entity.WeixinYxsadmin;
import cn.day1.mapper.WeixinUserMapper;
import cn.day1.mapper.WeixinYxsadminMapper;
import cn.day1.service.WeixinUserService;
import cn.day1.service.WeixinYxsadminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Maserhe
 * @since 2022-03-06
 */
@Service
public class WeixinUserServiceImpl extends ServiceImpl<WeixinUserMapper, WeixinUser> implements WeixinUserService {

    @Autowired
    private WeixinUserMapper userMapper;


    @Autowired
    private WeixinYxsadminMapper yxsadminMapper;

    /**
     * 根据用户 账号 获取用户信息
     * @return
     */
    @Override
    public WeixinUser getUserInfoByAccount(String userAccount) {

        WeixinUser user = userMapper.selectOne(new QueryWrapper<WeixinUser>().eq("USERACCOUNT", userAccount));
        if (user != null) {
            return user;
        }

        WeixinYxsadmin yxsadmin = yxsadminMapper.selectOne(new QueryWrapper<WeixinYxsadmin>().eq("USERACCOUNT", userAccount));
        if (yxsadmin != null) {
            user = new WeixinUser();
            BeanUtils.copyProperties(yxsadmin, user);
            user.setUseraccounttype("3");
        }
        return user;
    }
}
