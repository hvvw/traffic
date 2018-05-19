package com.huwang.traffic_portal.dao;

import com.huwang.traffic_portal.entity.FacilitiesEntity;
import com.huwang.traffic_portal.entity.UserEntity;
import com.huwang.traffic_portal.util.CommonUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Transactional
@Repository("UserDao")
public class UserDao extends BaseDao {

    @Transactional
    public void deleteEntity(final Object entity) {
        super.deleteEntity(entity);
    }

    @Transactional
    public void updateEntity(UserEntity entity) {
        String sql = "update t_user set token= ? where id= ?";
        Query query = currentSession().createSQLQuery(sql);
        query.setString(0,entity.getToken());
        query.setInteger(1,entity.getId());
        query.executeUpdate();
    }

    @Transactional
    public List<UserEntity> getUsers(String account, String passwd) {
        if (account != null && passwd != null) {
            String hql = "from UserEntity where account = :account"
                    + " and passwd = :passwd";
            Query query = currentSession().createQuery(hql);
            query.setString("account", account);
            query.setString("passwd", passwd);
            List<UserEntity> list = query.list();
            return list == null ? Collections.EMPTY_LIST : list;
        }
        return Collections.EMPTY_LIST;
    }

    @Transactional
    public List<UserEntity> getUsersByToken(String token) {
        if (token != null) {
            String hql = "from UserEntity where token = :token";
            Query query = currentSession().createQuery(hql);
            query.setString("token", token);
            List<UserEntity> list = query.list();
            return list == null ? Collections.EMPTY_LIST : list;
        }
        return Collections.EMPTY_LIST;
    }

}
