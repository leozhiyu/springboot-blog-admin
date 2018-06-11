/**
 * @author:Leo
 * @create 2018/6/11
 * @desc
 */
package com.blog.responsitory;

import com.blog.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoticeRepository extends JpaRepository<Notice, Long>, JpaSpecificationExecutor<Notice> {
}
