package oneToOne;

/**
 * 省份证
 * Created by admin on 2017/6/19.
 */
public class IdCard {

    //省份证号（主键）
    private String cardNum;  //对象唯一标识
    private String place;  //省份证地址
    //省份证与用户  一对一
    private User user;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
