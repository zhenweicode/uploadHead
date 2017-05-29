package com.cropbox.demo.uploadHead.model;

/**
 * 上传图片后回显提示的实体类
 *
 * @author xie
 * @version 1.0
 * @Date 2017/5/25
 */
public class UploadPictureResponse {
    /** 上传状态，0：失败，1：上传成功 */
    private int success;

    /** 图片上传提示信息,包括上传成功或上传失败及错误信息等 */
    private String message;

    /** 图片上传成功后返回的地址 */
    private String url;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
