package com.example.dao;

import com.example.mapper.UserMapper;
import com.example.model.SinhvienModel;

import java.util.List;

public class SinhVienDao extends AbstractDao {
    public SinhvienModel checkLogin(String name, String pass){
        String sql = "select * from sinhvien where username=? and password=?";
        List<SinhvienModel> list = query(sql,new UserMapper(),name,pass);
        return list.isEmpty() ? null : list.get(0);
    }
    public List<SinhvienModel> selectSinhvien(){
        String sql = "select * from sinhvien";
        return query(sql,new UserMapper());
    }
    public int delSinhvien(int id){
        String sql = "delete from sinhvien where id=?";
        return delete(sql,id);
    }
    public int updateSinhvien(SinhvienModel sinhvien){
        String sql = "update sinhvien set mssv=?,hoten=?,gioitinh=? ,khoa=? where id=?";
        return update(sql,sinhvien.getKhoa(),sinhvien.getHoten(),sinhvien.getGioitinh(),sinhvien.getKhoa());
    }


}
