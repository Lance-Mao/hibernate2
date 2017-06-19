package oneToOne;

/**
 * 用户
 * Created by admin on 2017/6/19.
 */
public class User {
    private int userId;
    private String userName;
    //用户与省份证关系，一对一
    private IdCard idCard;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }
}
