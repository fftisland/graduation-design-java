package ZzzAhu163.base.article;

import ZzzAhu163.base.ContactGroup.EntityContactGroup;
import ZzzAhu163.base.user.User;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author Zzz_Ahu_163
 * 文章链接实体类
 * **/
@Alias("Article")
@Data
public class Article extends EntityContactGroup {
    /**文章链接**/
    private String articleUrl;

    /**原文作者**/
    private String authorName;

    /**链接提交人**/
    private User applyUser;

    /**平均分数**/
    private double avgScore;

    /**链接浏览次数**/
    private int viewNum;

    public Article() {
        super();
    }

    public void reset() {
        super.reset();
        articleUrl = null;
        authorName = null;
        applyUser = null;
        avgScore = 0;
        viewNum = 0;
    }
}
