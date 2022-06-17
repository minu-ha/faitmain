package com.faitmain.global.util.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityLoginFail implements AuthenticationFailureHandler{

    @Override
    public void onAuthenticationFailure( HttpServletRequest request , HttpServletResponse response , AuthenticationException exception ) throws IOException, ServletException{
    	//인증실패시 타는 핸들러 
    	
    	System.out.println("onAuthenticationFailure") ;
        /* BadCredentialsException는 비밀번호가 일치하지 않았을때 */
        /* InternalAuthenticationServiceException는 아이디가 없을때 */
   
        String errorMessage = "";       
        if (exception instanceof BadCredentialsException) {            
        	errorMessage = "아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해 주세요.";        } 
        else if (exception instanceof InternalAuthenticationServiceException) {   
        	errorMessage = "내부적으로 발생한 시스템 문제로 인해 요청을 처리할 수 없습니다. 관리자에게 문의하세요.";        
        	} else if (exception instanceof UsernameNotFoundException) {           
        		errorMessage = "계정이 존재하지 않습니다. 회원가입 진행 후 로그인 해주세요.";       
        		}  
        
        System.out.println("errorMessage+ "+ errorMessage);
        System.out.println("exception: " + exception.getMessage());

        
       System.out.println("에러에러");
        request.getRequestDispatcher("/user/login").forward(request, response); // 로그인 실패시, user/login 페이지로 이동
    }
}