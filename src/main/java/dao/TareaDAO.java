package dao;

import modelo.Tarea;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class TareaDAO {

    public void guardarTarea(Tarea tarea) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tarea);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Tarea obtenerTarea(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Tarea.class, id);
        }
    }

    public List<Tarea> listarTareasPorProyecto(int idProyecto) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Tarea WHERE proyecto.id = :idProyecto";
            return session.createQuery(hql, Tarea.class)
                          .setParameter("idProyecto", idProyecto)
                          .list();
        }
    }

    public void actualizarTarea(Tarea tarea) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tarea);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void eliminarTarea(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Tarea tarea = session.get(Tarea.class, id);
            if (tarea != null) {
                transaction = session.beginTransaction();
                session.delete(tarea);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
