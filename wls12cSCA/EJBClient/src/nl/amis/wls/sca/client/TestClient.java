package nl.amis.wls.sca.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import nl.amis.wls.sca.spring.ILoggerComponent;

public class TestClient {

    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            ILoggerComponent logEJB = (ILoggerComponent)context.lookup("LoggerService_EJB30_JNDI");
            logEJB.log("aaa", "bbb", "ccc");
            System.out.println("end");            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	
	
    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put( Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext( env );
    }
}
