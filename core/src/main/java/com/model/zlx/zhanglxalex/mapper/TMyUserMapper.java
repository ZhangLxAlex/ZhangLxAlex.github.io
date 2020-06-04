package com.model.zlx.zhanglxalex.mapper;

import com.model.zlx.zhanglxalex.entity.TMyUserEntity;

import java.util.List;

/**
 * @author zhang_lx
 * @title TMyUserMapper
 * @date 20200602 14:02:03
 */
public interface TMyUserMapper {

    /**
     * 根据条件查询
     *
     * @param tMyUserEntity
     * @return
     * @author zhang_lx
     * @date 20200602 14:02:03
     */
    List<TMyUserMapper> findByCondition(TMyUserEntity tMyUserEntity);


}