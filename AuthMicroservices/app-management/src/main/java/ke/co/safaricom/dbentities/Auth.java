/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.safaricom.dbentities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CWEKESA
 */
@Entity
@Table(name = "auth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a")
    , @NamedQuery(name = "Auth.findByAuthId", query = "SELECT a FROM Auth a WHERE a.authId = :authId")
    , @NamedQuery(name = "Auth.findByAuthName", query = "SELECT a FROM Auth a WHERE a.authName = :authName")})
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "auth_id")
    private Integer authId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "auth_name")
    private String authName;

    public Auth() {
    }

    public Auth(Integer authId) {
        this.authId = authId;
    }

    public Auth(Integer authId, String authName) {
        this.authId = authId;
        this.authName = authName;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authId != null ? authId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auth)) {
            return false;
        }
        Auth other = (Auth) object;
        if ((this.authId == null && other.authId != null) || (this.authId != null && !this.authId.equals(other.authId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ke.co.safaricom.dbentities.Auth[ authId=" + authId + " ]";
    }
    
}
