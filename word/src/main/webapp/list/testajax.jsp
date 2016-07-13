<%@page import="wordstudy.vo.TestData"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
ArrayList<TestData> list = new ArrayList<>();
list.add(new TestData("오호라", "2016-06-09 12:38:23", "crack22", "갈라지다22", "크래커가 갈라지다22", 2, 2));

// 모델 객체에서 게시물 목록을 받았다고 가정하자!
// ArrayList의 들어있는 객체를 JSON 문자열로 자동으로 바꾸려면,
// 도우미 클래스가 필요하다.
// 누구?
// JSON <--> 자바 객체 상호 변환기
// 
%>
<%=new Gson().toJson(list)%>











