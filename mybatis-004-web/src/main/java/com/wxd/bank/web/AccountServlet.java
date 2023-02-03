package com.wxd.bank.web;

import com.wxd.bank.exceptions.MoneyNotEnoughException;
import com.wxd.bank.exceptions.TransferException;
import com.wxd.bank.service.AccountService;
import com.wxd.bank.service.Impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 9:04
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        //调用service层转账业务进行转账
        try {
            accountService.transfer(fromActno,toActno,money);
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/moneyNotEnough.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/error.html");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }
}
