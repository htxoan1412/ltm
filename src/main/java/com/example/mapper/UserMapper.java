package com.example.mapper;

import com.example.model.SinhvienModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<SinhvienModel> {

    @Override
    public SinhvienModel mapRow(ResultSet resultSet) {
        SinhvienModel sinhvien = new SinhvienModel();
        try {
            sinhvien.setId(resultSet.getInt("id"));
            sinhvien.setMssv(resultSet.getString("mssv"));
            sinhvien.setUsername(resultSet.getString("username"));
            sinhvien.setPassword(resultSet.getString("password"));
            sinhvien.setHoten(resultSet.getString("hoten"));
            sinhvien.setGioitinh(resultSet.getString("gioitinh"));
            sinhvien.setKhoa(resultSet.getString("khoa"));

            return sinhvien;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
