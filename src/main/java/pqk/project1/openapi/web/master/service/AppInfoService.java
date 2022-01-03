package pqk.project1.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import pqk.project1.openapi.web.master.pojo.AppInfo;

import java.util.List;

public interface AppInfoService {
    void insertAppInfo(AppInfo appInfo);

    void updateAppInfo(AppInfo appInfo);

    AppInfo getAppInfoById(Long id);

    List<AppInfo> getAllAppinfos();

    void deleteAppInfoById(Long id);

    void deleteAppInfoByIds(Long[] id);

    PageInfo<AppInfo> getAllAppinfsByPage(int page, int limit);

}
