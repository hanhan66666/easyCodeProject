package cn.yunhe.service.impl;

import cn.yunhe.entity.Role;
import cn.yunhe.dao.RoleDao;
import cn.yunhe.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2023-08-16 15:27:41
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return this.roleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param role        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Role> queryByPage(Role role, PageRequest pageRequest) {
        long total = this.roleDao.count(role);
        return new PageImpl<>(this.roleDao.queryAllByLimit(role, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleDao.deleteById(id) > 0;
    }
}
