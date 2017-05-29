# uploadHead
CropBox实现头像裁剪，上传，后台接收，缩放

采用Spring+SpringMVC+MyBatis+MySQL+Maven+CropBox实现，主要功能：
- 图片上传，裁剪
- 预览
- 后台保存到数据库和文件夹
- 缩放输出

预览：
![](http://images2015.cnblogs.com/blog/1156565/201705/1156565-20170529131759180-1322268306.png)

下面为从后台数据库或者文件夹取出的图片，然后byte[]格式传到前台，
前一个头像正常大小，后一个缩放到100*100像素

![](http://images2015.cnblogs.com/blog/1156565/201705/1156565-20170529132124961-540959877.png)

运行项目前请先导入数据库文件，并将用户名和密码修改。

blog分析：http://www.cnblogs.com/xzwblog/p/6912320.html
