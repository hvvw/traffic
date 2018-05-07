package com.huwang.traffic_portal.dao;

import com.huwang.traffic_portal.entity.LoadEntity;
import com.huwang.traffic_portal.util.CommonUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;


@Transactional
@Repository("LoadDao")
public class LoadDao extends BaseDao {

    @Transactional
    public void deleteEntity(final Object entity) {
        super.deleteEntity(entity);
    }

    @Transactional
    public void updateEntity(final Object entity) {
        super.updateEntity(entity);
    }

    @Transactional
    public List<LoadEntity> getLoads(Double lat,Double lng,Integer unit)
    {
        if (lat!=null&&lng!=null&&unit!=null) {
            /*criteria.add(Restrictions.between("pointLat",lat-CommonUtils.ZoomTransform(unit),lat+CommonUtils.ZoomTransform(unit)));
            criteria.add(Restrictions.between("pointLng",lat-CommonUtils.ZoomTransform(unit),lat+CommonUtils.ZoomTransform(unit)));
            criteria.add(Restrictions.le("showLevel",unit));
            criteria.add(Restrictions.eq("display",true));*/
            String hql="from LoadEntity where pointLat between "+(lat-CommonUtils.ZoomTransform(unit))+" and "+(lat+CommonUtils.ZoomTransform(unit))
                    +" and pointLng between "+(lng-CommonUtils.ZoomTransform(unit))+" and "+(lng+CommonUtils.ZoomTransform(unit))
                    +" and showLevel <= " +unit
                    +" and display = "+true;
            Query query=currentSession().createQuery(hql);
            List<LoadEntity> list = query.list();
            return list == null ? Collections.EMPTY_LIST : list;
        }
        return Collections.EMPTY_LIST;
    }
}