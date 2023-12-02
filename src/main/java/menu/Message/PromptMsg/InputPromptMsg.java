package menu.Message.PromptMsg;

public enum InputPromptMsg {
    PROGRAM_START_NOTICE("점심 메뉴 추천을 시작합니다."),
    ASK_INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    ASK_INPUT_UNAVAILABLE_MENU_FOR_COACH("%s(이)가 못 먹는 메뉴를 입력해 주세요.");

    private String message;

    InputPromptMsg(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
