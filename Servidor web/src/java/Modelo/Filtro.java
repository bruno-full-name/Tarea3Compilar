package Modelo;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Filtro implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        chain.doFilter(request, response);
        
        String userAgentString = ((HttpServletRequest) request).getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
        OperatingSystem os = userAgent.getOperatingSystem();
        Browser b = userAgent.getBrowser();
        
        String ip =  request.getRemoteAddr();
        String uri = ((HttpServletRequest) request).getRequestURI();
        String so = os.getName();
        String nav = b.getName();
        
        if(uri.contains("/ControllerInfoReserva")){
            uri = "/consultarReservas.jsp";
        }
        if(uri.contains("/ControllerReservav2")){
            uri = "/verCarrito.jsp";
        }
        if(uri.contains("/IniciarSesion")){
            uri = "/inicioCliente.jsp";
        }
        if(uri.contains("/CerrarSesion")){
            uri = "/index.jsp";
        }
        
        if(uri.endsWith(".jsp") || uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".png")){
            ModelRegistro mr = new ModelRegistro();
            mr.agregarRegistro(ip, uri, nav, so);
        }
        
    }

    @Override
    public void destroy() {

    }
    
}
