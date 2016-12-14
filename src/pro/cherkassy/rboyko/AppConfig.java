package pro.cherkassy.rboyko;

import pro.cherkassy.rboyko.annotations.Bean;
import pro.cherkassy.rboyko.beans.Car;
import pro.cherkassy.rboyko.beans.Cat;
import pro.cherkassy.rboyko.beans.Human;


/**
 * Created by rboyko on 13.12.16.
 */
public class AppConfig {
    @Bean
    Cat getCat(){
        return new Cat();
    }
    @Bean
    Car getCar(){
        return new Car();
    }
    @Bean
    Human getHuman(){
        return new Human();
    }
}
