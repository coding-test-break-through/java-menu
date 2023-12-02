package menu.View.OutputView;

import static menu.Message.PromptMsg.OutputPromptMsg.CATEGORY_NOTICE;
import static menu.Message.PromptMsg.OutputPromptMsg.DAY_CATEGORY_NOTICE;
import static menu.Message.PromptMsg.OutputPromptMsg.RECOMMEND_OVER_NOTICE;
import static menu.Message.PromptMsg.OutputPromptMsg.RECOMMEND_RESULT_NOTICE;
import static menu.Message.PromptMsg.OutputPromptMsg.RESULT_NOTICE_END;
import static menu.Message.PromptMsg.OutputPromptMsg.RESULT_NOTICE_START;
import static menu.Message.PromptMsg.OutputPromptMsg.SPLIT_DELIMITER;

import menu.Model.Coach;
import menu.Model.Coaches;

public class OutputView {

    public OutputView(){
        System.out.println(RECOMMEND_RESULT_NOTICE.getMessage());
        System.out.println(DAY_CATEGORY_NOTICE.getMessage());
    }

    public void printRecommendedCategory(Coaches coaches){
        System.out.println(
                RESULT_NOTICE_START.getMessage()
                        + CATEGORY_NOTICE.getMessage()
                        + SPLIT_DELIMITER.getMessage()
                + String.join(SPLIT_DELIMITER.getMessage(), coaches.getCategoryMemo())
                + RESULT_NOTICE_END.getMessage()
        );
    }

    public void printRecommendResult(Coaches coaches){
        for(Coach coach: coaches.getCoaches()){
            System.out.println(
                    RESULT_NOTICE_START.getMessage()
                    + coach.getName()
                            + SPLIT_DELIMITER.getMessage()
                    + String.join(SPLIT_DELIMITER.getMessage(), coach.getRecommendedFoods())
                    + RESULT_NOTICE_END.getMessage()
            );
        }
    }

    public void printRecommendEnd(){
        System.out.println(RECOMMEND_OVER_NOTICE.getMessage());
    }
}
