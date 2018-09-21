package com.internetsaying.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.internetsaying.post.dto.AreaReceiveNum;
import com.internetsaying.post.entity.ThrowPot;
import com.internetsaying.post.entity.ThrowPotDetail;

@Repository
public interface ThrowPotDAO {

	ThrowPot getThrowPotByArea(@Param("areaId") int areaId);
	
	List<AreaReceiveNum> getReceiveDetail(@Param("areaId") int areaId, @Param("giftId") int giftId);
	
	int addThrowPotDetail(ThrowPotDetail detail);
	
	List<ThrowPotDetail> getDetailListByArea(@Param("areaId") int areaId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
}
