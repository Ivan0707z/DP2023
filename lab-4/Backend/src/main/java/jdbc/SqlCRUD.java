package jdbc;

import entity.DeviceEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import servlet.CRUDConfig;
import servlet.CRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlCRUD implements CRUDInterface<DeviceEntity> {
    Connection connection;
    List<DeviceEntity> list = new ArrayList<>();

    public SqlCRUD() {
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(DeviceEntity deviceEntity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(DeviceEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            int id = CRUDConfig.getNextId(list);

            session.save(new DeviceEntity(
                    id,
                    deviceEntity.getName(),
                    deviceEntity.getType(),
                    deviceEntity.getImage(),
                    deviceEntity.getAmount(),
                    deviceEntity.getDescription(),
                    deviceEntity.getPrice())
            );
            session.getTransaction().commit();
        }
    }

    @Override
    public List<DeviceEntity> read() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(DeviceEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            list = (List<DeviceEntity>) session.createQuery("from DeviceEntity").list();

            session.getTransaction().commit();
        }

        return list;
    }

    @Override
    public void update(int id, DeviceEntity deviceEntity) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(DeviceEntity.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            DeviceEntity updateDevice = new DeviceEntity(
                    id,
                    deviceEntity.getName(),
                    deviceEntity.getType(),
                    deviceEntity.getImage(),
                    deviceEntity.getAmount(),
                    deviceEntity.getDescription(),
                    deviceEntity.getPrice()
            );

            session.update(updateDevice);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement st = connection
                .prepareStatement("DELETE FROM devices WHERE id=?;")) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
