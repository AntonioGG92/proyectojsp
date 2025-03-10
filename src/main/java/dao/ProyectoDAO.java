package dao;

import modelo.Proyecto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class ProyectoDAO {

    public void guardarProyecto(Proyecto proyecto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(proyecto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Proyecto obtenerProyecto(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Proyecto.class, id);
        }
    }

    public List<Proyecto> listarProyectos(String estado) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Proyecto";
            if (estado != null && !estado.isEmpty()) {
                hql += " WHERE estado = :estado";
                return session.createQuery(hql, Proyecto.class)
                              .setParameter("estado", estado)
                              .list();
            } else {
                return session.createQuery(hql, Proyecto.class).list();
            }
        }
    }

    public void actualizarProyecto(Proyecto proyecto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(proyecto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void eliminarProyecto(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Proyecto proyecto = session.get(Proyecto.class, id);
            if (proyecto != null) {
                transaction = session.beginTransaction();
                session.delete(proyecto);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
