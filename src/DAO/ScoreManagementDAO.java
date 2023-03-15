package DAO;

import Database.Connect;
import Modal.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreManagementDAO {
    public void insertScore(Score s) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "INSERT INTO scoremanagement(stdName,stdAge,stdClass,stdGPA,stdGender) VALUES (?,?,?,?,?)";
            prst = conn.prepareStatement(sql);
            prst.setString(1, s.getStdName());
            prst.setInt(2, s.getStdAge());
            prst.setString(3, s.getStdClass());
            prst.setDouble(4,s.getStdGPA());
            prst.setString(5, s.getStdGender());
            prst.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public Score showById(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM scoremanagement s WHERE s.stdcode =" + id;
            ResultSet rs = stmt.executeQuery(sql);
            Score s = null;
            while(rs.next()) {
                Integer stdCode = rs.getInt("stdCode");
                String stdName = rs.getString("stdName");
                Integer stdAge = rs.getInt("stdAge");
                String stdClass = rs.getString("stdClass");
                Double stdGPA = rs.getDouble("stdGPA");
                String stdGender = rs.getString("stdGender");
                s = new Score(stdCode, stdName, stdAge, stdClass, stdGPA, stdGender);
            }
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public List<Score> getScoreByName(String name){
        List<Score> scoreList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM scoremanagement s WHERE s.stdName LIKE '" + name + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            Score s = null;
            while(rs.next()) {
                Integer stdCode = rs.getInt("stdCode");
                String stdName = rs.getString("stdName");
                Integer stdAge = rs.getInt("stdAge");
                String stdClass = rs.getString("stdClass");
                Double stdGPA = rs.getDouble("stdGPA");
                String stdGender = rs.getString("stdGender");
                s = new Score(stdCode, stdName, stdAge, stdClass, stdGPA, stdGender);
                scoreList.add(s);
            }
            return scoreList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public Score updateScore(int id, Score s) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE scoremanagement SET stdName = ?, stdAge = ?, stdClass = ?, stdGPA = ?, stdGender = ? WHERE stdCode = ?";
            prst = conn.prepareStatement(sql);
            prst.setString(1, s.getStdName());
            prst.setInt(2, s.getStdAge());
            prst.setString(3, s.getStdClass());
            prst.setDouble(4,s.getStdGPA());
            prst.setString(5, s.getStdGender());
            prst.setInt(6, id);
            prst.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return s;
    }

    public void deleteScore(int id){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "DELETE FROM scoremanagement WHERE stdCode = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1, id);
            prst.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public List<Score> getAllScore(){
        List<Score> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM scoremanagement s;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Score nhanVien = new Score(
                        rs.getInt("stdCode"),
                        rs.getString("stdName"),
                        rs.getInt("stdAge"),
                        rs.getString("stdClass"),
                        rs.getDouble("stdGPA"),
                        rs.getString("stdGender")
                );
                list.add(nhanVien);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

}
