package com.Msso.MssoBusinessBackend.Services.ServiceMssoSession;

import org.springframework.stereotype.Service;

@Service
public class ServiceSessonMsso {

    public boolean getResult(long randomNumber, long randomDigit, String pf_no){
        boolean result = false;

        String lastPfDigit = pf_no.replaceAll("18960", "");
        //  System.out.println(lastPfDigit);

        long answer = (randomNumber + Integer.parseInt(lastPfDigit )) / randomDigit;
        //  System.out.println(answer);
        if(answer == Long.parseLong(pf_no)){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
}
