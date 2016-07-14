/**
 * @(#) ReflectionExample.java
 *      Copyright © 2016 - Arka Ghosh. All rights reserved.
 *      Usage is subject to license terms. Any unauthorized usage will be prosecuted.
 */
package practice.challenges;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author 403238
 * @since Jul 14, 2016
 * @version 1.0
 */
public class ReflectionExample
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		getReflection(String.class);
		System.out.println("");
		getReflection(Date.class);
		System.out.println("");
		getReflection(ArrayList.class);
	}

	private static void getReflection(Class<?> clazz)
	{
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("Field " + field.getName() + " of type " + field.getType() + " in class " + clazz);
		}
	}

}
