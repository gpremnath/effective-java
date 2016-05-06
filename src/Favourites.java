import java.util.*;

public class Favourites{
	
	private Map <Class<?>,Object> favourites=
		new HashMap<Class<?>, Object> ();

	public <T> void putFavourite(Class <T> type, T instance){
		if(type==null)
			throw new NullPointerException("Type is null");
		favourites.put(type,type.cast(instance));
	}
	
	public <T> T getFavourite(Class <T> type){
		
		return type.cast(favourites.get(type));
	}

}
