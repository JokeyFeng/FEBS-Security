package cc.mrbird.system.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.system.domain.MyUser;
import cc.mrbird.system.domain.UserWithRole;

import java.util.List;

/**
 * @author yiheni
 */
public interface UserMapper extends MyMapper<MyUser> {
    /**
     * 查找用户
     *
     * @param user
     * @return
     */
    List<MyUser> findUserWithDept(MyUser user);

    /**
     * 查找角色用户
     *
     * @param userId
     * @return
     */
    List<UserWithRole> findUserWithRole(Long userId);

    /**
     * 查找用户权限
     *
     * @param user
     * @return
     */
    MyUser findUserProfile(MyUser user);
}