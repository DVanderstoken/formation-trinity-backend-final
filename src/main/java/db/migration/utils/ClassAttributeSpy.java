package db.migration.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class ClassAttributeSpy {

    private static ClassAttributeSpy INSTANCE = null;
    private static final Object SYNCHRONIZED_OBJECT = new Object();

    /*
     * private constructor
     */
    private ClassAttributeSpy() {

    }

    public static ClassAttributeSpy getInstance() {

        if (INSTANCE == null) {
            synchronized (SYNCHRONIZED_OBJECT) {
                INSTANCE = new ClassAttributeSpy();
            }
        }

        return INSTANCE;

    }

    public String[] getAttributesList(Class<?> clazz) {

        String[] result = null;

        try {

            Class<?> c = Class.forName(clazz.getName());

            Field[] fields = c.getDeclaredFields();

            result = new String[fields.length];

            int i = 0;

            for (Field field : fields) {

                if (field.isAnnotationPresent(javax.persistence.Column.class)) {

                    result[i] = field.getName();

                    i++;

                }

            }

            result = ArrayUtils.removeElement(result, null);

        } catch (ClassNotFoundException e) {

            System.out.println("ERROR MESSAGE : " + e.getMessage());
            System.out.println("ERROR CAUSE : " + e.getCause());

        }

        return result;

    }

    public String[] getTableColumnList(Class<?> clazz) {

        String[] result = null;

        try {

            Class<?> c = Class.forName(clazz.getName());

            Field[] fields = c.getDeclaredFields();

            result = new String[fields.length];

            int i = 0;

            for (Field field : fields) {

                Column col = field.getAnnotation(Column.class);

                result[i] = StringUtils.trimToNull(col.name()) == null ? field
                        .getName() : col.name();

                i++;

            }

        } catch (ClassNotFoundException e) {

            System.out.println("ERROR MESSAGE : " + e.getMessage());
            System.out.println("ERROR CAUSE : " + e.getCause());

        }

        return result;

    }

    public String[] getMethodsList(Class<?> clazz) {

        String[] result = null;

        try {

            Class<?> c = Class.forName(clazz.getName());

            Method[] methods = c.getDeclaredMethods();

            result = new String[methods.length];

            int i = 0;

            for (Method method : methods) {

                result[i] = method.getName();

                i++;

            }

        } catch (ClassNotFoundException e) {

            System.out.println("ERROR MESSAGE : " + e.getMessage());
            System.out.println("ERROR CAUSE : " + e.getCause());

        }

        return result;

    }

    public String[] getGetterMethodsList(Class<?> clazz) {

        String[] result = null;

        String[] allMethods = getMethodsList(clazz);

        int i = 0;
        int j = allMethods.length;

        result = new String[allMethods.length];

        for (int z = 0; z < j; z++) {

            String method = allMethods[z];

            if (StringUtils.startsWith(method, "get")) {

                result[i] = method;

                i++;

            }

        }

        result = Arrays.copyOf(result, i);

        return result;
    }

    public Table getTableAnnotation(Class<?> clazz)
            throws NullPointerException, IndexOutOfBoundsException {

        Table[] tables = clazz
                .getAnnotationsByType(javax.persistence.Table.class);

        if (tables.length > 1) {

            throw new IndexOutOfBoundsException();
        }

        return tables[0];
    }

}
