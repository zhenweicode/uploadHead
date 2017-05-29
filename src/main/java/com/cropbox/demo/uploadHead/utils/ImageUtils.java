package com.cropbox.demo.uploadHead.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 图片处理服务
 *
 * @author xie
 * @version 1.0
 * @Date 2017/5/27
 */
@Service
public class ImageUtils {

    /** 头像图片的放置路径*/
    @Value("${headPath.home}")
    private String PictureDir;

    /** 允许的图片类型头像图片，这里分别使用属性占位符和SpEL表达式，可以实现更复杂的功能，运行时计算值*/
    @Value("${pictureLimit.suffix}")
    private String PictureFileSuffix;

    /**
    判断上传图片格式是否被允许
     */
    public boolean isFileAllowed(String fileSuffix) {
        for (String suffix : PictureFileSuffix.split(",")) {
            if (suffix.equals(fileSuffix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得图片存储路径
     * @return
     */
    public String getPictureDir(){
        return PictureDir;
    }

    /**
     * 获得系统允许上传图片后缀
     * @return
     */
    public String getPictureFileSuffix(){
        return PictureFileSuffix;
    }

    /**
     * 等比例缩放图片，按照长和宽中较小的数来确定缩放比例，所有单位为像素,
     * 在传输中，图片是不能直接传的，因此需要把图片变为字节数组，然后传输比较方便；只需要一般输出流的write方法即可；而字节数组变成BufferedImage能够还原图像；
     *
     * @param data 图片的byte[]格式
     * @param width 缩放后的宽度
     * @param height 缩放后的高度
     * @return 图片缩放后的byte[]格式
     * @throws IOException
     */
    public byte[] scaleImage(byte[] data, int width, int height) throws IOException {
        ////从特定文件载入
        BufferedImage oldImage = ImageIO.read(new ByteArrayInputStream(data));
        int imageOldWidth = oldImage.getWidth();
        int imageOldHeight = oldImage.getHeight();
        double scale_x = (double) width / imageOldWidth;
        double scale_y = (double) height / imageOldHeight;
        double scale_xy = Math.min(scale_x, scale_y);
        int imageNewWidth = (int) (imageOldWidth * scale_xy);
        int imageNewHeight = (int) (imageOldHeight * scale_xy);

        //创建一个不带透明色的BufferedImage对象
        BufferedImage newImage = new BufferedImage(imageNewWidth, imageNewHeight, BufferedImage.TYPE_INT_RGB);

        /*BufferedImage与Image之间的相互转换，其中
        * oldImage.getScaledInstance(imageNewWidth, imageNewHeight, BufferedImage.SCALE_SMOOTH)表示缩放图像
        * BufferedImage.SCALE_SMOOTH表示压缩图片所用的算法，本算法生成缩略图片的平滑度的优先级比速度高，生成的图片质量比较好，但速度慢
        *
         */
        newImage.getGraphics().drawImage(oldImage.getScaledInstance(imageNewWidth, imageNewHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);

        /*
        释放绘图上下文所占的系统资源
         */
        newImage.getGraphics().dispose();
        ByteArrayOutputStream outPutStream = new ByteArrayOutputStream();

        /*BufferedImage  ---->byte[],
        参数newImage表示获得的BufferedImage；
        参数format表示图片的格式，比如“gif”等；
        参数out表示输出流，如果要转成Byte数组，则输出流为ByteArrayOutputStream即可；
        执行完后，只需要toByteArray()就能得到byte[];
        */
        ImageIO.write(newImage, "jpg", outPutStream);
        oldImage.flush();

        outPutStream.flush();
        outPutStream.close();
        return outPutStream.toByteArray();
    }

}
