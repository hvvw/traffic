package com.huwang.traffic_portal.dao;

import com.huwang.traffic_portal.entity.Point;
import com.huwang.traffic_portal.util.CommonUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Transactional
@Repository("PointDao")
public class PointDao extends BaseDao {

    @Transactional
    public void deleteEntity(final Object entity) {
        super.deleteEntity(entity);
    }

    @Transactional
    public void updateEntity(final Object entity) {
        super.updateEntity(entity);
    }

    @Transactional
    public void saveEntity(Point entity) {
        String sql = "insert into t_point (lng,lat,type,p_id)  values(?,?,?,?)";
        Query query= currentSession().createSQLQuery(sql);
        query.setDouble(0, entity.getLng());
        query.setDouble(1, entity.getLat());
        query.setString(2,entity.getType());
        query.setInteger(3,entity.getParentId());
        query.executeUpdate();
    }

    @Transactional
    public List<Point> getPoints(Integer id,String type)
    {
        Criteria criteria = currentSession().createCriteria(Point.class);
        if (id!=null&&type!=null&&!type.equals("")) {
            criteria.add(Restrictions.eq("parentId",id));
            criteria.add(Restrictions.eq("type",type));
            List<Point> list = criteria.list();
            return list == null ? Collections.EMPTY_LIST : list;
        }
        return Collections.EMPTY_LIST;
    }
}
