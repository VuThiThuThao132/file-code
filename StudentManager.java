/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctsinhvien;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hunagroup
 */
// Là lớp dùng để cài đặt tính năng CRUD 
//--> Quản lý danh sách sinh viên
public class StudentManager {

    // Fields
    private ArrayList<Student> listStudent;

    // Getter & Setter
    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    // Constructors
    public StudentManager() {
        listStudent = new ArrayList<>();
    }

    public StudentManager(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    // Chúng cần cài đặt tối thiểu bao nhiêu phương thức
    // Methods
    // CRUD
    // 1. Create
    public void create() {
        Scanner sc = new Scanner(System.in);
        //Nhập từ bàn phím: id-name-age-math-english-informatic
        System.out.println("Nhập id:");
        String id = sc.nextLine();
        System.out.println("Nhập name:");
        String name = sc.nextLine();
        System.out.println("Nhập age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập math:");
        double math = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập english:");
        double english = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập informatic:");
        double informatic = Double.parseDouble(sc.nextLine());

        // Tạo một sinh viên mới
        Student newStudent = new Student(id, name, age, math, english, informatic);

        listStudent.add(newStudent); // Đưa sinh viên mới vào danh sách      
    }

    // 2. Read: Hiện thị hết thông tin các sinh viên trong danh sách
    public void read() {
        for (Student s : this.listStudent) {
            s.display();
        }
    }

    // 3. Detail: Hiển thị thông tin của một sinh viên thông mã số
    public void details() {
        // Nhập mã số của sinh viên
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã số: ");
        String madinhdanh = sc.nextLine();

        for (Student stu : listStudent) {
            if (stu.getId().equals(madinhdanh)) {
                stu.display();
            }
        }
    }
    // 4. Delete: Xóa thông tin của một sinh viên thông qua mã số
    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã số: ");
        String madinhdanh = sc.nextLine();
        
        for(int i = 0; i < listStudent.size(); i++){
            if(listStudent.get(i).getId().equals(madinhdanh)){
                listStudent.remove(i);
            }
        }
    }
    // 5. Update:Cập nhật thông tin sinh viên
    public void update(){
        Scanner sc = new Scanner(System.in);
        //Nhập từ bàn phím: Thông tin cập nhật của sinh viên
        System.out.println("Nhập id:");
        String id = sc.nextLine();
        // Tìm sinh viên trong danh sách
        // Sinh viên temp: mục đích lưu trữ thông tin cũ của sinh viên tìm được
        Student temp = new Student();
        for (Student stu : listStudent) {
            if (stu.getId().equals(id)) {
                temp = stu;
            }
        }
       // Nếu tìm ra sinh viên có mã số vừa nhập
        if(!temp.getId().isEmpty()){ 
            // Nhập các thông tin cần chỉnh sửa
            System.out.println("Nhập name:");
            String name = sc.nextLine();
            // Trick:Khi người dùng có nhập thông tin => thì mới chỉnh sửa
            if(!name.isEmpty()){
                temp.setName(name);
            }
            
            System.out.println("Nhập age:");
            String strAge = sc.nextLine();
            // Trick:Khi người dùng có nhập thông tin => thì mới chỉnh sửa
            if(!strAge.isEmpty()){
                int age = Integer.parseInt(strAge);
                temp.setAge(age);
            }
            
            System.out.println("Nhập math:");
            String strMath = sc.nextLine();
            if(!strMath.isEmpty()){
                double math = Double.parseDouble(strMath);
                temp.setMath(math);               
            }
            
            System.out.println("Nhập english:");
            String strEng = sc.nextLine();
            if(!strEng.isEmpty()){
                double english = Double.parseDouble(strEng);
                temp.setEnglish(english);
            }
            
            System.out.println("Nhập informatic:");
            String strInfor = sc.nextLine();
            if(!strInfor.isEmpty()){
                double informatic = Double.parseDouble(strInfor);
                temp.setInformatic(informatic);
            }          
        }       
    }
}
