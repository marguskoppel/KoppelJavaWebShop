
package secure;

import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.RoleFacade;
import session.UserRolesFacade;


public class SecureLogic {
    private UserRolesFacade userRolesFacade;
    private RoleFacade roleFacade;

    public SecureLogic() {
        Context context;
        try {
            context = new InitialContext();
            this.userRolesFacade = (UserRolesFacade) context.lookup("java:module/UserRolesFacade");
            this.roleFacade = (RoleFacade) context.lookup("java:module/RoleFacade");
        } catch (NamingException ex) {
            Logger.getLogger(SecureLogic.class.getName()).log(Level.SEVERE, "Could not locate Bin", ex);
        }
    }
    
    public void addRoleToUser(UserRoles ur){
       // if(ur.getRole().getName().equals("ADMIN")){
            userRolesFacade.create(ur);
            //Role addNewRole = roleFacade.findRoleByName("USER");
            //UserRoles addedNewRoles = new UserRoles(ur.getUser(),addNewRole);
            //userRolesFacade.create(addedNewRoles);
        //}else if(ur.getRole().getName().equals("USER")){
           // userRolesFacade.create(ur);
        
       // }
       
}   

    /*public void addRoleToUser(UserRoles ur){
        if(ur.getRole().getName().equals("ADMIN")){
            userRolesFacade.create(ur);
            
        }else if(ur.getRole().getName().equals("USER")){
            userRolesFacade.create(ur);
        }
    }*/
     /*public void addRoleToUser(UserRoles ur){
        if(ur.getRole().getName().equals("ADMIN")){
            userRolesFacade.create(ur);
            List<Role> addNewRoles = roleFacade.findAll();
            int m = addNewRoles.size();
            for(int i=0; i<m; i++ ){
                userRolesFacade.create(addNewRoles.get(i));
            }
            Role addNewRole = roleFacade.findRoleByName("USER");
            UserRoles addedNewRoles = new UserRoles(ur.getUser(),addNewRole);
            userRolesFacade.create(addedNewRoles);
        }else if(ur.getRole().getName().equals("USER")){
            userRolesFacade.create(ur);
        }*/
    
    public void deleteRoleToUser(User user){
        List<UserRoles> listUserRoles = userRolesFacade.findByUser(user);
        int n = listUserRoles.size();
        for(int i=0; i<n; i++){
            userRolesFacade.remove(listUserRoles.get(i));
        }
    }

    public boolean isRole(User user, String roleName){
        if(user == null) return false;
        List<UserRoles> listUserRoles = userRolesFacade.findByUser(user);
        Role role = roleFacade.findRoleByName(roleName);
        int n = listUserRoles.size();
        for(int i = 0; i < n; i++){
            if(listUserRoles.get(i).getRole().equals(role)){
                return true;
            }
        }
        return false;
    }
    
    public String getRole(User regUser) {
        List<UserRoles> listUserRoles = userRolesFacade.findByUser(regUser);
        int n = listUserRoles.size();
        for(int i = 0; i<n; i++){
            //if("ADMIN".equals(listUserRoles.get(i).getRole().getName())){
                return listUserRoles.get(i).getRole().getName();
            //}
        //}
        //for(int i = 0; i<n; i++){
            //if("USER".equals(listUserRoles.get(i).getRole().getName())){
               // return listUserRoles.get(i).getRole().getName();
           // }
        }
       
        return null;
    }
    
}
