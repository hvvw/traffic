package com.huwang.traffic_portal.dao;

import com.huwang.traffic_portal.entity.AgencyEntity;
import com.huwang.traffic_portal.util.CommonUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Transactional
@Repository("AgencyDao")
public class AgencyDao extends BaseDao {

    @Transactional
    public void deleteEntity(final Object entity) {
        super.deleteEntity(entity);
    }

    @Transactional
    public void updateEntity(final Object entity) {
        super.updateEntity(entity);
    }

    @Transactional
    public List<AgencyEntity> getAgency(Double lat, Double lng, Integer unit)
    {
        if (lat!=null&&lng!=null&&unit!=null) {
            String hql="from AgencyEntity where lat between "+(lat-CommonUtils.ZoomTransform(unit))+" and "+(lat+CommonUtils.ZoomTransform(unit))
                    +" and lng between "+(lng-CommonUtils.ZoomTransform(unit))+" and "+(lng+CommonUtils.ZoomTransform(unit));
            Query query=currentSession().createQuery(hql);
            List<AgencyEntity> list = query.list();
            return list == null ? Collections.EMPTY_LIST : list;
        }
        return Collections.EMPTY_LIST;
    }
}
