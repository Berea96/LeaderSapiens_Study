package com.leadersapiens.study.march.parserTest.bean.baseball;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LiveBaseGame {
    private int gidx = 0; //게임ID
    private String gtype = ""; //게임타입
    private String gdate = ""; //게임일자
    private String gtime = ""; //게임시간
    private String home_tid = ""; //데이타센터홈팀ID
    private String away_tid = ""; //데이타센터원정팀ID
    private String gameidx = ""; //파싱게임코드
    private String view_live = ""; //라이브 노출여부
    private String refer_idx = ""; //파싱게임코드
    private String refer_type = ""; //파싱대상 사이트명
    private String league_id = ""; //리그ID
    private String game_name = ""; //게임명
    private String league_name = ""; //리그명
    private String home_name = ""; //홈팀명
    private String away_name = ""; //원정팀명
    private String start_datetime = ""; //게임시작시간
    private String home_score = ""; //홈팀점수
    private String away_score = ""; //원정팀점수
    private String media_link = ""; //중계정보
    private String league_type = ""; //세부리그타입
    private String gstatus = ""; //게임상태
    private String gresult = ""; //게임결과
    private String color = ""; //색상표
    private String home_rank = ""; //홈팀랭크,조
    private String away_rank = ""; //어웨이팀랭크,조
    private String is_update = ""; //업데이트여부(N-없음,Y-업데이트)
    private String is_view = ""; //경기노출여부 Y:노출, N:노출안함
    private String byhand = "N"; //수동중계여부. 수동:Y,자동:N
    private String reg_datetime = ""; //등록일자(임시)
    private String update_datetime = ""; //수정일시
    private String json_data = ""; //라이브경기에 대한 full data
    private String target_site = ""; //parsing 대상 사이트 구분자
    private String is_betting = ""; //parsing 배팅가능 여부 구분자
}
