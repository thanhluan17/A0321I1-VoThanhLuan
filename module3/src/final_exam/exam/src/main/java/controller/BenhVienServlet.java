package controller;

import model.bean.BenhAn;
import model.bean.BenhNhan;
import model.service.BenhAnService;
import model.service.BenhNhanService;
import model.service.impl.BenhAnServiceImpl;
import model.service.impl.BenhNhanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhVienServlet", urlPatterns = {"", "/benhan"})
public class BenhVienServlet extends HttpServlet {
    BenhAnService benhAnService = new BenhAnServiceImpl();
    BenhNhanService benhNhanService = new BenhNhanServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createBenhAn(request, response);
                break;
            case "update":
                updateBenhAn(request, response);
                break;
            case "delete":
                deleteBenhAn(request, response);
                break;
        }
    }

    private void updateBenhAn(HttpServletRequest request, HttpServletResponse response) {
        int ma_benh_an = Integer.parseInt(request.getParameter("id"));
        int ma_benh_nhan = Integer.parseInt(request.getParameter("ma_benh_nhan"));
        String ngay_nhap_vien = request.getParameter("ngay_nhap_vien");
        String ngay_ra_vien = request.getParameter("ngay_ra_vien");
        String ly_do = request.getParameter("ly_do");
        BenhAn benhAn = new BenhAn(ma_benh_an, ma_benh_nhan, ngay_nhap_vien, ngay_ra_vien, ly_do);
        benhAnService.update(benhAn);
        try {
            showListBenhAn(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBenhAn(HttpServletRequest request, HttpServletResponse response) {
        int ma_benh_an = Integer.parseInt(request.getParameter("ma_benh_an"));
        System.out.println(ma_benh_an);
        int row = benhAnService.delete(ma_benh_an);
        String message = "";
        if (row == 1) {
            message = "Xóa thành công!";
        } else {
            message = "Xóa thất bại!";
        }
        request.setAttribute("message", message);
        try {
            List<BenhAn> benhAnList = benhAnService.findAll();
            request.setAttribute("benhAnList", benhAnList);
            request.getRequestDispatcher("/benhvien/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createBenhAn(HttpServletRequest request, HttpServletResponse response) {
        int ma_benh_nhan = Integer.parseInt(request.getParameter("ma_benh_nhan"));
        String ngay_nhap_vien = request.getParameter("ngay_nhap_vien");
        String ngay_ra_vien = request.getParameter("ngay_ra_vien");
        String ly_do = request.getParameter("ly_do");
        BenhAn benhAn = new BenhAn(ma_benh_nhan, ngay_nhap_vien, ngay_ra_vien, ly_do);
        benhAnService.save(benhAn);
        try {
            showListBenhAn(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showCreateForm(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                try {
                    showUpdateForm(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showListBenhAn(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ma_benh_an = Integer.parseInt(request.getParameter("id"));
        BenhAn benhAn = benhAnService.findById(ma_benh_an);
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        request.setAttribute("benhAn", benhAn);
        request.setAttribute("benhNhanList", benhNhanList);
        request.getRequestDispatcher("/benhvien/edit.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", benhNhanList);
        request.getRequestDispatcher("/benhvien/create.jsp").forward(request, response);
    }

    private void showListBenhAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);
        request.getRequestDispatcher("/benhvien/list.jsp").forward(request, response);
    }
}
