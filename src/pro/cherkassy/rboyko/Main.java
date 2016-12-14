package pro.cherkassy.rboyko;


import pro.cherkassy.rboyko.beans.Car;
import pro.cherkassy.rboyko.beans.Cat;
import pro.cherkassy.rboyko.beans.Human;

import java.lang.reflect.Field;

public class Main {
    /*
    protected Car car;
    protected Cat cat;
    protected Human human;*/

    public static void main(String[] args) {

        AppContext context=new AppContext(AppConfig.class);
        Cat cat=(Cat)context.getBean(Cat.class);
        Car car=(Car)context.getBean(Car.class);
        Human human=(Human)context.getBean(Human.class);

        /** Task 1 **/
        Main.BeanRepresenter.display(car);
        Main.BeanRepresenter.display(cat);
        Main.BeanRepresenter.display(human);

        /** Task 2 **/
        Car car1=CloneCreator.<Car>clone(car);
        Cat cat1=CloneCreator.<Cat>clone(cat);
        Human human1=CloneCreator.<Human>clone(human);

        /** Task 3 **/
        car.setColor("read");
        BeanComparator.compare(car,car1);
    }


    static class   BeanRepresenter{
        public static void display(Object obj){
            Class clazz=obj.getClass();
            System.out.println("Class name: "+clazz.getSimpleName());
            Field[] fields=clazz.getDeclaredFields();
            for (Field field:fields) {
                field.setAccessible(true);
                try {
                    System.out.println("\t\t\t" + field.getName() + "=" + field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CloneCreator{
        public static <T> T clone(T obj){
            Class clazz=obj.getClass();
            T newObj= null;
            try {
                newObj = (T) clazz.newInstance();
                Field[] fields=clazz.getDeclaredFields();
                for (Field field:fields) {
                    String name = field.getName();
                    field.setAccessible(true);
                    Field newObjFild;
                    newObjFild = newObj.getClass().getDeclaredField(name);
                    newObjFild.setAccessible(true);
                    newObjFild.set(newObj, field.get(obj));
                }
            } catch (NoSuchFieldException e) {
                   return null;
            } catch (IllegalAccessException e) {
                    return null;
            } catch (InstantiationException e) {
                    return null;
            }
            return newObj;
        }
    }

    static class BeanComparator{
        public static void compare(Object a,Object b){
            if(a.getClass()!=b.getClass()) {
                System.out.println("A           B         Match");
                System.out.println(a.getClass().getSimpleName()+"   "+b.getClass().getSimpleName()+"  "+"No equals ");
                return;
            }
            System.out.println("Field          A          B          Match");
            for(Field aField:a.getClass().getDeclaredFields()){
                Object aFieldVal=null;
                Object bFieldVal=null;
                String fMatch="-";
                try {
                    Field bField=b.getClass().getDeclaredField(aField.getName());
                    aField.setAccessible(true);
                    bField.setAccessible(true);

                    aFieldVal=aField.get(a);
                    bFieldVal=bField.get(b);

                    if(aFieldVal.equals(bFieldVal))
                        fMatch="+";
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NullPointerException e){
                    if(aFieldVal==null && bFieldVal==null)
                        fMatch="+";
                }
                System.out.printf("%-15s%-11s%-11s%s\n",aField.getName(),aFieldVal,bFieldVal,fMatch);
            }
        }
    }
}
