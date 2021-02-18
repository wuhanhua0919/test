package com.ksq.service.dao.mapper;

import com.ksq.core.entity.SysOrgUser;
import com.ksq.core.entity.SysOrgUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrgUserMapper {
    int countByExample(SysOrgUserExample example);

    int deleteByExample(SysOrgUserExample example);

    int deleteByPrimaryKey(Integer orgUserId);

    int insert(SysOrgUser record);

    int insertSelective(SysOrgUser record);

    List<SysOrgUser> selectByExample(SysOrgUserExample example);

    SysOrgUser selectByPrimaryKey(Integer orgUserId);

    int updateByExampleSelective(@Param("record") SysOrgUser record, @Param("example") SysOrgUserExample example);

    int updateByExample(@Param("record") SysOrgUser record, @Param("example") SysOrgUserExample example);

    int updateByPrimaryKeySelective(SysOrgUser record);

    int updateByPrimaryKey(SysOrgUser record);
}