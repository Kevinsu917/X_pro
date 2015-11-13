package io.github.kevinsu917.xpro.common.entity;

/**
 * Creator: KevinSu kevinsu917@126.com
 * Date 2015-11-09-11:05
 * Description:
 */
public class User {

    private String username;
    private String password;
    private int type;// 1:teacher,2:student

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
