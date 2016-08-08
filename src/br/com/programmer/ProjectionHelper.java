package br.com.programmer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.programmer.exception.ProjectionHelperException;
/**
 * 
 * @author Lucas Reis
 * @Email lucas@programmer.com.br
 * {@link www.programmer.com.br}
 *
 */
public class ProjectionHelper {

	/**
	 * 
	 * It will return the a List<T> of the type of the clazz parameter.
	 * 
	 * @param clazz
	 * @param resultList
	 * @param aliases
	 * @return
	 * @throws ProjectionHelperException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> transformList(Class clazz, List<Object []> resultList, String[] aliases) throws ProjectionHelperException{
		
		if(resultList.get(0).length != aliases.length){
			throw new ProjectionHelperException("The number of values and aliases must be the same.");
		}
		List<T> genericList = new ArrayList<T>();
		List<List<String>> aliasesList = getAliases(aliases);
		try{
			for (Object [] objList : resultList) {
				T t = (T) clazz.newInstance();
				for (int i = 0; i < objList.length; i++) {
					t = (T) createObject(t, aliasesList.get(i), objList[i]);
				}
				genericList.add(t);
			}
		}catch(Exception e){
			throw new ProjectionHelperException(e);
		}
		return genericList;
	}
	
	private List<List<String>> getAliases(String[] aliases){
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> _list = new ArrayList<String> ();
		for (String string : aliases) {
			_list = new ArrayList<String>(Arrays.asList(string.split("\\.")));
			list.add(_list);
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> Object createObject(Object obj, final List<String> aliases, Object value) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ArrayList<String> aliasesCopy = new ArrayList<String>(aliases);
		Field f;
		Class clazz;
		T t;
		if(aliasesCopy.size() > 1){//check if it is the attribute which the value should be set
			f = obj.getClass().getDeclaredField(aliasesCopy.get(0));
			f.setAccessible(true);
			aliasesCopy.remove(0);
			if(f.get(obj) == null){//check if attribute object has already been instantiated
				t = (T) Class.forName(f.getType().getName()).newInstance();
				f.set(obj, createObject(t, aliasesCopy, value));
			}else{//if so
				f.set(obj, createObject(f.get(obj), aliasesCopy, value));
			}
		}else{
			f = obj.getClass().getDeclaredField(aliasesCopy.get(0));
			f.setAccessible(true);
			f.set(obj, value);
		}
		return obj;
	}
}
