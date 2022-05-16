package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCode {
    //定义一些变量
    private int width = 80;
    private int height = 20;
    private int fontSize = 18;
    private StringBuilder VCode = new StringBuilder();
    private Random random = new Random();
    private String[] symbol = {"+", "-", "*"};

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    //获取数字
    private String getNumber() {
        int num = random.nextInt(10);
        return num + "";
    }

    //获取符号
    private String getSymbol() {
        int index = random.nextInt(symbol.length);
        String s = symbol[index];
        return s;
    }

    //获取颜色
    private Color getColor() {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    //设置缓冲区
    private BufferedImage getBufferedImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(255,255,255));
        g.fillRect(0, 0, width, height);
        g.dispose();
        return image;
    }

    //给缓冲区添加字符串,添加干扰线
    public BufferedImage defaultCode() {
        BufferedImage image = getBufferedImage();
        Graphics g = image.getGraphics();
        for (int i = 0; i < 4; i++) {
            g.setColor(getColor());
            g.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
            String s = getNumber();
            VCode.append(s);
            g.drawString(s, 13 * i + 6, 16);
        }

        return drawInterferenceLine(image, g);
    }

    public BufferedImage FourOpCode() {
        BufferedImage image = getBufferedImage();
        Graphics g = image.getGraphics();

        g.setColor(getColor());
        g.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));

        String s1 = getNumber();
        VCode.append(s1);
        g.drawString(s1, 6, 16);

        String s2 = getSymbol();
        VCode.append(s2);
        g.drawString(s2, 19, 16);

        String s3 = getNumber();
        VCode.append(s3);
        g.drawString(s3, 32, 16);

        g.drawString("=", 45, 16);

        return drawInterferenceLine(image, g);
    }

    private BufferedImage drawInterferenceLine(BufferedImage image, Graphics g) {
        int lineNumber = 20;
        for (int i = 0; i < lineNumber; i++) {
            g.setColor(getColor());
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(12);
            int y2 = random.nextInt(12);
            g.drawLine(x1, y1, x1 + x2, y1 + y2);
        }
        g.dispose();
        return image;
    }

    //获取验证码的值
    public String getText() {
        return VCode.toString();
    }
    //获取计算值
    public String getAnswer() {
        int c1 = Integer.parseInt(VCode.substring(0, 1));
        String c2 = VCode.substring(1, 2);
        int c3 = Integer.parseInt(VCode.substring(2, 3));
        switch (c2) {
            case "+":
                return  (c1 + c3) + "";
            case "-":
                return  (c1 - c3) + "";
            case "*":
                return c1 * c3 + "";
        }
        return "";
    }
}