package mx.gob.seguropopulartlax.servicio;

import java.util.List;
import mx.gob.seguropopulartlax.dao.UserDao;
import mx.gob.seguropopulartlax.entidades.User;

public class UserServicio {
    
    private final UserDao userDao;
    
    public UserServicio(){
        userDao = new UserDao();
    }
    
    public List<User> getAll(){
        return userDao.getAll();
    }
    
    public User get(String CURP, String PASSWORD){
        return userDao.get(CURP, PASSWORD);
    }
    
    public void create(String CURP, String PASSWORD, String NOMBRE, String APATERNO, String AMATERNO ) {
        /*if (NOMBRE==null)
            throw new NullPointerException("Curp no puede ser null");      
        if (CURP == null || CURP.length()==0)
            throw new NullPointerException("Curp de usuario no mantiene caracteres: '" + 
                    CURP + "'");*/
        userDao.addUser(CURP,PASSWORD,NOMBRE,APATERNO,AMATERNO);
    }
    
    public void update(String CURP, String PASSWORD){
        userDao.updateUser(CURP, PASSWORD);
    }
    
    public void delete(String CURP){
        userDao.deleteUser(CURP);
    }
}
