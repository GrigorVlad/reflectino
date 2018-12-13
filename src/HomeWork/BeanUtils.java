package HomeWork;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BeanUtils {

    public static void assign(Object from, Object to) {

        Map<String, Method> gettersFrom = getAllGettersFor(from); //new HashMap<>();
        Map<String, Method> settersTo = getAllSettersFor(to); //new HashMap<>();


        for (Map.Entry<String, Method> pairFrom : gettersFrom.entrySet()) {
            for (Map.Entry<String, Method> pairTo : settersTo.entrySet()) {
                if (pairFrom.getKey().equals(pairTo.getKey())
                        && pairFrom.getValue().getReturnType().equals(pairTo.getValue().getParameterTypes()[0])
                ) {

                    try {
                        Object valueFrom = pairFrom.getValue().invoke(from);
                        pairTo.getValue().invoke(to, valueFrom);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        //
                    }

                    break;
                }

            }

        }

    }

    private static Map<String, Method> getAllSettersFor(Object object) {

        Map<String, Method> map = new HashMap<>();

        for (Field field : getAllFields(object)) {

            String setterName = "set" + capitalize(field.getName());

            for (Method method : getMethods(object)) {
                if (method.getName().equals(setterName)
                        && method.getParameterTypes()[0].isAssignableFrom(field.getType())
                ) {
                    map.put(field.getName(), method);
                    break;
                }
            }
        }

        return map;
    }



    private static Map<String, Method> getAllGettersFor(Object object) {

        Map<String, Method> map = new HashMap<>();

        for (Field field : getAllFields(object)) {

            String getterName = "get" + capitalize(field.getName());

            for (Method method : getMethods(object)) {

                if ( method.getName().equals(getterName)
                        && method.getReturnType().isAssignableFrom(field.getType())
                ) {
                    map.put(field.getName(), method);
                }
            }
        }

        return map;
    }



    private static List<Method> getMethods(Object object) {
        List<Method> methods = new ArrayList<>();

        Class<?> clazz = object.getClass();

        while (clazz != null) {
            methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
            clazz = clazz.getSuperclass();
        }

        return methods;
    }



    private static List<Field> getAllFields(Object object) {
        List<Field> fields = new ArrayList<>();

        Class<?> clazz = object.getClass();

        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        return fields;
    }



    private static String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }



}
