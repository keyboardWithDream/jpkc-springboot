package com.study.jpkc.service;

import com.study.jpkc.entity.School;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isharlan.hu@gmail.com
 * @since 2020-12-18
 */
public interface ISchoolService extends IService<School> {

    /**
     * 通过教师id获取学校
     * @param teacherId 教师id
     * @return 学校信息
     */
    School getByTeacherId(String teacherId);

    /**
     * 通过课程id获取学校
     * @param courseId 课程id
     * @return 学校信息
     */
    School getByCourseId(String courseId);
}
