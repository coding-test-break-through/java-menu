package menu.Message.Exceptions;

public enum UnavailableFoodErrMsg {
    ASK_BELOW_TWO("최대 2개 까지 입력 가능합니다."),
    ASK_VALID_FORMAT("특수 문자 및 숫자는 입력 불가 합니다. 쉼표로 구분된 영어 혹은 한글로만 이루어진 이름들을 적어주세요"),
    ASK_NO_DUPLICATION("중복된 메뉴는 입력 불가합니다"),
    ASK_FOOD_WHICH_IS_IN_MENU("메뉴에 없는 음식을 입력하였습니다. 다시 입력해주세요");;

    private String message;

    UnavailableFoodErrMsg(String message) {
        this.message = ExceptionPrefix.ERROR_PREFIX.getMessage() + message;
    }

    public String getMessage() {
        return message;
    }
}
