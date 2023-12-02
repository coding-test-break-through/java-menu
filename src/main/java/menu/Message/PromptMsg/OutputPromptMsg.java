package menu.Message.PromptMsg;

public enum OutputPromptMsg {

    RECOMMEND_RESULT_NOTICE("메뉴 추천 결과입니다."),
    DAY_CATEGORY_NOTICE("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
    RESULT_NOTICE_START("[ "),
    RESULT_NOTICE_END(" ]"),
    CATEGORY_NOTICE("카테고리"),
    SPLIT_DELIMITER(" | "),
    RECOMMEND_OVER_NOTICE("추천을 완료했습니다.");

    private String message;

    OutputPromptMsg(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
