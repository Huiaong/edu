package com.foxconn.lecturer.controller;


import com.foxconn.lecturer.domain.vo.SubjectOneVo;
import com.foxconn.lecturer.service.EduSubjectService;
import com.foxconn.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author zj
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/eduservice")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    @PostMapping("/subject")
    public Result saveSubject(MultipartFile file) {
        eduSubjectService.addSubject(file, eduSubjectService);
        return Result.ok();
    }

    @GetMapping("/subject")
    public Result getSubjects() {
        List<SubjectOneVo> subjects = eduSubjectService.getSubjects();
        return Result.ok().data("subjects", subjects);
    }

}

