package cn.totoro.controller;

import cn.totoro.annotation.TokenAccess;
import cn.totoro.entity.Job;
import cn.totoro.handler.ApiResult;
import cn.totoro.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/jobs")
@Controller
@TokenAccess
public class JobController {


    @Autowired
    private JobServiceImpl jobService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ApiResult getAllJob(){
        List<Job> allJob = jobService.getAllJob();
        if(allJob!=null){
            return ApiResult.success("获取所有岗位成功",allJob);
        }
        return ApiResult.fail("fail","获取岗位失败");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ApiResult addJob(@Valid Job job, BindingResult result){
        if(result.getErrorCount()>=1){
            return  ApiResult.fail("fail",result.getAllErrors().get(0).getDefaultMessage());
        }
        boolean isInsert = jobService.addJob(job);
        if(isInsert){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"新增岗位成功",job);
        }
        return  ApiResult.fail("fail","新增岗位失败，请检查数据是否合法");
    }


    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ApiResult updateJob(@PathVariable("id")Integer id, Job job){
        job.setId(id);
        boolean isUpdate = jobService.updateJob(job);
        if(isUpdate){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"岗位信息更新成功",job);
        }
        return  ApiResult.fail("fail","更新失败，ID错误或数据未更新");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ApiResult deleteJob(@PathVariable("id") Integer id){
        boolean isDelete = jobService.deleteJobById(id);
        if(isDelete){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"岗位删除成功");
        }
        return  ApiResult.fail("fail","删除失败，用户或不存在");
    }

}
