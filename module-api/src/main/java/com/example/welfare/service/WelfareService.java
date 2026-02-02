package com.example.welfare.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import com.example.point.dto.PointHistoryDto;
import com.example.point.mapper.PointHistoryMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WelfareService {
    private final MemberRepository memberRepository;
    private final PointHistoryMapper pointHistoryMapper;

    @Transactional(readOnly = true)
    public Member getMemberInfo(@NonNull Long memberId) {
        return memberRepository.findById(memberId)
        .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Transactional(readOnly = true)
    public List<PointHistoryDto> getPointHistory(Long memberId) {
        return pointHistoryMapper.findPointHistoryByMemberId(memberId);
    }
}
