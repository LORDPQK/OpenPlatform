package pqk.project1.openapi.web.master.mapper;

import pqk.project1.openapi.web.master.pojo.AppInfo;

import java.util.List;

public interface AppInfoMapper {
    void insertAppInfo(AppInfo appInfo);

    void updateAppInfo(AppInfo appInfo);

    AppInfo getAppInfoById(Long id);

    List<AppInfo> getAllAppinfos();

    void deleteAppInfoById(Long id);

    void deleteAppInfoByIds(Long[] id);
}
