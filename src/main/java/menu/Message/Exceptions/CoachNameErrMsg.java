package menu.Message.Exceptions;

public enum CoachNameErrMsg {
    ASK_NO_EMPTY_INPUT("빈칸은 허용되지 않습니다."),
    ASK_NO_WHITE_SPACE("공백 없이 입력해주세요."),
    ASK_MORE_THAN_TWO("코치는 최소 2명 이상 입력해야 합니다."),
    ASK_BELOW_FIVE("코치는 최대 5명까지 입력 가능합니다."),
    ASK_VALID_FORMAT("특수 문자 및 숫자는 입력 불가 합니다. 쉼표로 구분된 영어 혹은 한글로만 이루어진 이름들을 적어주세요"),
    ASK_NAME_BETWEEN_ONE_AND_TWENTY("이름은 1자 이상 20자 이하만 입력 가능합니다."),
    ASK_NO_DUPLICATION("중복된 이름은 입력 불가합니다");

    private String message;

    CoachNameErrMsg(String message) {
        this.message = ExceptionPrefix.ERROR_PREFIX.getMessage() + message;
    }

    public String getMessage() {
        return message;
    }
}
