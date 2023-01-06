package com.ddk.ramenlab.data

import com.ddk.ramenlab.model.Board

object AnnounceBoardData {
    val newBoard: List<Board> = listOf(
        Board("공지사항", "공지사항 입니다.", chatCount = 99),
        Board("게시판 이용 규정", "게시판 이용 규정입니다.", chatCount = 99),
        Board("제재 명단", "이번달 제재 명단", chatCount = 99),
        Board("이달의 우수 회원!", "이달의 우수 회원 선정!", chatCount = 99),
    )
}