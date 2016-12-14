package pro.cherkassy.rboyko;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import pro.cherkassy.rboyko.annotations.Bean;
import pro.cherkassy.rboyko.annotations.Value;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by rboyko on 13.12.16.
 */
public class AppContext {
    protected Class clazz=null;
    AppContext(Class clazz){
        this.clazz=clazz;

    }

    Object getBean(Class clazz){
        Method[] methods=this.clazz.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Bean.class)) {
                try {
                    Class methodReturnType=method.getReturnType();
                    if(clazz.equals(methodReturnType))
                        return injectionAnnotated(method.invoke(this.clazz.newInstance()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    protected Object injectionAnnotated(Object obj){
        Method[] methods=obj.getClass().getDeclaredMethods();
        for (Method method:methods){
            if(method.isAnnotationPresent(Value.class)){
                Value annotated=method.getAnnotation(Value.class);
                String value=annotated.val();
                Class vType=annotated.type();
                Constructor vTypeConst=null;
                Object vTypeObj=null;

                try {
                    vTypeConst=vType.getConstructor(String.class);
                    vTypeObj=vTypeConst.newInstance(value);
                    method.invoke(obj,vTypeObj);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return obj;
    }
}
