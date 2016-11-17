package help4travelling;

public class Registro {
    public String id, ip, url, so, navegador;

    public Registro() {
    }
    
    public Registro(String id, String ip, String url, String so, String navegador) {
        this.id = id;
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
