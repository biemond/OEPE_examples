package nl.amis.web.beans;

//import javax.cache.annotation.CacheDefaults;
//import javax.cache.annotation.CacheKeyParam;
//import javax.cache.annotation.CachePut;
//import javax.cache.annotation.CacheResult;
//import javax.cache.annotation.CacheValue;
import javax.inject.Named;



@Named
//@CacheDefaults( cacheName = "test")
public class JCachebean {

//   @CacheResult
   public String findKey( String id ){
	   return "notFound";
   }

//   @CachePut
   public void storeKey( String id, 
		   				 String value){
   }
	
}
