
package app.jdbcstrpng.test;

import app.jdbcstrpng.dao.ServicioDAO;
import app.jdbcstrpng.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class AppTestServicio {
    public static void main(String[] args) {
        //AppTestServicio.saveServicio();
        AppTestServicio.getAllServicios();
    }
    
        public static void saveServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicio = new Servicio();
        servicio.setDescripcion("Mañana Deportiva ");
        servicio.setCostoHora(109.51d);

        servicioDAO.save(servicio);
    }
    
        
      public static void getServicio(Servicio servicio){
            ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-database.xml");

            ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
            Servicio servicioFull = servicioDAO.get(servicio);
            System.out.println(servicioFull.getId() + " " +servicioFull.getDescripcion() + " " + servicioFull.getCostoHora());
      }
      
      
      public static void getAllServicios() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-database.xml");

        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getId() +" " +servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }
      
        
}
