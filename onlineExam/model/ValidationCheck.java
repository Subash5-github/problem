package onlineExam.controller;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
class ValidationCheck{
     
     
   public  boolean validateUserName(String name){
        String regex = "^[A-Za-z][A-Za-z0-9]{4,25}$";
        Pattern pattern = Pattern.compile(regex);
        if(name==null){
          return false;
        }
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
   }
   
    public  boolean validateName(String name){
        String regex = "^[A-Za-z][A-Za-z ]{2,30}$";
        Pattern pattern = Pattern.compile(regex);
        if(name==null){
          return false;
        }
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
   }
  public  boolean validatePassword(String password) {
        String regex = "^[A-Za-z][A-Za-z0-9!@#$%^&*]{5,15}$";
        Pattern pattern = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
   
   public  boolean validateNumber(long number) {
        String numberStr = Long.toString(number);
        String regex = "^[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numberStr);
        return matcher.matches();
    }
}
