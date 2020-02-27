package cn.zhoujianfeng.baidumap;


public class User {
    String name;
    String tel;

    public User(String name, String tel) {
        super();
        this.name = name;
        this.tel = tel;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "酒店名称为" + name + "\n电话" + tel + "";
    }
}
