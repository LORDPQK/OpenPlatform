package pqk.project1.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pqk.project1.openapi.web.master.mapper.AppInfoMapper;
import pqk.project1.openapi.web.master.pojo.AppInfo;
import pqk.project1.openapi.web.master.service.AppInfoService;

import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public void insertAppInfo(AppInfo appInfo) {
        appInfoMapper.insertAppInfo(appInfo);
    }

    @Override
    public void updateAppInfo(AppInfo appInfo) {
        if(appInfo !=null){
            appInfoMapper.updateAppInfo(appInfo);
        }
    }

    @Override
    public AppInfo getAppInfoById(Long id) {
        return appInfoMapper.getAppInfoById(id);
    }

    @Override
    public List<AppInfo> getAllAppinfos() {
        return appInfoMapper.getAllAppinfos();
    }

    @Override
    public void deleteAppInfoById(Long id) {
        appInfoMapper.deleteAppInfoById(id);
    }

    @Override
    public void deleteAppInfoByIds(Long[] id) {
        appInfoMapper.deleteAppInfoByIds(id);
    }

    @Override
    public PageInfo<AppInfo> getAllAppinfsByPage(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<AppInfo> appInfoList = appInfoMapper.getAllAppinfos();
        return new PageInfo<AppInfo>(appInfoList);
    }
}
