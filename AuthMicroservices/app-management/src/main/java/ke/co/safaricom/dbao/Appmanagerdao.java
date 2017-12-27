/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.safaricom.dbao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ke.co.safaricom.dbentities.Applications;
import ke.co.safaricom.dbentities.Auth;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author CWEKESA
 */
@Repository("Appmanagerdao")
@Transactional
public class Appmanagerdao {
    
    @PersistenceContext
    public EntityManager entityManager;
    
    
    @Transactional(readOnly = false)
    public Applications addApplication(Applications ap) {
        entityManager.persist(ap);
        return ap;
    }
    
    
//    @Transactional(readOnly = false)
//    public String updateTransaction(TransactionsDb ap) {
//        entityManager.merge(ap);
//        return ap.toString();
//    }
//    
    @Transactional(readOnly = false)
    public Auth getAuthtype(String authtype) {
        Auth auth=null;
        try{
            List transdata=entityManager.createQuery("SELECT a FROM Auth a WHERE a.authName = :authName")
                    .setParameter("authName", authtype)
                    .setMaxResults(1)
                    .getResultList();
            if(!transdata.isEmpty()){
                auth=(Auth)transdata.get(0);
            }
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return auth;
    }
    
    
}
