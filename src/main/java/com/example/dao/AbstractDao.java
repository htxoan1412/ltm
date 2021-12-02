package com.example.dao;

import com.example.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Test18N16";
            String user = "root";
            String password = "xoan123456789";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new AbstractDao().getConnection());
    }


    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(rowMapper.mapRow(resultSet));

            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public int delete(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultSet = 0;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeUpdate();
            connection.commit();
            return resultSet;
        } catch (SQLException throwables) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();

        }
        return 0;
    }

    public int insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultSet = 0;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException throwables) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
            return 0;
        }
    }

    public int update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException throwables) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }
        return 0;
    }

    public void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                }else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                }
                else if (parameter == null) {
                    statement.setNull(index, Types.NULL);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public int count(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            int count=0;
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count(*)");
            }
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
}
