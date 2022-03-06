package cn.day1.service.impl;

import cn.day1.entity.WeixinUser;
import cn.day1.mapper.WeixinUserMapper;
import cn.day1.service.WeixinUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
