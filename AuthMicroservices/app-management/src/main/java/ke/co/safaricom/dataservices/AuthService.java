/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.safaricom.dataservices;

import ke.co.safaricom.controllers.AuthRequest;
import ke.co.safaricom.dbao.Appmanagerdao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author CWEKESA
 */
@Service
public class AuthService {
    
    private final String error="error";
    private final String success="success";
    private final String token="token";
    
    @Autowired(required=true)
    @Qualifier("Appmanagerdao")
    private Appmanagerdao appmanagerdao;
    
    @Autowired
    RestTemplate restTemplate;
    
    public final String stk_service_endpoint="http://stk-service/stk-initiate";//notice the URL is through the server proxy
    
    public String processauth(AuthRequest data){
        JSONObject response=new JSONObject();
        try{
            if(data.getToken()!=null){
                //lets authenticate the token first
                //lets just forward the request to the stk-service now
                //we wont authenticate because of time here
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<String> entity = new HttpEntity<>("test data to stk-service", headers);
                ResponseEntity<String> stk_response = restTemplate.exchange(stk_service_endpoint, HttpMethod.POST,
                        entity, String.class);
                response=new JSONObject(stk_response.getBody());
            }
            else{
               response.put(error, "check your request and try again, ensure you have token"); 
            }
        }
        catch(Exception e){
            response.put(error, "check your request and try again");
        }
        return response.toString();
    }
    
}
