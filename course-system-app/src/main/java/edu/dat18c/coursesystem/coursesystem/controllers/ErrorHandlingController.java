package edu.dat18c.coursesystem.coursesystem.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ErrorHandlingController
 */
@Controller
public class ErrorHandlingController implements ErrorController
{

    @GetMapping( value = "/error")
    public String handleError(HttpServletRequest request) 
    {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status == null) 
        {
            return "error/error";    
        }

        Integer status_code = Integer.valueOf(status.toString());

        if (status_code == HttpStatus.BAD_REQUEST.value())
        {
            return "error/400";
        }

        else if (status_code == HttpStatus.FORBIDDEN.value()) 
        {
            return "error/403";
        }

        else if (status_code == HttpStatus.NOT_FOUND.value())
        {
            return "error/404";
        }

        else if (status_code == HttpStatus.GONE.value())
        {
            return "error/410";
        }

        else if (status_code == HttpStatus.I_AM_A_TEAPOT.value())
        {
            return "error/418";
        }

        else if (status_code == HttpStatus.INTERNAL_SERVER_ERROR.value())
        {
            return "error/500";
        }

        return "error/error";
    }
    

    @Override
    public String getErrorPath() 
    {
        return "/error";
    }

}