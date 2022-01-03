package pqk.project1.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pqk.project1.openapi.web.master.bean.AjaxMessage;
import pqk.project1.openapi.web.master.bean.TableData;
import pqk.project1.openapi.web.master.pojo.AppInfo;
import pqk.project1.openapi.web.master.service.AppInfoService;

@RestController
@RequestMapping("/sys/appinfo")
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;

    @PostMapping("/add")
    public AjaxMessage addAppinfo(AppInfo appInfo){
        try{
            appInfoService.insertAppInfo(appInfo);
            return new AjaxMessage(true,"添加成功");
        }catch (Exception e){
            return new AjaxMessage(false,"添加失败");
        }
    }

    @PostMapping("/update")
    public AjaxMessage updateAppinfo(AppInfo appInfo){
        try{
            appInfoService.updateAppInfo(appInfo);
            return new AjaxMessage(true,"更新成功");
        }catch (Exception e){
            return new AjaxMessage(false,"更新失败");
        }
    }

    @RequestMapping("/table")
    public TableData<AppInfo> getAppInfosByPage(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "2") int limit){
        PageInfo<AppInfo> pageInfo = appInfoService.getAllAppinfsByPage(page, limit);
        TableData<AppInfo> tableData = new TableData<AppInfo>();
        tableData.setCount(pageInfo.getTotal());
        tableData.setData(pageInfo.getList());
        tableData.setMsg("查询成功");
        return tableData;
    }

    @PostMapping("/del")
    public AjaxMessage deleteAppinfo(Long[] id){
        if(id!=null && id.length>0){
            appInfoService.deleteAppInfoByIds(id);
            return new AjaxMessage(true,"删除成功");
        }
        return  new AjaxMessage(false,"删除失败");
    }
}
