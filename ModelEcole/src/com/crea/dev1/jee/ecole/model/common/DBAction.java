package com.crea.dev1.jee.ecole.model.common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBAction {
  
  private static final String dbPath   = "jdbc:mysql://localhost:3306/ecole"; //Port 3306 on Windows, 8889 on mac
  private static final String user     = "root";
  private static final String password = "";
  private static Connection   con      = null;
  private static Statement    stm      = null;
  private static ResultSet    res      = null;
  private static int          error;

  public static Exception DBConnexion() {
      try {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
          con = DriverManager.getConnection(dbPath, user, password);
          stm = con.createStatement();
          return null;
      } catch (Exception e) {
          System.out.println("ERROR in Connexion to " + dbPath + " :" + e.getMessage());
          return e;
      }
  }

  public static int DBClose() 
  {
      try {
          stm.close();
          con.close();
      } catch (Exception e) {
          System.out.println("ERROR in Connexion closure to " + dbPath + " : " + e.getMessage());
      }

      return error;
  }

  public static Connection getCon() {
      return con;
  }

  public static void setCon(Connection con) {
      DBAction.con = con;
  }

  public static Statement getStm() {
      return stm;
  }

  public static void setStm(Statement stm) {
      DBAction.stm = stm;
  }

  public static ResultSet getRes() {
      return res;
  }

  public static void setRes(ResultSet res) {
      DBAction.res = res;
  }
}
