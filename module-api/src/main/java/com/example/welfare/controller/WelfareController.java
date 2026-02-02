package com.example.welfare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.welfare.service.WelfareService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class WelfareController {
    
    private final WelfareService welfareService;

    @GetMapping("/{id}/balance")
    public ResponseEntity<String> getBalance(@PathVariable String id) {
        if (id == null || id.isBlank()) {
            return ResponseEntity.badRequest().body("존재하지 않는 회원 ID: " + id);
        }
        Long balance = welfareService.getMemberInfo(Long.parseLong(id)).getBalance();
        return ResponseEntity.ok("잔액: " + balance + "원");
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<?> getPointHistories(@PathVariable String id) {
        if (id == null || id.isBlank()) {
            return ResponseEntity.badRequest().body("존재하지 않는 회원 ID: " + id);
        }
        return ResponseEntity.ok(welfareService.getMemberInfo(Long.parseLong(id)));
    }
}
