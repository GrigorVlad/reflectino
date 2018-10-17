package HomeWork;

import java.lang.reflect.Method;

public class BeanUtils {

    public static void assign(Object from, Object to) {
        Class<?> clazz1 = from.getClass();
        Class<?> clazz2 = to.getClass();
        for (Method method : clazz1.getMethods()) {
            if (method.getName().contains("get")) {
                String str = "set" + method.getName().substring(3);
                try {
                    Method m = clazz2.getMethod(str, method.invoke(from).getClass());
                    m.invoke(to, method.invoke(from));
                } catch (Exception ex) {
                    continue;
                }
            }
        }
    }
}
