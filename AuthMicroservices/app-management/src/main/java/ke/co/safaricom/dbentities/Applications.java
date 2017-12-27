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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "applications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applications.findAll", query = "SELECT a FROM Applications a")
    , @NamedQuery(name = "Applications.findByAppId", query = "SELECT a FROM Applications a WHERE a.appId = :appId")
    , @NamedQuery(name = "Applications.findByAppName", query = "SELECT a FROM Applications a WHERE a.appName = :appName")
    , @NamedQuery(name = "Applications.findByToken", query = "SELECT a FROM Applications a WHERE a.token = :token")})
public class Applications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_id")
    private Integer appId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "app_name")
    private String appName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "token")
    private String token;
    @JoinColumn(name = "auth_type", referencedColumnName = "auth_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Auth authType;

    public Applications() {
    }

    public Applications(Integer appId) {
        this.appId = appId;
    }

    public Applications(Integer appId, String appName, String token) {
        this.appId = appId;
        this.appName = appName;
        this.token = token;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Auth getAuthType() {
        return authType;
    }

    public void setAuthType(Auth authType) {
        this.authType = authType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appId != null ? appId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applications)) {
            return false;
        }
        Applications other = (Applications) object;
        if ((this.appId == null && other.appId != null) || (this.appId != null && !this.appId.equals(other.appId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ke.co.safaricom.dbentities.Applications[ appId=" + appId + " ]";
    }
    
}
