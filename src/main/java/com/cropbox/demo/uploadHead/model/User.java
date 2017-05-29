package com.cropbox.demo.uploadHead.model;

/**
 * 用户实体
 *
 * @author xie
 * @version 1.0
 * @Date 2017/5/27
 */
public class User {

    /** 用户主键 */
    private int userId;

    /** 用户名 */
    private String username;

    /** 列值 blob类型 */
    private byte[] head;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getHead() {
        return head;
    }

    public void setHead(byte[] head) {
        this.head = head;
    }

}
