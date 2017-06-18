package collection;

import java.util.*;

/**
 * Created by admin on 2017/6/18.
 */
public class User {

    private int userId;
    private String userName;
    //一个用户对应多个地址
    private Set<String> address;
    private List<String> addressList = new ArrayList<String>();
    private String[] addressArray;   //映射方式和List集合一样 <array name="" ></array>
    private Map<String, String> addressMap = new HashMap<String,String>();

    public Map<String, String> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, String> addressMap) {
        this.addressMap = addressMap;
    }

    public String[] getAddressArray() {
        return addressArray;
    }

    public void setAddressArray(String[] addressArray) {
        this.addressArray = addressArray;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

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

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }
}
