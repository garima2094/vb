package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataModel;

public class Register extends HttpServlet {
  

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int sid=1;
            long phone;
            String sfname,slname,optCourse,emailId,category,sfather,smother,address,schoolName,bloodGp,medium,dob;
            sfname = request.getParameter("sfname");
            System.out.print(sfname);
            slname = request.getParameter("slname");
            emailId = request.getParameter("emailId");
            optCourse = request.getParameter("optCourse");
            category = request.getParameter("category");
            sfather = request.getParameter("sfather");
            smother = request.getParameter("smother");
            address = request.getParameter("address");
            schoolName = request.getParameter("schoolName");
            bloodGp = request.getParameter("bloodGp");
            medium = request.getParameter("medium");
            dob = request.getParameter("dob");
            phone = Long.parseLong(request.getParameter("phone"));
            System.out.print(phone);
            //set and get attributes
            DataModel dataModel=new DataModel();
            dataModel.setSfname(sfname);
            dataModel.setSlname(slname);
            dataModel.setEmailId(emailId);
            dataModel.setOptCourse(optCourse);
            dataModel.setCategory(category);
            dataModel.setSfather(sfather);
            dataModel.setSmother(smother);
            dataModel.setAddress(address);
            dataModel.setSchoolName(schoolName);
            dataModel.setBloodGp(bloodGp);
            dataModel.setMedium(medium);
            dataModel.setDob(dob);
            dataModel.setPhone(phone);
           
         
                //create connection with database
                
               try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection;
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vb", "root", "12345");
                System.out.println("connected");
                Statement statement=connection.createStatement();
                String sql="select max(sid) from studentdetails";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    sid+=resultSet.getInt(1);
                }
                dataModel.setSid(sid);
             
                System.out.println(sid);
              
               /*}catch(ClassNotFoundException | SQLException e){
               }
           
               try{
                   Class.forName("com.mysql.jdbc.Driver");
                Connection connection;
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vb", "root", "12345");*/
                PreparedStatement preparedStatement;
              
           
                preparedStatement=connection.prepareStatement("insert into studentdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
System.out.print("hello");
                preparedStatement.setInt(1,dataModel.getSid());
                preparedStatement.setString(2,dataModel.getSfname());
                preparedStatement.setString(3,dataModel.getSlname());
                preparedStatement.setString(4,dataModel.getDob());
                preparedStatement.setString(5,dataModel.getOptCourse());
                preparedStatement.setString(6,dataModel.getEmailId());
                preparedStatement.setString(7,dataModel.getCategory());
                preparedStatement.setString(8,dataModel.getSfather());
                preparedStatement.setString(9,dataModel.getSmother());
                preparedStatement.setString(10,dataModel.getAddress());
                preparedStatement.setLong(11,dataModel.getPhone());
                preparedStatement.setString(12,dataModel.getSchoolName()); 
                preparedStatement.setString(13,dataModel.getMedium());
                preparedStatement.setString(14,dataModel.getBloodGp());
                int i = preparedStatement.executeUpdate();
               System.out.println(i);
                if (i > 0) {
                  
                    response.sendRedirect("index.html");
                }
             
            
            }
            catch(SQLException | ClassNotFoundException e){
                System.out.print(e);
            }
         }
        }
        
     
    


