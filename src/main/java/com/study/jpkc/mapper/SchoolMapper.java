package com.study.jpkc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.jpkc.entity.School;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author isharlan.hu@gmail.com
 * @since 2020-12-18
 */
@Mapper
public interface SchoolMapper extends BaseMapper<School> {

    /**
     * 通过教师id查询学校信息
     * @param teacherId 教师id
     * @return 学校信息
     */
    School selectByTeacerId(String teacherId);
}
