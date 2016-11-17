package help4travelling;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtRegistro implements Serializable{
    public String id, ip, url, so, navegador;
    
    public DtRegistro(){}

    public DtRegistro(String id, String ip, String url, String so, String navegador) {
        this.id = id;
        this.ip = ip;
        this.url = url;
        this.so = so;
        this.navegador = navegador;
    }

    DtRegistro(String ip, String url, String navegador, String so) {
        this.ip = ip;
        this.url = url;
        this.so = so;
        this.navegador = navegador;
    }

    public String getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getUrl() {
        return url;
    }

    public String getSo() {
        return so;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }
    
}
