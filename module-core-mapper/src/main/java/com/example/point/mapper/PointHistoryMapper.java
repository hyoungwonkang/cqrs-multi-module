package com.example.point.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.point.dto.PointHistoryDto;


@Mapper
public interface PointHistoryMapper {
  /**
   * 특정 회원의 포인트 이력을 조회합니다.
   * 실제 쿼리는 resources/mapper/PointHistoryMapper.xml에 정의되어 있습니다.
   *
   * @param memberId 조회할 회원의 ID
   * @return 포인트 이력 리스트
   */
  List<PointHistoryDto> findPointHistoryByMemberId(Long memberId);
}
