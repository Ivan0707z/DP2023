package jdbc;

import entity.DeviceEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {

        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(DeviceEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new DeviceEntity(
                    1,
                    "Dark Project One",
                    "Клавіатура",
                    "https://img.telemart.ua/455829-595202-product_popup/dark-project-one-kd87a-pbt-mechanical-g3ms-sapphire-dp-kd-87a-000100-gmt-black.png",
                    45,
                    "Keyboard Dark Project One KD87A",
                    3499
            ));
            session.save(new DeviceEntity(
                    2,
                    "Varmilo",
                    "Клавіатура",
                    "https://img.moyo.ua/img/products/5252/66_600.jpg?1681132881",
                    10,
                    "Varmilo VEA87 Lovebirds-I",
                    8399
            ));
            session.save(new DeviceEntity(
                    3,
                    "HATOR",
                    "Клавіатура",
                    "https://shop.hator.gg/wp-content/uploads/2020/09/hator-white-rockfall-tkl-evo_800_1-1.png",
                    25,
                    "HATOR ROCKFALL EVO TKL",
                    3299
            ));
            session.save(new DeviceEntity(
                    4,
                    "Razer Huntsman",
                    "Клавіатура",
                    "https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/61Az2uOUbqL.jpg",
                    25,
                    "Razer Huntsman Mini 60% Gaming Keyboard",
                    3599
            ));
            session.save(new DeviceEntity(
                    5,
                    "Razer BlackWidow",
                    "Клавіатура",
                    "https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/61CSwhgO7xL._AC_SX425_.jpg",
                    7,
                    "Razer BlackWidow Elite Yellow Switch",
                    5505
            ));
            session.save(new DeviceEntity(
                    6,
                    "Razer DeathAdder",
                    "Миша",
                    "https://hotline.ua/img/tx/265/2652571025.jpg",
                    54,
                    "Razer DeathAdder V2",
                    1699
            ));
            session.save(new DeviceEntity(
                    7,
                    "Logitech G102",
                    "Миша",
                    "https://img.telemart.ua/301584-613187-product_popup/logitech-g102-lightsync-910-005801-blue.png",
                    120,
                    "Logitech G102 Lightsync USB Lilac",
                    1199
            ));
            session.save(new DeviceEntity(
                    8,
                    "SteelSeries",
                    "Миша",
                    "https://content1.rozetka.com.ua/goods/images/big/216125668.jpg",
                    32,
                    "SteelSeries Rival 5",
                    2999
            ));



            session.getTransaction().commit();

        }
        System.out.println("You added all data in tents table! :D");
    }
}
