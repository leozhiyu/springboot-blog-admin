/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 * User 持久化层
 */
package com.blog.responsitory;

import com.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserResponsitory extends JpaRepository<User,Integer> {

    /**
     * 获取 user 表仅有的一条数据，nativeQuery缺省值是 false，改为本地查询，否则会报错
     * todo 具体原因待探究
     * @return
     */
    @Query(value = "select * from tb_user limit 1", nativeQuery = true)
    User getOnlyOneUser();
}
