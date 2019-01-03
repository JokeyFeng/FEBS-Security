package cc.mrbird.system.service;

import cc.mrbird.common.domain.Tree;
import cc.mrbird.common.service.IService;
import cc.mrbird.system.domain.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * @author yiheni
 */
@CacheConfig(cacheNames = "MenuService")
public interface MenuService extends IService<Menu> {
    /**
     * 获取用户权限
     *
     * @param userName
     * @return
     */
    String findUserPermissions(String userName);

    /**
     * 获取用户资源菜单
     *
     * @param userName
     * @return
     */
    List<Menu> findUserMenus(String userName);

    /**
     * 获取所有菜单
     *
     * @param menu
     * @return
     */
    List<Menu> findAllMenus(Menu menu);

    /**
     * 获取菜单按钮树
     *
     * @return
     */
    Tree<Menu> getMenuButtonTree();

    /**
     * 获取菜单树
     *
     * @return
     */
    Tree<Menu> getMenuTree();

    /**
     * 获取用户菜单
     *
     * @param userName
     * @return
     */
    Tree<Menu> getUserMenu(String userName);

    /**
     * 查找菜单
     *
     * @param menuId
     * @return
     */
    Menu findById(Long menuId);

    /**
     * 查找菜单
     *
     * @param menuName
     * @param type
     * @return
     */
    Menu findByNameAndType(String menuName, String type);

    /**
     * 增加菜单
     *
     * @param menu
     */
    void addMenu(Menu menu);

    /**
     * 更新菜单
     *
     * @param menu
     */
    void updateMenu(Menu menu);

    /**
     * 删除菜单
     *
     * @param menuIds
     */
    void deleteMeuns(String menuIds);

    /**
     * 获取所有url
     *
     * @param p1
     * @return
     */
    @Cacheable(key = "'url_'+ #p0")
    List<Map<String, String>> getAllUrl(String p1);

}
