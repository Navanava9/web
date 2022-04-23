package controller;

import model.VerifyCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "vcodeController", value = "/VCode.do")
public class vcodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/jpeg");
        // 创建会话
        HttpSession session = request.getSession();
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        VerifyCode V = new VerifyCode();
        BufferedImage image = V.FourOpCode();

        String sRand = V.getAnswer();

        //将验证码存入session
        session.setAttribute("VCode", sRand);
        //输出图像到页面
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }
}


