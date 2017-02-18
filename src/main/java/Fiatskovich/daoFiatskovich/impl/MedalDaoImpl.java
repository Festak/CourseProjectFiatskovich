package Fiatskovich.daoFiatskovich.impl;

import Fiatskovich.daoFiatskovich.MedalDao;
import Fiatskovich.modelFiatskovich.Medal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Евгений on 18.02.2017.
 */
@Repository
public class MedalDaoImpl implements MedalDao {
private SessionFactory sessionFactory;

    @Override
    public void addMedal(Medal medal) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(medal);
        System.out.println(medal.toString());
    }

    @Override
    public void updateMedal(Medal medal) {
Session session = this.sessionFactory.getCurrentSession();
        session.update(medal);
        System.out.println(medal.toString());
    }

    @Override
    public void removeMedal(int id) {
Session session = this.sessionFactory.getCurrentSession();
        Medal medal = (Medal)session.load(Medal.class, new Integer(id));
        if(medal!=null){
            session.delete(medal);
        }
    }

    @Override
    public Medal getMedal(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Medal medal = (Medal)session.load(Medal.class, new Integer(id));
        return medal;
    }

    @Override
    public List<Medal> getAllMedals() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Medal> medals = session.createQuery("from Medal").list();
      return medals;
    }
}
